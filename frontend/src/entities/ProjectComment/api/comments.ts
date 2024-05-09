import axios from 'axios';
interface PostComment {
  projectId?: number;
  commentId?: number;
  content: string;
}

const token = localStorage.getItem('user');

export const getComments = (projectId: number) => {
  return axios
    .get(`/api/v1/comments/${projectId}`, {
      headers: {
        Authorization: `Bearer ${token}}`,
      },
    })
    .then((response) => response.data.data);
};

export const postComment = (comment: PostComment) => {
  return axios
    .post(
      `/api/v1/comments`,
      { content: comment.content, projectId: comment.projectId },
      {
        headers: {
          Authorization: `Bearer ${token}}`,
        },
      },
    )
    .then((response) => response.data.data);
};

export const putComment = (comment: PostComment) => {
  return axios
    .put(
      `/api/v1/comments/${comment.commentId}`,
      { content: comment.content },
      {
        headers: {
          authorization: `Bearer ${token}}`,
        },
      },
    )
    .then((response) => response.data.data);
};

export const deleteComment = (commentId: number) => {
  return axios
    .put(`/api/v1/comments/${commentId}`, {
      headers: {
        authorization: `Bearer ${token}}`,
      },
    })
    .then((response) => response.data.data);
};
