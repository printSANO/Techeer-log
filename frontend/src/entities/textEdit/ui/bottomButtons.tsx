/* eslint-disable react-hooks/rules-of-hooks */
/* 하단 취소, 완료버튼 */

import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import useStore from '../../../shared/store/store';

export const bottomButtons = () => {
  const navigate = useNavigate();
  const nowProject = useStore((state:any) => state.nowProject);
  const handleGoBack = () => {
    navigate(-1); // 뒤로가기
  };
  const handleSubmit = async (): Promise<void> => {
    try {
      const response = await axios.post(
        '/api/v1/projects',
        {
          title: nowProject.title,
          content: nowProject.content,
          mainImageUrl: nowProject.mainImageUrl,
        },
        {
          headers: {
            authorization: "",
          },
        },
      );
      console.log(response.data);
      navigate('/');
    } catch (error) {
      alert('제목, 내용을 입력해주세요!');
    }
  };
  const onSubmit = async () => {
    try {
      await handleSubmit();
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div className="fixed bottom-0 flex flex-row w-full h-[7%] bg-[#212121] items-center justify-between p-[2rem_2rem]">
      <div
        onClick={handleGoBack}
        className="rounded-[0.3rem] bg-transparent border-solid border-[0.1rem] border-[#333333] flex flex-row justify-center items-center w-[6.7rem] h-[2.7rem] box-sizing-border cursor-pointer"
      >
        <span className="break-words font-medium text-[1.2rem] text-white mt-[0.2rem]">취소</span>
      </div>
      <div
        onClick={onSubmit}
        className="rounded-[0.3rem] bg-[#333333] flex flex-row justify-center items-center w-[6.7rem] h-[2.7rem] box-sizing-border cursor-pointer"
      >
        <span className="break-words font-medium text-[1.2rem] leading-[1.2] text-white mt-[0.2rem]">완료</span>
      </div>
    </div>
  );
};
