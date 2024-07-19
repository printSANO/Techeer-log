import { useQuery } from '@tanstack/react-query';
import { getComments, ProjectComment } from '../../../entities/projectComments';
import { CommentData } from '../../../shared/types/comments.ts';

export const Comments = ({ projectId }: { projectId: number }) => {
  const { data, isError, error, isLoading } = useQuery<CommentData>({
    queryKey: ['comments'],
    queryFn: () => getComments(projectId),
  });

  if (isLoading) {
    return <div className="w-full h-full bg-transparent">Loading...</div>;
  }

  if (isError) {
    return <div>Error: {error.message}</div>;
  }

  if (data) {
    return (
      <div>
        <ProjectComment
          comments={data ? data.comments : []}
          totalCount={data ? data.totalCount : 0}
          projectId={projectId}
        />
      </div>
    );
  }
};
