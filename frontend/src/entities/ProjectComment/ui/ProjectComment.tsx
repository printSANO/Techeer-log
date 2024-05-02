//comments 배열을 props로 받아서 map으로 뿌려줄거임 comments배열 저장해서 전달하는건 pages에서 함
//input값을 어떻게 상위 페이지에 전달하냐는 건데.... usestate()의 setter말고 그냥 데이터만 보내주면 될것같음 -> props?

//댓글작성 버튼 클릭 메서드 feature에서 가져옴
import { Comment } from '../../../shared/types/comments.ts';
import { postComment } from '../api/comments.ts';
import { useState } from 'react';
import { useMutation, useQueryClient } from '@tanstack/react-query';

interface ProjectCommentProps {
  comments: Comment[];
  totalCount: number;
  projectId: number;
}

export const ProjectComment = (data: ProjectCommentProps) => {
  const currentUser = 'string'; //유저정보 조회 API로 받아옴
  const [input, setInput] = useState('');
  const queryClient = useQueryClient();
  const { comments, totalCount, projectId } = data;
  console.log('??', comments[0]);

  // 나중에 feature에 쓸거임
  // accessToken storage에서 가져옴
  // import useStore from './useStore'
  // import { useTokenStore } from './stores/useTokenStore'
  //
  // const token = useStore(useTokenStore, (state) => state.bears)

  interface PostComment {
    projectId: number;
    accessToken: string;
    content: string;
  }

  // comment는 클라이언트 -> 서버 보내는 데이터
  // comments는 get요청으로 받아온 댓글 데이터
  //토큰은 나중에 api에서 storage값 가져올거임
  const token =
    'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwidHlwZSI6IlVTRVIiLCJuaWNrbmFtZSI6InN0cmluZyIsImlhdCI6MTcxNDY1NDU3NSwiZXhwIjoxNzE0NjU4MTc1fQ.eW7OL-3dDimyuMqe0WoObUtkeJiZYoUpGCa2_lsSfs-Ye3fCaJeBf4f8qfPIDooGdOxAOtasLNX78DxQnAjveQ';
  const submitCommentData = (input: string) => {
    if (projectId && token) {
      const comment: PostComment = { projectId: projectId, accessToken: token, content: input };
      mutation.mutate(comment);
      setInput('');
    }
    //mutation
    console.log('댓글 내용:', input);
  };

  const mutation = useMutation({
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
            onClick={() => submitCommentData(input)}
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
                    <div className="m-[1.7rem_0rem_1.5rem_0] inline-block break-words font-normal text-[0.8rem] text-[#CCCCCC]">
                      수정 삭제
                    </div>
                  ) : (
                    <div></div>
                  )}
                </div>
                <div className=" my-[2rem] ml-[1rem] self-start break-words font-normal text-[1rem] text-[#FFFFFF]">
                  {comment.content}
                </div>
                <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};
