/* 상단 제목, 한 줄 소개 */

export const headerInput = () => {
  return (
    <div className="flex flex-col w-full h-[11.5rem] gap-2 font-['Pretendard'] p-[2.5rem_3.5rem_1rem_3.5rem] box-sizing-border">
      <label className="block w-full">
        <input
          type="text"
          name=""
          placeholder="프로젝트 명을 작성하세요."
          required
          className="w-[100%] h-[4rem] text-[#9492A0] text-[2rem] font-['Pretendard'] font-medium bg-transparent focus:text-white outline-none"
        />
      </label>
      <label className="block w-full">
        <input
          type="text"
          name=""
          placeholder="프로젝트를 한 줄로 소개해보세요."
          required
          className="w-[100%] h-[3rem] text-[#9492A0] text-[1.3rem] font-['Pretendard'] bg-transparent focus:text-white outline-none"
        />
      </label>
    </div>
  );
};
