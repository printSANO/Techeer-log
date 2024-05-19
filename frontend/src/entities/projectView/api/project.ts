import axios from 'axios';
import { accessToken } from '../../../shared/authorization/getToken.ts';

export const getProject = (projectId: number) => {
  return axios.get(`/api/v1/projects/${projectId}`, {
    headers: {
      authorization: `Bearer ${accessToken}}`,
    },
  }).then((response) => response.data.data);
};

//response.data.data, response.data.projectMemberResponseList, response.data.frameworkResponseList
//수정, 삭제도 넣을거
