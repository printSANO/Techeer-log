import { useEffect, useRef, useState } from 'react';
import imgfile from '/src/shared/assets/image/markdownImg/Image.svg';
import axios from 'axios';

export const ImageUpload = ({ setImageurl }: any) => {
  const [selectedImage, setSelectedImage] = useState<File | null>(null);
  const fileInputRef = useRef(null);
  const formData = new FormData();

  const handleImageChange = async (e: React.ChangeEvent<HTMLInputElement>) => {
    const { files } = e.target;

    if (files && files.length === 1) {
      setSelectedImage(files[0]);
    }
  };
  const handleImageUpload = async () => {
    if (fileInputRef.current) (fileInputRef.current as HTMLInputElement).click();
  };

  useEffect(() => {
    const uploadImage = async () => {
      if (selectedImage) {
        try {
          formData.append('multipartFile', selectedImage);

          const response = await axios.post('/api/image/upload', formData, {
            headers: {
              'Content-Type': 'multipart/form-data',
              authorization:
                'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MTQ2NTY0OTUsImV4cCI6MTcxNTg2NjQ5NX0.jiNtmKxvv75AMh0IaikVR-6kkJ4UZbrvHEi_oxgphLCv7wUWH75QDN3gi0UwcUYecPhQfH5XbZknXU6aOVdopw',
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

    uploadImage();
  }, [selectedImage]);
  return (
    <>
      <input style={{ display: 'none' }} type="file" accept="image/*" onChange={handleImageChange} ref={fileInputRef} />
      <button
        onClick={handleImageUpload}
        className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none"
      >
        <img src={imgfile} className="flex w-[1.4rem]" />
      </button>
    </>
  );
};
