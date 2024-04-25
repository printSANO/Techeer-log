import axios, { AxiosResponse } from 'axios';

interface Comment {
  projectId: number;
  accessToken: string;
  content: string;
}

export const getComments = async (projectId: number) => {
  try {
    const response: AxiosResponse = await axios.get(`/api/v1/project/${projectId}/comments`);
    return response.data.data;
  } catch (error) {
    console.log('Error fetching comments:', error);
  }
};

export const PostComment = async (comment: Comment) => {
  try {
    await axios.post(
      `/api/v1/project/${comment.projectId}/comments`,
      { content: comment.content },
      {
        headers: {
          authorization: comment.accessToken,
        },
      },
    );
  } catch (error) {
    console.log('Error posting comment:', error);
  }
};
