import axios from 'axios';
import { accessToken } from '../../../shared/authorization/getToken.ts';

export const postScrap = (projectId: number) => {
  return axios
    .post(
      `/api/v1/scraps/${projectId}`,
      {},
      {
        headers: {
          authorization: `Bearer ${accessToken}}`,
        },
      },
    )
    .then((response) => response.data.message);
};

export const deleteScrap = (projectId: number) => {
  return axios
    .delete(`/api/v1/scraps/${projectId}`, {
      headers: {
        authorization: `Bearer ${accessToken}`,
      },
    })
    .then((response) => response.data.message);
};
