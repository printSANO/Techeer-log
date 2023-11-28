import styled from "styled-components";
import { useState, useRef, useEffect } from "react";
import axios from "axios";
import { accessTokenState } from "../states/Atom";
import { useRecoilValue } from "recoil";

const Background = styled.div`
  width: 99.1vw;
  height: 100vh;
  background: #121212;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Prewatch = styled.h3`
  font-size: 1.3125rem;
  color: #ececec;
  line-height: 1.5;
  margin-bottom: 1rem;
`;

const UploadBox = styled.div`
  width: 100%;
  height: 250px;
  position: relative;
  background: #252525;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`;

const UploadButton = styled.button`
  margin-top: 1rem;
  padding: 0.25rem 2rem;
  background: #1e1e1e;
  border-radius: 4px;
  box-shadow: rgba(0, 0, 0, 0.024) 0px 0px 4px;
  font-size: 1rem;
  line-height: 1.5;
  color: #63e6be;
  outline: none;
  border: none;
  cursor: pointer;
  font-weight: bold;
`;

const Image = styled.img`
  height: 100%;
  width: 100%;
  display: block;
  object-fit: cover;
`;

function WritingPage() {
  const [selectedImage, setSelectedImage] = useState<File | null>(null);
  const fileInputRef = useRef(null);
  const accesstoken = useRecoilValue(accessTokenState);
  const [imageUrl, setImageUrl] = useState("");

  const formData = new FormData();
  const handleImageChange = async (e: React.ChangeEvent<HTMLInputElement>) => {
    const { files } = e.target;

    if (files && files.length === 1) {
      setSelectedImage(files[0]);
    }
  };
  const handleImageUpload = async () => {
    if (fileInputRef.current)
      (fileInputRef.current as HTMLInputElement).click();
  };
  useEffect(() => {
    const uploadImage = async () => {
      if (selectedImage) {
        try {
          formData.append("multipartFile", selectedImage);

          const response = await axios.post("api/image/upload", formData, {
            headers: {
              "Content-Type": "multipart/form-data",
              authorization: accesstoken,
            },
          });

          setImageUrl(response.data.data);
          setSelectedImage(null);
        } catch (error) {
          console.log(error);
        }
      }
    };

    uploadImage();
  }, [selectedImage]);
  return (
    <Background>
      <section style={{ width: "360px" }}>
        <Prewatch>썸네일 업로드</Prewatch>
        {imageUrl ? (
          <UploadBox>
            <Image src={imageUrl} />
          </UploadBox>
        ) : (
          <UploadBox>
            <svg width="107" height="85" fill="none" viewBox="0 0 107 85">
              <path
                fill="#868E96"
                d="M105.155 0H1.845A1.844 1.844 0 0 0 0 1.845v81.172c0 1.02.826 1.845 1.845 1.845h103.31A1.844 1.844 0 0 0 107 83.017V1.845C107 .825 106.174 0 105.155 0zm-1.845 81.172H3.69V3.69h99.62v77.482z"
              ></path>
              <path
                fill="#868E96"
                d="M29.517 40.84c5.666 0 10.274-4.608 10.274-10.271 0-5.668-4.608-10.276-10.274-10.276-5.665 0-10.274 4.608-10.274 10.274 0 5.665 4.609 10.274 10.274 10.274zm0-16.857a6.593 6.593 0 0 1 6.584 6.584 6.593 6.593 0 0 1-6.584 6.584 6.591 6.591 0 0 1-6.584-6.582c0-3.629 2.954-6.586 6.584-6.586zM12.914 73.793a1.84 1.84 0 0 0 1.217-.46l30.095-26.495 19.005 19.004a1.843 1.843 0 0 0 2.609 0 1.843 1.843 0 0 0 0-2.609l-8.868-8.868 16.937-18.548 20.775 19.044a1.846 1.846 0 0 0 2.492-2.72L75.038 31.846a1.902 1.902 0 0 0-1.328-.483c-.489.022-.95.238-1.28.6L54.36 51.752l-8.75-8.75a1.847 1.847 0 0 0-2.523-.081l-31.394 27.64a1.845 1.845 0 0 0 1.22 3.231z"
              ></path>
            </svg>
            <input
              style={{ display: "none" }}
              type="file"
              accept="image/*"
              onChange={handleImageChange}
              ref={fileInputRef}
            />
            <UploadButton onClick={handleImageUpload}>
              썸네일 업로드
            </UploadButton>
          </UploadBox>
        )}
      </section>
    </Background>
  );
}

export default WritingPage;
