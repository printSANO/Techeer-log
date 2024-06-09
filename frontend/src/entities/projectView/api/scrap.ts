import axiosInstance from '../../../shared/api/axiosInstance.ts';

export const postScrap = (projectId: number) => {
  return axiosInstance.post(`/api/v1/scraps/${projectId}`).then((response) => response.data.message);
};

export const deleteScrap = (projectId: number) => {
  return axiosInstance.delete(`/api/v1/scraps/${projectId}`).then((response) => response.data.message);
};
