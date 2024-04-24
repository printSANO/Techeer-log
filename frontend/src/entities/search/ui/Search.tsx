export function Search() {
  return (
    <div className="rounded-[6.25rem] w-[28.125rem] h-[2.375rem] m-[1.5rem_0_0_0] flex justify-center items-center border border-1 border-solid border-white border-opacity-90 bg-[#111111] bg-opacity-60 backdrop-blur-[24px]">
      <img
        src="./src/shared/assets/image/searchImg/Icon-Search.png"
        className="w-[0.938rem] h-[0.938rem] m-[0_0.625rem_0_0]"
      />
      <input
        type="text"
        name="search"
        placeholder="검색하실 내용을 입력해 주세요."
        className="w-[170px] h-[30px] bg-transparent font-['Pretendard-Light'] text-[14px] text-[#FFFFFF] placeholder-white placeholder-font-['Pretendard-Light'] focus:outline-none bg-transparent"
      />
    </div>
  );
}
