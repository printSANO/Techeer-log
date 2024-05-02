// 댓글페이지 하단에 삽입
// project API 불러와서 데이터 세팅하는거 구현
import { useQuery } from '@tanstack/react-query';
import { getProject, ProjectView } from '../entities/projectView';
import { ProjectData } from '../shared/types/project.ts';
import { useParams } from 'react-router-dom';

export const ProjectPage = () => {
  const { projectId } = useParams<string>();
  if (!projectId) {
    console.log('Project ID not found');
    return <div>404 not found</div>;
  }
  const { data, isError, error, isLoading } = useQuery<ProjectData>({
    queryKey: ['projectData'],
    queryFn: () => getProject(parseInt(projectId, 10)),
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
