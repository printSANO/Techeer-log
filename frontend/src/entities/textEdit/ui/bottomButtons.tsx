/* 하단 취소, 완료버튼 */

export const bottomButtons = () => {
  return (
    <div className="fixed z-10 bottom-0 flex flex-row w-full h-[7%] bg-[#212121] items-center justify-between p-[2rem_2rem]">
      <div className="rounded-[0.3rem] bg-transparent border-solid border-[0.1rem] border-[#333333] flex flex-row justify-center items-center w-[6.7rem] h-[2.7rem] box-sizing-border">
        <span className="break-words font-medium text-[1.2rem] text-white mt-[0.2rem]">취소</span>
      </div>
      <div className="rounded-[0.3rem] bg-[#333333] flex flex-row justify-center items-center w-[6.7rem] h-[2.7rem] box-sizing-border">
        <span className="break-words font-medium text-[1.2rem] leading-[1.2] text-white mt-[0.2rem]">완료</span>
      </div>
    </div>
  );
};
