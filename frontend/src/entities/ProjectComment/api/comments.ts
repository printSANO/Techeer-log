import axiosInstance from '../../../shared/api/axiosInstance.ts';
interface PostComment {
  projectId?: number;
  commentId?: number;
  content: string;
}

export const getComments = (projectId: number) => {
  return axiosInstance.get(`/api/v1/comments/${projectId}`, {}).then((response) => response.data.data);
};

export const postComment = (comment: PostComment) => {
  return axiosInstance
    .post(`/api/v1/comments`, { content: comment.content, projectId: comment.projectId })
    .then((response) => response.data.data);
};

export const putComment = (comment: PostComment) => {
  return axiosInstance
    .put(`/api/v1/comments/${comment.commentId}`, { content: comment.content, projectId: comment.projectId })
    .then((response) => response.data.data);
};

export const deleteComment = (commentId: number) => {
  return axiosInstance.delete(`/api/v1/comments/${commentId}`).then((response) => response.data.data);
};
