import axios from 'axios';

export const projectSearch = async (keyword: string, accessToken: any) => {
  const response = await axios.get('/api/v1/projects/list', {
    params: {
      pageStart: 0,
      pageSize: 10,
      keyword,
      searchFieldEnum: 'TITLE',
      sortDirection: 'ASC',
    },
    headers: {
      'Content-Type': 'multipart/form-data',
      authorization: accessToken,
    },
  });

  return response;
};
