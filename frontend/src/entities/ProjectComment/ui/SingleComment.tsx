import { Comment } from '../../../shared/types/comments.ts';
import { useState } from 'react';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import { deleteComment, putComment } from '../api/comments.ts';

interface PostComment {
  projectId?: number;
  commentId?: number;
  content: string;
}
interface SingleCommentProps {
  projectId: number;
  comment: Comment;
}
export const SingleComment: React.FC<SingleCommentProps> = ({ projectId, comment }) => {
  const [content, setContent] = useState(comment.content);
  const [isEditing, setIsEditing] = useState(false);
  const queryClient = useQueryClient();

  const currentUser = sessionStorage.getItem('nickname');

  const onCommentChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setContent(e.target.value);
    //한 글자 변할때마다 렌더링되는 이슈 해결
    // console.log(content);
  };
  const onClickModifyBtn = () => {
    setIsEditing((prev) => !prev);
    setContent('');
  };

  const clickEditButton = (commentId: number) => {
    const editComment: PostComment = { projectId: projectId, commentId: commentId, content: content };
    putMutation.mutate(editComment);
    setIsEditing(false);
  };

  const clickDeleteButton = (commentId: number) => {
    //toast로 '삭제하시겠습니까?'
    deleteMutation.mutate(commentId);
  };

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
          <div className="flex flex-row m-[1.7rem_0rem_1.5rem_0] break-words font-normal text-[0.8rem] text-[#CCCCCC] gap-2">
            <span
              onClick={() => {
                onClickModifyBtn();
              }}
              className="cursor-pointer hover:underline"
            >
              수정
            </span>
            <span
              onClick={() => {
                clickDeleteButton(comment.commentId);
              }}
              className="cursor-pointer hover:underline"
            >
              삭제
            </span>
          </div>
        ) : (
          <div></div>
        )}
      </div>
      {isEditing ? (
        <div key={comment.commentId} className="flex flex-col my-[2rem]">
          <input
            placeholder={comment.content}
            value={content}
            onChange={onCommentChange}
            className="placeholder-[#CCCCCC] ml-[1rem] outline-none bg-transparent w-[100%] border-none m-[0_0_1rem_0] inline-block self-start break-words font-normal text-[1rem] text-[#FFFFFF]"
          ></input>
          <div className="bg-[#989898] w-[100%] h-[0.05rem] mt-[1rem]"></div>
          <button
            onClick={() => {
              clickEditButton(comment.commentId);
            }}
            className="rounded-[0.3rem] mt-[2rem] bg-[#696868] relative flex flex-row justify-center items-center self-end w-[6.5rem] h-[2.3rem] box-sizing-border"
          >
            <span className="break-words font-['Pretendard'] font-semibold text-[1rem] mt-[0.1rem] tracking-[0.1rem] text-[#FFFFFF]">
              수정하기
            </span>
          </button>
        </div>
      ) : (
        <>
          <div className=" my-[2rem] ml-[1rem] self-start break-words font-normal text-[1rem] text-[#FFFFFF]">
            {comment.content}
          </div>
          <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[4rem]"></div>
        </>
      )}
    </div>
  );
};
