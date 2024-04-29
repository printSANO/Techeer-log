//usestate같은거는 pages에서 씀
import { useQuery } from '@tanstack/react-query';
import { getComments, ProjectComment } from '../entities/ProjectComment';
import { CommentData } from '../shared/types/comments.ts';

//projectId는 useRef로 url에서 받아올거임
// interface Comment {
//   projectId: number;
//   accessToken: string; zustand 전역상태관리로 스토리지 저장값 받아올거임
//   content: string;
// }
export const CommentsPage = (projectId: number) => {
  const { data, isError, error, isLoading } = useQuery<CommentData>({
    queryKey: ['todos'],
    queryFn: () => getComments(projectId),
  });

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (isError) {
    return <div>Error: {error.message}</div>;
  }

  console.log(data);

  if (data) {
    return (
      <div>
        <ProjectComment comments={data.comments} totalCount={data.totalCount} />
      </div>
    );
  }
};
