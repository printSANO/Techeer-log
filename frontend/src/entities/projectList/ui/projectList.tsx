import ProjectCard from '../../../shared/ui/ProjectCard.tsx';
import { UseGetProjectQuery } from '../query/useGetProjectQuery.tsx';
// import { Project } from '../../../shared/types/projectList.ts';
import { useInView } from 'react-intersection-observer';
import { useEffect } from 'react';

export const ProjectList = () => {
  const { data, hasNextPage, isFetching, isFetchingNextPage, fetchNextPage } = UseGetProjectQuery()
  const { ref, inView } = useInView();

  useEffect(() => {
    if (inView && hasNextPage) {
      fetchNextPage();
    }
  }, [inView]);

  if (isFetching && !isFetchingNextPage) {
    return (
      <div>
        Loading...
      </div>
    );
  }

  const projects = data?.pages.flat();
  // console.log(projects)

  return (
    <div className="grid grid-rows-3 grid-cols-3 gap-4 m-4">
      {projects && projects.length > 0 ? (
        projects.map((project, index) => (
          <ProjectCard key={index} project={project} />
        ))
      ) : (
        <div>No projects found.</div>
      )}
      {isFetchingNextPage ? (<div>Loading...</div>) : (<div ref={ref} />)}
    </div>
  );
}