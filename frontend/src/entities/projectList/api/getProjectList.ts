import axios from 'axios';
import { accessToken } from '../../../shared/authorization/getToken';
import { Project } from '../../../shared/types/projectList.ts';

export const getProjectList = async ({pageStart, size}:{pageStart:number | unknown, size:number}): Promise<Project[]> => {
  // console.log("pageParam",pageParam)
  const params = {
    pageStart: pageStart,
    pageSize: size,
    searchKeyword: "",
    searchFieldEnum: "TITLE",
    sortDirection: "DESC"
  };

  const response = await axios.get(`/api/v1/projects/list`, {
    params,
    headers: {
      authorization: `Bearer ${accessToken}`,
    }
  });

  console.log(response?.data.data)
  // const pageParam = response.data.data.nextPage

  return response.data.data.projectItemResponseList;
};
