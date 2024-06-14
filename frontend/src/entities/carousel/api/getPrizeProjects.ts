import axiosInstance from '../../../shared/api/axiosInstance.ts';
import { useQuery } from '@tanstack/react-query';
import { prizeDate } from '../../../shared/types/prizeDate.ts';
export const getPrizeProjects = async (data: prizeDate) => {
  const response = await axiosInstance.get('/api/v1/projects/prize', { params: data });
  return response.data.data.projectItemResponseList;
};

export const usePrizeProjects = (data: prizeDate) => {
  return useQuery({
    queryKey: ['prizeProjects'],
    queryFn: () => getPrizeProjects(data),
    refetchOnMount: false,
    refetchOnReconnect: false,
    refetchOnWindowFocus: false,
  });
};
