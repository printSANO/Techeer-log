import axios from 'axios';

export const uploadImage = async (selectedImage: File, accessToken: any) => {
  const response = await axios.post(
    '/api/image/upload',
    { file: selectedImage },
    {
      headers: {
        'Content-Type': 'multipart/form-data',
        authorization: accessToken,
      },
    },
  );

  return response.data.data;
};
