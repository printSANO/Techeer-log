import axiosInstance from '../../../shared/api/axiosInstance.ts';

export const projectSearch = async (keyword: string) => {
  const response = await axiosInstance.get('/api/v1/projects/list', {
    params: {
      pageStart: 0,
      pageSize: 30,
      searchKeyword: keyword,
      searchFieldEnum: 'ALL',
      sortDirection: 'ASC',
    },
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });

  return response.data.data.projectItemResponseList;
};
