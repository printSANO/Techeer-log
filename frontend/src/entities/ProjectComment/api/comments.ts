import axios from 'axios';
interface PostComment {
  projectId: number;
  accessToken: string;
  content: string;
}

export const getComments = (projectId: number) => {
  return axios.get(`/api/v1/project/${projectId}/comments`).then((response) => response.data);
};

export const postComment = (comment: PostComment) => {
  return axios
    .post(
      `/api/v1/project/${comment.projectId}/comments`,
      { content: comment.content },
      {
        headers: {
          authorization: comment.accessToken,
        },
      },
    )
    .then((response) => response.data.data);
};
