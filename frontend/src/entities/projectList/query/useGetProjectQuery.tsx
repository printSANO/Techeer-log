import { getProjectList } from '../api/getProjectList.ts';
import { Project } from '../../../shared/types/projectList.ts';
import { useInfiniteQuery } from '@tanstack/react-query';

const SIZE_PER_PAGE = 20; //페이지당 불러올 게시글 개수

export const useGetProjectQuery = () => {
  const projectPerPage = 9; //한 페이지당 불러올 프로젝트 수
  const { data, isFetching, hasNextPage, fetchNextPage, isFetchingNextPage } = useInfiniteQuery<Project[]>({
    queryKey: ['projectList'],
    queryFn: ({ pageParam }) => getProjectList({ pageStart: pageParam, size: SIZE_PER_PAGE }),
    initialPageParam: 0,
    getNextPageParam: (lastPage, allPages) => {
      const nextPage = allPages.length;
      // console.log(allPages, nextPage);
      //data가 0개이거나 projectPerPage 작을 경우 마지막 페이지로 인식한다.
      return lastPage.length < projectPerPage ? undefined : nextPage;
    },
    // staleTime: Infinity, // 데이터가 만료되지 않음

    retry: 0,
    refetchOnReconnect: false,
    refetchOnWindowFocus: false,
  });
  // console.log(data)

  return { data, hasNextPage, isFetching, isFetchingNextPage, fetchNextPage };
};
