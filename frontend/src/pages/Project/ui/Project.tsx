import { useQuery } from '@tanstack/react-query';
import { getProject, ProjectView } from '../../../entities/projectView';
import { ProjectData } from '../../../shared/types/project.ts';

export const Project = ({ projectId }: { projectId: number }) => {
  const { data, isError, error, isLoading } = useQuery<ProjectData>({
    queryKey: ['projectData'],
    queryFn: () => getProject(projectId),
  });

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (isError) {
    return <div>Error: {error.message}</div>;
  }

  if (data) {
    console.log('projectPage', data);
    return (
      <div>
        <ProjectView data={data} />
      </div>
    );
  }
};
