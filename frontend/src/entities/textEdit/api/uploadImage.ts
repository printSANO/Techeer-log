import axiosInstance from '../../../shared/api/axiosInstance.ts';

export const uploadImage = async (selectedImage: File) => {
  const response = await axiosInstance.post(
    '/api/image/upload',
    { file: selectedImage },
    {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    },
  );

  return response.data.data;
};
