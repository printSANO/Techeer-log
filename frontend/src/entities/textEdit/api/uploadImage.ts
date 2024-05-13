import axios from 'axios';

export const uploadImage = async (
  selectedImage: any,
  formData: any,
  setSelectedImage: any,
  setImageurl: any,
  accessToken: any,
) => {
  if (selectedImage) {
    try {
      formData.append('multipartFile', selectedImage);

      const response = await axios.post('/api/image/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
          authorization: accessToken,
        },
      });

      setSelectedImage(null);
      setImageurl(`![](${response.data.data})`);
    } catch (error) {
      console.log(error);
      alert('더 작은 용량의 이미지를 업로드해주세요!');
    }
  }
};
