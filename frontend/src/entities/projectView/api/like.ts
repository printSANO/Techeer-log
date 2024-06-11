import axiosInstance from '../../../shared/api/axiosInstance.ts';

export const postLike = (projectId: number) => {
  return axiosInstance.post(`/api/v1/loves/${projectId}`).then((response) => response.data.message);
};

export const deleteLike = (projectId: number) => {
  return axiosInstance.delete(`/api/v1/loves/${projectId}`).then((response) => response.data.message);
};
