import axios from 'axios';
import { accessToken } from '../../../shared/authorization/getToken.ts';

export const postLike = (projectId: number) => {
  return axios
    .post(
      `/api/v1/loves/${projectId}`,
      {},
      {
        headers: {
          authorization: `Bearer ${accessToken}}`,
        },
      },
    )
    .then((response) => response.data.message);
};

export const deleteLike = (projectId: number) => {
  return axios
    .delete(`/api/v1/loves/${projectId}`, {
      headers: {
        authorization: `Bearer ${accessToken}`,
      },
    })
    .then((response) => response.data.message);
};
