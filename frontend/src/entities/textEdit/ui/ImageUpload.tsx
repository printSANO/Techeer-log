import { useRef } from 'react';
import imgfile from '/src/shared/assets/image/markdownImg/Image.svg';
import * as textEdit from '../index';
import { useAuthStore } from '../../../shared/store/authStore';
import { useMutation } from 'react-query';

export const ImageUpload = ({ setImageurl }: any) => {
  //const [selectedImage, setSelectedImage] = useState<File | null>(null);
  const fileInputRef = useRef(null);
  const { accessToken } = useAuthStore();
  const formData = new FormData();

  const handleImageChange = async (e: React.ChangeEvent<HTMLInputElement>) => {
    const { files } = e.target;

    if (files && files.length === 1) {
      uploadImageMutation.mutate(files[0]);
    }
  };
  const handleImageUpload = async () => {
    if (fileInputRef.current) (fileInputRef.current as HTMLInputElement).click();
  };

  const uploadImageMutation = useMutation(
    (selectedImage: File) => textEdit.uploadImage(selectedImage, formData, accessToken),
    {
      onSuccess: (response) => {
        setImageurl(`![](${response})`);
      },
      onError: (error) => {
        console.error(error);
        alert('더 작은 용량의 이미지를 업로드해주세요!');
      },
    },
  );
  /* useEffect(() => {
    textEdit.uploadImage(selectedImage, formData, setSelectedImage, setImageurl, accessToken);
  }, [selectedImage]); */
  return (
    <>
      {!uploadImageMutation.isLoading && (
        <>
          <input
            style={{ display: 'none' }}
            type="file"
            accept="image/*"
            onChange={handleImageChange}
            ref={fileInputRef}
          />
          <button
            onClick={handleImageUpload}
            className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none"
          >
            <img src={imgfile} className="flex w-[1.4rem]" />
          </button>
        </>
      )}
    </>
  );
};
