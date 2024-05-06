import axios from 'axios';

export const uploadImage = async (selectedImage: any, formData: any, setSelectedImage: any, setImageurl: any) => {
  console.log(setSelectedImage);
  if (selectedImage) {
    try {
      formData.append('multipartFile', selectedImage);

      const response = await axios.post('/api/image/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
          authorization:
            'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwidHlwZSI6IlVTRVIiLCJuaWNrbmFtZSI6InN0cmluZyIsImlhdCI6MTcxNTAwNTkzMiwiZXhwIjoxNzE1MDA5NTMyfQ.oiO3ECL5hUSScvjUZ6XwN-o2axUpL1A7tK0bjc2YQ9UQxf6BflLuWh-ARjOuXW7c_bRI3q-J8xu1WnqCoJXAlg',
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
