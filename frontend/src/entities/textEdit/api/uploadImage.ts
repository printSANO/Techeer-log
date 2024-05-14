import axios from 'axios';

export const uploadImage = async (selectedImage: File, formData: FormData, accessToken: any) => {
  formData.append('multipartFile', selectedImage);

  const response = await axios.post('/api/image/upload', formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
      authorization: accessToken,
    },
  });

  return response.data.data;
};