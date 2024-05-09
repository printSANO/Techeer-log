//input값을 어떻게 상위 페이지에 전달하냐는 건데.... usestate()의 setter말고 그냥 데이터만 보내주면 될것같음 -> props?

import { Comment } from '../../../shared/types/comments.ts';
import { postComment, putComment, deleteComment } from '../api/comments.ts';
import { useState } from 'react';
import { useMutation, useQueryClient } from '@tanstack/react-query';

interface ProjectCommentProps {
  comments: Comment[];
  totalCount: number;
  projectId: number;
}
interface PostComment {
  projectId?: number;
  commentId?: number;
  content: string;
}

export const ProjectComment = (data: ProjectCommentProps) => {
  const { comments, totalCount, projectId } = data;
  const queryClient = useQueryClient();

  const currentUser = 'string'; //유저정보 조회 API로 받아옴
  const [isEditing, setIsEditing] = useState(false);
  const [input, setInput] = useState('');
  console.log('??', comments[0]);

  // 나중에 feature에 쓸거임
  // accessToken storage에서 가져옴
  // import useStore from './useStore'
  // import { useTokenStore } from './stores/useTokenStore'
  //
  // const token = useStore(useTokenStore, (state) => state.bears)

  // comment는 클라이언트 -> 서버 보내는 데이터
  // comments는 get요청으로 받아온 댓글 데이터

  const submitComment = (input: string) => {
    if (projectId) {
      const comment: PostComment = { projectId: projectId, content: input };
      postMutation.mutate(comment);
      setInput('');
    }
    console.log('댓글 내용:', input);
  };

  const clickEditButton = (commentId: number) => {
    const editComment: PostComment = { commentId: commentId, content: input };
    putMutation.mutate(editComment);
    setIsEditing(false);
  };

  const clickDeleteButton = (commentId: number) => {
    //toast로 '삭제하시겠습니까?'
    deleteMutation.mutate(commentId);
  };

  const postMutation = useMutation({
    mutationFn: (comment: PostComment) => postComment(comment),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['comments'] });
    },
  });

  const putMutation = useMutation({
    mutationFn: (comment: PostComment) => putComment(comment),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['comments'] });
    },
  });

  const deleteMutation = useMutation({
    mutationFn: (commentId: number) => deleteComment(commentId),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['comments'] });
    },
  });

  return (
    <div className="bg-[#0F1012] w-[100vw] box-sizing-border">
      <div className="relative flex flex-col w-[68rem] pt-[5rem] mr-auto ml-auto box-sizing-border">
        <div className="rounded-[0.3rem] mb-[4rem] flex flex-col w-[100%] box-sizing-border">
          <div className="m-[0_0_3.3rem_0] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
            {totalCount}개의 댓글
          </div>
          <input
            placeholder="댓글을 작성하세요."
            value={input}
            onChange={(e) => {
              setInput(e.target.value);
            }}
            className="placeholder-white outline-none bg-transparent w-[100%] border-none m-[0_0_1rem_0] inline-block self-start break-words font-['Inter'] font-normal text-[1.1rem] text-[#FFFFFF]"
          ></input>
          <div className="bg-[#989898] w-[100%] h-[0.1rem]"></div>
          <button
            onClick={() => submitComment(input)}
            className="rounded-[0.3rem] mt-[2rem] bg-[#696868] relative flex flex-row justify-center items-center self-end w-[6.5rem] h-[2.3rem] box-sizing-border"
          >
            <span className="break-words font-['Pretendard'] font-semibold text-[1rem] mt-[0.1rem] tracking-[0.1rem] text-[#FFFFFF]">
              댓글 작성
            </span>
          </button>
        </div>
        <div>
          {/*댓글 목록*/}
          {comments &&
            comments.map((comment: Comment) => (
              <div key={comment.commentId} className="w-[100%] mb-[1.5rem]">
                <div className="flex justify-between self-start w-[100%] box-sizing-border font-['Pretendard']">
                  <div className="flex flex-row">
                    <div
                      style={{ backgroundImage: `url(${comment.profileImageUrl})` }}
                      className="rounded-[50%] bg-[50%_50%] bg-cover bg-no-repeat m-[0_1.3rem_0_0] w-[4rem] h-[4rem]"
                    ></div>
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
                    <div className="inline-block m-[1.7rem_0rem_1.5rem_0] break-words font-normal text-[0.8rem] text-[#CCCCCC] gap-4">
                      <span
                        onClick={(prev) => {
                          setIsEditing(!prev);
                        }}
                      >
                        수정
                      </span>
                      <span
                        onClick={() => {
                          clickDeleteButton(comment.commentId);
                        }}
                      >
                        삭제
                      </span>
                    </div>
                  ) : (
                    <div></div>
                  )}
                </div>
                {isEditing ? (
                  <div key={comment.commentId}>
                    <input
                      placeholder="댓글 수정"
                      value={input}
                      onChange={(e) => {
                        setInput(e.target.value);
                      }}
                      className="placeholder-white outline-none bg-transparent w-[100%] border-none m-[0_0_1rem_0] inline-block self-start break-words font-['Inter'] font-normal text-[1.1rem] text-[#FFFFFF]"
                    ></input>
                    <div className="bg-[#989898] w-[100%] h-[0.1rem]"></div>
                    <button
                      onClick={() => clickEditButton(comment.commentId)}
                      className="rounded-[0.3rem] mt-[2rem] bg-[#696868] relative flex flex-row justify-center items-center self-end w-[6.5rem] h-[2.3rem] box-sizing-border"
                    >
                      <span className="break-words font-['Pretendard'] font-semibold text-[1rem] mt-[0.1rem] tracking-[0.1rem] text-[#FFFFFF]">
                        수정하기
                      </span>
                    </button>
                  </div>
                ) : (
                  <div className=" my-[2rem] ml-[1rem] self-start break-words font-normal text-[1rem] text-[#FFFFFF]">
                    {comment.content}
                  </div>
                )}

                <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};
