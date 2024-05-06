import { useEffect, useRef, useState } from 'react';
import imgfile from '/src/shared/assets/image/markdownImg/Image.svg';
import * as textEdit from '../index';

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
    textEdit.uploadImage(selectedImage, formData, setSelectedImage, setImageurl);
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
