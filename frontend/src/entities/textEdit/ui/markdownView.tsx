import code from '../../../shared/assets/image/markdownImg/code.svg';
import quote from '../../../shared/assets/image/markdownImg/Get Quote.svg';
import imgfile from '../../../shared/assets/image/markdownImg/Image.svg';
import link from '../../../shared/assets/image/markdownImg/Link.svg';
import strikethrough from '../../../shared/assets/image/markdownImg/Strikethrough.svg';
import italic from '../../../shared/assets/image/markdownImg/Italic.svg';

export const markdownView = () => {
  return (
    <div className="flex flex-col w-full">
      {/* 버튼들 */}
      <div className="flex flex-row items-center w-full h-[2.5rem] bg-[#212121] pl-[2.7rem]">
        <button className="w-12 h-fit flex items-center justify-center text-[#ACACAC] cursor-pointer bg-transparent outline-none border-none pt-[0.2rem]">
          <div className="text-[1.125rem] font-bold">H1</div>
        </button>
        <button className="w-12 h-fit flex items-center justify-center text-[#ACACAC] cursor-pointer bg-transparent outline-none border-none pt-[0.2rem]">
          <div className="text-[1.125rem] font-bold">H2</div>
        </button>
        <button className="w-12 h-fit flex items-center justify-center text-[#ACACAC] cursor-pointer bg-transparent outline-none border-none pt-[0.2rem]">
          <div className="text-[1.125rem] font-bold">H3</div>
        </button>
        <button className="w-12 h-fit flex items-center justify-center text-[#ACACAC] cursor-pointer bg-transparent outline-none border-none pt-[0.2rem]">
          <div className="text-[1.125rem] font-bold">H4</div>
        </button>
        <div className="h-[60%] ml-[0.6rem] w-0.5 bg-[#4D4D4D] mx-2"></div>
        <button className="w-12 h-fit flex items-center justify-center text-[#ACACAC] cursor-pointer bg-transparent outline-none border-none pt-[0.2rem]">
          <div className="text-[1.2rem] font-extrabold">B</div>
        </button>
        <button className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none">
          <img src={italic} className="flex w-[1.2rem]" />
        </button>
        <button className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none">
          <img src={strikethrough} className="flex w-[1.2rem]" />
        </button>
        <div className="h-[60%] w-0.5 bg-[#4D4D4D] mx-2"></div>
        <button className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none">
          <img src={quote} className="flex w-[1.4rem]" />
        </button>
        <button className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none">
          <img src={link} className="flex w-[1.3rem]" />
        </button>
        <button className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none">
          <img src={imgfile} className="flex w-[1.4rem]" />
        </button>
        <button className="w-12 h-fit flex items-center justify-center cursor-pointer bg-transparent outline-none border-none">
          <img src={code} className="flex w-[1.3rem]" />
        </button>
      </div>
      {/* 텍스트 상자 */}
      <div className="flex flex-wrap w-auto h-[67vh]">
        {/* 왼쪽 박스 - editor */}
        <div className="flex flex-col w-1/2 border-solid border-r-[0.3rem] border-[#212121] h-full font-['Pretendard'] p-[2.5rem_3.5rem]">
          <textarea
            placeholder="내용을 입력하세요."
            // rows={10}
            // cols={100}
            className="bg-transparent inline-flex text-[1.2rem] outline-none cursor-text border-none text-gray-400 focus:text-white px-1 h-full w-full resize-none leading-6 overflow-y-auto"
          />
        </div>
        {/* 오른쪽 박스 - preview */}
        <div className="flex flex-col w-1/2 h-full font-['Pretendard'] p-[3.8rem_3.5rem]"></div>
      </div>
    </div>
  );
};
