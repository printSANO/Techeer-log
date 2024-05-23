import axios from 'axios';
import { accessToken } from '../../../shared/authorization/getToken.ts';
interface PostComment {
  projectId?: number;
  commentId?: number;
  content: string;
}

export const getComments = (projectId: number) => {
  return axios
    .get(`/api/v1/comments/${projectId}`, {
      headers: {
        authorization: `Bearer ${accessToken}}`,
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
          authorization: `Bearer ${accessToken}}`,
        },
      },
    )
    .then((response) => response.data.data);
};

export const putComment = (comment: PostComment) => {
  return axios
    .put(
      `/api/v1/comments/${comment.commentId}`,
      { content: comment.content, projectId: comment.projectId },
      {
        headers: {
          authorization: `Bearer ${accessToken}}`,
        },
      },
    )
    .then((response) => response.data.data);
};

export const deleteComment = (commentId: number) => {
  return axios
    .delete(`/api/v1/comments/${commentId}`, {
      headers: {
        authorization: `Bearer ${accessToken}}`,
      },
    })
    .then((response) => response.data.data);
};
