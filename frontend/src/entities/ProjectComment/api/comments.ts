import axios from 'axios';
interface PostComment {
  projectId: number;
  accessToken: string;
  content: string;
}

export const getComments = (projectId: number) => {
  return axios
    .get(`/api/v1/comments/${projectId}`, {
      headers: {
        Authorization:
          'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwidHlwZSI6IlVTRVIiLCJuaWNrbmFtZSI6InN0cmluZyIsImlhdCI6MTcxNDY0NzIzOSwiZXhwIjoxNzE0NjUwODM5fQ.oB6voJXd_l8JVw7YfijLFkibp_JFrbS_HV73Ihfq5kfBb2p2rsAnSBzqbWxj4fiWDsv0Kb-IsFkK1USITzMV5w',
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
          authorization: comment.accessToken,
        },
      },
    )
    .then((response) => response.data.data);
};
