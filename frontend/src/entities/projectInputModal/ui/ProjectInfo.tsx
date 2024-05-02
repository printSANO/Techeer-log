import calendarImg from '../image/calendar.svg';
import dropdown from '../image/dropdown.svg';
import github from '../../../shared/assets/image/modalImg/github.svg';
import internet from '../../../shared/assets/image/modalImg/Internet.svg';
import blog from '../../../shared/assets/image/modalImg/bloglink.svg';

export const ProjectInfo = ({ setStep }: any) => {
  const nextStep = () => {
    setStep('next');
  };
  const prevStep = () => {
    setStep('prev');
  };
  return (
    <div className="flex flex-col justify-center items-center bg-black bg-opacity-90 w-screen h-screen z-20">
      <div className="flex flex-row justify-center items-center font-['Pretendard'] bg-[#242424] rounded-2xl border-solid border-[#8a8991] border-[0.1rem] h-[42rem] w-[40rem] text-white box-border">
        <div className="flex flex-col gap-[2.5rem] items-center w-full h-full p-[1.8rem_0_1.8rem_0]">
          {/*상단 제목, 스텝퍼*/}
          <div className=" flex flex-row justify-between box-border w-[85%] h-fit">
            <div className="break-words font-['Pretendard'] font-semibold text-[1.3rem] leading-[1.3] text-[#F1EEF9]">
              프로젝트의 기본 정보를 입력해주세요.
            </div>
            <div className="flex flex-row items-center justify-center box-sizing-border">
              <div className="rounded-[0.6rem] bg-[#AEAEC0] w-[1.1rem] h-[1.1rem] flex justify-center items-center">
                <span className="break-words font-['Pretendard'] font-medium text-[0.5rem] leading-[3.25] text-[#FFFFFF]">
                  1
                </span>
              </div>
              <div className="bg-[#AEAEC0] mx-[0.2rem] w-[2rem] h-[0.04rem]"></div>
              <div className="rounded-[0.6rem] bg-[#454545] w-[1.1rem] h-[1.1rem] flex justify-center items-center">
                <span className="break-words font-['Pretendard'] font-medium text-[0.5rem] leading-[3.25] text-[#FFFFFF]">
                  2
                </span>
              </div>
              <div className="bg-[#AEAEC0] mx-[0.2rem] w-[2rem] h-[0.04rem]"></div>
              <div className="rounded-[0.6rem] bg-[#454545] w-[1.1rem] h-[1.1rem] flex justify-center items-center">
                <span className="break-words font-['Pretendard'] font-medium text-[0.5rem] leading-[3.25] text-[#FFFFFF]">
                  3
                </span>
              </div>
            </div>
          </div>
          {/* 하단 입력 정보 전체*/}
          <div className="flex flex-col gap-[1.7rem] w-[85%] h-fit">
            {/* 선택 부분 */}
            <div className="gap-6 flex flex-col w-[100%] box-sizing-border">
              {/* 1열 */}
              <div className="m-[0_0_0.4rem_0] flex flex-row justify-between w-full box-sizing-border">
                {/* 좌측 */}
                <div className="flex flex-col gap-2">
                  <div className="w-[16rem] break-words font-['Pretendard'] font-normal text-[0.9rem] leading-[1.286] text-[#ECEFF5]">
                    프로젝트 시작일
                  </div>
                  <div className="flex flex-row justify-between m-[0_0_0_0] w-[16rem] break-words font-['Pretendard','Roboto_Condensed'] text-[0.8rem] leading-[1.5] text-[#9492A0] border-b-[0.05rem] border-solid">
                    2024. 01. 01
                    <div>
                      <img src={calendarImg} className="inline" />
                    </div>
                  </div>
                </div>
                {/* 우측 */}
                <div className="flex flex-col gap-2">
                  <div className="w-[16rem] break-words font-['Pretendard'] font-normal text-[0.9rem] leading-[1.286] text-[#ECEFF5]">
                    프로젝트 종료일
                  </div>
                  <div className="flex flex-row justify-between m-[0_0_0_0] w-[16rem] break-words font-['Pretendard','Roboto_Condensed'] text-[0.8rem] leading-[1.5] text-[#9492A0] border-b-[0.05rem] border-solid">
                    2024. 03. 01
                    <div>
                      <img src={calendarImg} className="inline" />
                    </div>
                  </div>
                </div>
              </div>
              {/* 2열 */}
              <div className="m-[0_0_0.4rem_0] flex flex-row justify-between w-full box-sizing-border">
                {/* 좌측 */}
                <div className="flex flex-col gap-2">
                  <div className="w-[16rem] break-words font-['Pretendard'] font-normal text-[0.9rem] leading-[1.286] text-[#ECEFF5]">
                    진행기수
                  </div>
                  <div className="flex flex-row justify-between m-[0_0_0_0] w-[16rem] break-words font-['Pretendard','Roboto_Condensed'] text-[0.8rem] leading-[1.5] text-[#9492A0] border-b-[0.05rem] border-solid pb-1 ">
                    부트캠프
                    <div>
                      <img src={dropdown} className="inline" />
                    </div>
                  </div>
                </div>
                {/* 우측 */}
                <div className="flex flex-col gap-2">
                  <div className="w-[16rem] break-words font-['Pretendard'] font-normal text-[0.9rem] leading-[1.286] text-[#242424]">
                    진행기수
                  </div>
                  <div className="flex flex-row justify-between m-[0_0_0_0] w-[16rem] break-words font-['Pretendard','Roboto_Condensed'] text-[0.8rem] leading-[1.5] text-[#9492A0] border-b-[0.05rem] border-solid pb-1 ">
                    2023 동계
                    <div>
                      <img src={dropdown} className="inline" />
                    </div>
                  </div>
                </div>
              </div>
              {/* 3열 */}
              <div className="m-[0_0_0.4rem_0] flex flex-row  justify-between w-full box-sizing-border">
                {/* 좌측 */}
                <div className="flex flex-col gap-2">
                  <div className="w-[16rem] break-words font-['Pretendard'] font-normal text-[0.9rem] leading-[1.286] text-[#ECEFF5]">
                    프로젝트 형태
                  </div>
                  <div className="flex flex-row justify-between m-[0_0_0_0] w-[16rem] break-words font-['Pretendard','Roboto_Condensed'] text-[0.8rem] leading-[1.5] text-[#9492A0] border-b-[0.05rem] border-solid pb-1 ">
                    웹
                    <div>
                      <img src={dropdown} className="inline" />
                    </div>
                  </div>
                </div>
                {/* 우측 */}
                <div className="flex flex-col gap-2">
                  <div className="w-[16rem] break-words font-['Pretendard'] font-normal text-[0.9rem] leading-[1.286] text-[#ECEFF5]">
                    프로젝트 상태
                  </div>
                  <div className="flex flex-row justify-between m-[0_0_0_0] w-[16rem] break-words font-['Pretendard','Roboto_Condensed'] text-[0.8rem] leading-[1.5] text-[#9492A0] border-b-[0.05rem] border-solid pb-1 ">
                    운영중
                    <div>
                      <img src={dropdown} className="inline" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            {/* 프로젝트 링크 */}
            <div className="gap-[0.7rem] flex flex-col w-[100%] box-sizing-border">
              <span className="text-[#ECEFF5] text-[0.9rem] font-normal">프로젝트 링크</span>
              <div className="flex flex-col w-full gap-2">
                <span className="text-[#9492A0] text-[0.9rem] font-normal">Github</span>
                <div className="flex flex-row">
                  <div className="flex justify-center items-center rounded-l-[0.4rem] bg-[#9492A0] w-[5.1rem] h-[2.1rem]">
                    <img src={github} className="w-[1.4rem] h-[1.4rem] rounded-[0.4rem] " />
                  </div>
                  <label className="block w-full">
                    <input
                      type="text"
                      name=""
                      placeholder="Github 링크를 입력하세요"
                      required
                      className="rounded-r-[0.4rem] border-[#9492A0] border-solid border-[0.08rem] w-[100%] -ml-[0.08rem] pl-3 h-[2.1rem] text-[#9492A0] text-[0.8rem] font-['Pretendard'] bg-transparent focus:border-white focus:text-white outline-none"
                    />
                  </label>
                </div>
              </div>
              <div className="flex flex-col w-full gap-2">
                <span className="text-[#9492A0] text-[0.9rem] font-normal">Blog</span>
                <div className="flex flex-row">
                  <div className="flex justify-center items-center rounded-l-[0.4rem] bg-[#9492A0] w-[5.1rem] h-[2.1rem]">
                    <img src={blog} className="w-[1.4rem] h-[1.4rem] rounded-[0.4rem] " />
                  </div>
                  <label className="block w-full">
                    <input
                      type="text"
                      name=""
                      placeholder=""
                      className="rounded-r-[0.4rem] border-[#9492A0] border-solid border-[0.08rem] w-[100%] -ml-[0.08rem] pl-2 h-[2.1rem] text-[#9492A0] text-[0.9rem] bg-transparent focus:border-white focus:text-white outline-none"
                    />
                  </label>
                </div>
              </div>
              <div className="flex flex-col w-full gap-2">
                <span className="text-[#9492A0] text-[0.9rem] font-normal">Website</span>
                <div className="flex flex-row">
                  <div className="flex justify-center items-center rounded-l-[0.4rem] bg-[#9492A0] w-[5.1rem] h-[2.1rem]">
                    <img src={internet} className="w-[1.4rem] h-[1.4rem] rounded-[0.4rem] " />
                  </div>
                  <label className="block w-full">
                    <input
                      type="text"
                      name=""
                      placeholder=""
                      className="rounded-r-[0.4rem] border-[#9492A0] border-solid border-[0.08rem] w-[100%] -ml-[0.08rem] pl-2 h-[2.1rem] text-[#9492A0] text-[0.9rem] bg-transparent focus:border-white focus:text-white outline-none"
                    />
                  </label>
                </div>
              </div>
            </div>
          </div>
          {/* 하단 버튼 */}
          <div className="rounded-[0.3rem] flex flex-row w-[85%] gap-2 justify-end box-sizing-border">
            <div
              onClick={prevStep}
              className="rounded-[0.3rem] bg-[#333333] flex flex-row justify-center items-center w-[4.2rem] h-[2.1rem] box-sizing-border cursor-pointer"
            >
              <span className="break-words font-medium text-[0.9rem] leading-[1.286] text-[#F1EEF9]">취소</span>
            </div>
            <div
              onClick={nextStep}
              className="rounded-[0.3rem] bg-[#8A8991] flex flex-row justify-center items-center w-[4.2rem] h-[2.1rem] box-sizing-border cursor-pointer"
            >
              <span className="break-words font-medium text-[0.9rem] leading-[1.286] text-[#F1EEF9)]">다음</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
