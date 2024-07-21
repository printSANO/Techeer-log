import { Comment } from '../../../shared/types/comments.ts';
import { postComment } from '../api/comments.ts';
import { useState } from 'react';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import { SingleComment } from './SingleComment.tsx';

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
  const [input, setInput] = useState('');

  const submitComment = (input: string) => {
    if (projectId) {
      const comment: PostComment = { projectId: projectId, content: input };
      postMutation.mutate(comment);
      setInput('');
    }
  };

  const postMutation = useMutation({
    mutationFn: (comment: PostComment) => postComment(comment),
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
        <div className="flex flex-col">
          {/*댓글 목록*/}
          {comments &&
            comments.map((comment: Comment, index) => (
              <SingleComment key={index} projectId={projectId} comment={comment} />
            ))}
        </div>
      </div>
    </div>
  );
};
