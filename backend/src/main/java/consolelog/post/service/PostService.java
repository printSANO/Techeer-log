package consolelog.post.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.AuthorizationException;
import consolelog.auth.service.AuthService;
import consolelog.like.repository.PostLikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.post.domain.Post;
import consolelog.post.domain.ViewCountManager;
import consolelog.post.dto.request.NewPostRequest;
import consolelog.post.dto.request.PostUpdateRequest;
import consolelog.post.dto.response.PagePostResponse;
import consolelog.post.dto.response.PostResponse;
import consolelog.post.exception.PostNotFoundException;
import consolelog.post.repository.PostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository; // final로 선언하면 생성자에서만 값을 할당할 수 있음
    private final MemberRepository memberRepository;
    private final AuthService authService;
    private final PostLikeRepository postLikeRepository;
    private final ViewCountManager viewCountManager;

    public PostService(PostRepository postRepository, MemberRepository memberRepository,
                       AuthService authService, PostLikeRepository postLikeRepository,
                       ViewCountManager viewCountManager) { // 생성자 주입
        this.postRepository = postRepository;  // 생성자를 통해 PostRepository를 주입받음
        this.memberRepository = memberRepository;
        this.authService = authService;
        this.postLikeRepository = postLikeRepository;
        this.viewCountManager = viewCountManager;
    }


    @Transactional
    public PostResponse findPost(Long postId, String cookieValue) {// post_id 게시글 조회
        if (viewCountManager.isFirstAccess(cookieValue, postId)) {
            postRepository.updateViewCount(postId);
        }
        Post findPost = findPostById(postId);
        return PostResponse.of(findPost);
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
    }

    public String updatePostLog(Long postId, String cookieValue) {
        return viewCountManager.getUpdateLog(cookieValue, postId);
    }

    public PagePostResponse findPostsByPage(Long lastPostId, Pageable pageable) {
        Slice<Post> posts;
        if (lastPostId == -1) {
            posts = postRepository.findNextPage(pageable);
        } else {
            posts = postRepository.findPostByIdIsLessThanOrderByIdDesc(lastPostId, pageable);
        }
        return PagePostResponse.of(posts);

    }

    public PostResponse findTitle(String title) {// post_title 게시글 조회
        Post findPost = findPostByTitle(title);
        return PostResponse.of(findPost);
    }

    private Post findPostByTitle(String title) {
        return postRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. title=" + title));
    }

    @Transactional
    public Long addPost(NewPostRequest newPostRequest, AuthInfo authInfo) {
        Member member = findMember(authInfo);
        Post post = createPost(newPostRequest, member);
        Optional<Post> savedPost = Optional.of(postRepository.save(post));
        return savedPost.orElseThrow(() -> new IllegalArgumentException("x")).getId();
    }

    private Member findMember(AuthInfo authInfo) {
        return memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
    }

    private Post createPost(NewPostRequest newPostRequest, Member member) {
        return Post.builder()
                .title(newPostRequest.getTitle())
                .content(newPostRequest.getContent())
                .member(member)
                .build();
    }

    @Transactional
    public void updatePost(Long id, PostUpdateRequest postUpdateRequest, AuthInfo authInfo) {
        Post post = findPostById(id);
        validateOwner(authInfo, post);
        post.updateTitle(postUpdateRequest.getTitle());
        post.updateContent(postUpdateRequest.getContent());
    }


    @Transactional
    public void deletePost(Long id, AuthInfo authInfo) {
        Post post = findPostById(id);
        validateOwner(authInfo, post);
        postRepository.delete(post);
        //postRepository.deleteById(id);
    }


    //모든 게시물 조회 - 페이징 처리

    private void validateOwner(AuthInfo authInfo, Post post) {
        if (!post.isOwner(authInfo.getId())) {
            throw new AuthorizationException();
        }
    }

}



