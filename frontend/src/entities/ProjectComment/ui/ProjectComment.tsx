//comments 배열을 props로 받아서 map으로 뿌려줄거임 comments배열 저장해서 전달하는건 pages에서 함
//input값을 어떻게 상위 페이지에 전달하냐는 건데.... usestate()의 setter말고 그냥 데이터만 보내주면 될것같음 -> props?

//댓글작성 버튼 클릭 메서드 feature에서 가져옴
import { CommentData, Comment } from '../../../shared/types/comments.ts';
import { postComment } from '../api/comments.ts';
import { useState } from 'react';
import { useMutation } from '@tanstack/react-query';
import { useParams } from 'react-router-dom';

export const ProjectComment = (comments: CommentData) => {
  const currentUser = 'string'; //유저정보 조회 API로 받아옴
  const [input, setInput] = useState('');
  const { projectId } = useParams();
  const token = 'sd'; //임시

  //나중에 feature에 쓸거임
  //projectId, accessToken은 useref, storage에서 가져옴
  // import useStore from './useStore'
  // import { useTokenStore } from './stores/useTokenStore'
  //
  // const token = useStore(useTokenStore, (state) => state.bears)
  //useeffect로 id, token값 화면 렌더링되자마자 바로 set되도록

  interface PostComment {
    projectId: number;
    accessToken: string;
    content: string;
  }

  const mutation = useMutation({ mutationFn: (comment: PostComment) => postComment(comment) });
  const writeComment = (input: string) => {
    if (projectId && token) {
      const comment: PostComment = { projectId: parseInt(projectId, 10), accessToken: token, content: input };
      mutation.mutate(comment);
    }
    //mutation
    console.log('댓글 내용:', input);
  };

  return (
    <div className="bg-[#0F1012] w-[100vw] box-sizing-border">
      <div className="relative flex flex-col w-[68rem] pt-[5rem] mr-auto ml-auto box-sizing-border">
        <div className="rounded-[0.3rem] mb-[4rem] flex flex-col w-[100%] box-sizing-border">
          <div className="m-[0_0_3.3rem_0] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
            {comments.totalCount}개의 댓글
          </div>
          <input
            placeholder="댓글을 작성하세요."
            value={input}
            onChange={(e) => {
              setInput(e.target.value);
            }}
            className="placeholder-white bg-transparent w-[100%] border-none m-[0_0_1.5rem_0] inline-block self-start break-words font-['Inter'] font-normal text-[1.1rem] text-[#FFFFFF]"
          ></input>
          <div className="bg-[#989898] w-[100%] h-[0.1rem]"></div>
          <button
            onClick={() => writeComment(input)}
            className="rounded-[0.3rem] mt-[2rem] bg-[#696868] relative flex flex-row justify-center items-center self-end w-[6.5rem] h-[2.3rem] box-sizing-border"
          >
            <span className="break-words font-['Pretendard'] font-semibold text-[1rem] mt-[0.1rem] tracking-[0.1rem] text-[#FFFFFF]">
              댓글 작성
            </span>
          </button>
        </div>
        <>
          {/*댓글 목록*/}
          {comments.comments &&
            comments.comments.map((comment: Comment) => {
              <div key={comment.commentId} className="w-[100%] mb-[1.5rem]">
                <div className="flex justify-between self-start w-[100%] box-sizing-border mb-[3rem] font-['Pretendard']">
                  <div className="flex flex-row">
                    <div className="rounded-[16.3rem] bg-[url('/src/shared/assets/image/BigProfileImg.png')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_1.3rem_0_0] w-[4.1rem] h-[4.1rem]"></div>
                    <div className="m-[0.5rem_0_0.6rem_0] flex flex-col flex-start box-sizing-border">
                      <div className="m-[0_0_0.6rem_0] inline-block break-words font-semibold text-[1.1rem] text-[#FFFFFF]">
                        {comment.nickname}
                      </div>
                      <span className="m-[0_0.7rem_0_0] break-words font-normal text-[0.8rem] text-[#CCCCCC]">
                        {comment.createdAt.replace('T', ' ')}
                      </span>
                    </div>
                  </div>
                  {comment.nickname == currentUser ? (
                    <div className="m-[1.7rem_0rem_1.5rem_0] inline-block break-words font-normal text-[0.8rem] text-[#CCCCCC]">
                      수정 삭제
                    </div>
                  ) : (
                    <div></div>
                  )}
                </div>
                <span className="self-start break-words font-normal text-[1rem] text-[#FFFFFF]">{comment.content}</span>
                <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
              </div>;
            })}
        </>
      </div>
    </div>
  );
};
