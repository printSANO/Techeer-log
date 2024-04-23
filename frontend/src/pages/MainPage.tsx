import NavBar from '../shared/ui/NavBar.tsx';
// import { DropDown } from '../entities/filter/index';
import { EmblaCarousel } from '../entities/carousel/index';
import { EmblaOptionsType } from 'embla-carousel';

export default function MainPage() {
  const OPTIONS: EmblaOptionsType = { loop: true };
  const SLIDE_COUNT = 5;
  const SLIDES = Array.from(Array(SLIDE_COUNT).keys());

  return (
    <div className="bg-[#111111] flex flex-col items-center w-screen justify-center items-center">
      <NavBar />
      {/* 메인페이지-소개 */}
      <div className="w-[100vw] h-[41.6vw] bg-cover bg-[url('shared/assests/Background-Main.png')] flex justify-center items-center">
        <div className="w-[100vw] h-[100vw] flex flex-col justify-center items-center font-['Pretendard-Regular'] font-normal text-[#FFFFFF]">
          <span className="font-['Pretendard-Black'] text-[6.25rem] m-[0_0_1.5rem_0]">Techeer</span>
          <span className="font-['Pretendard-Thin'] text-[1.875rem]">
            테커에서 진행하는 <a className="font-['Pretendard-Medium']">다양한 프로젝트를 한눈에</a>
          </span>
          <div className="rounded-[6.25rem] w-[28.125rem] h-[2.375rem] m-[1.5rem_0_0_0] flex justify-center items-center border border-1 border-solid border-white border-opacity-90 bg-[#111111] bg-opacity-60 backdrop-blur-[24px]">
            <img src="./src/shared/assests/Icon-Search.png" className="w-[0.938rem] h-[0.938rem] m-[0_0.625rem_0_0]" />
            <input
              type="text"
              name="search"
              placeholder="검색하실 내용을 입력해 주세요."
              className="w-[170px] h-[30px] bg-transparent font-['Pretendard-Light'] text-[14px] text-[#FFFFFF] placeholder-white placeholder-font-['Pretendard-Light'] focus:outline-none bg-transparent"
            />
          </div>
        </div>
      </div>
      {/* 메인페이지-프로젝트 */}
      <div className="w-[75rem] mt-[6.063rem] flex flex-col justify-center items-center">
        {/* 우수선정작 */}
        <div className="flex flex-col justify-center items-center mb-12">
          <img src="./src/shared/assests/Icon-Point.png" className="w-[1.875rem] h-[0.75rem] mb-[1rem]" />
          <span className="font-['Pretendard-Thin'] text-[1.875rem] text-white">
            2023 동계 부트캠프 <a className="font-['Pretendard-Bold']">우수 선정작</a>
          </span>
        </div>
        {/* Carousel */}
        {/* 캐러셀 참고 : https://codesandbox.io/p/sandbox/embla-carousel-loop-react-yvfd5v?file=%2Fsrc%2Fjs%2Findex.tsx */}
        <EmblaCarousel slides={SLIDES} options={OPTIONS} />
        {/* 캐러셀 대신 임시 */}
        <div className="grid grid-cols-3 gap-4 m-4 mb-24">
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
        </div>
        {/* 테커 모든 프로젝트 */}
        <div className="flex flex-col justify-center items-center mb-12">
          <img src="./src/shared/assests/Icon-Point.png" className="w-[1.875rem] h-[0.75rem] mb-[1rem]" />
          <span className="font-['Pretendard-Thin'] text-[1.875rem] text-white">
            테커 모든 <a className="font-['Pretendard-Bold']">프로젝트</a>
          </span>
        </div>
        {/* Filter */}
        {/*<DropDown />*/}
        {/* Filtered Projects */}
        <div className="grid grid-rows-3 grid-cols-3 gap-4 m-4">
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.3rem] border-solid border border-[#444444] flex flex-col p-[0_0_1rem_0] box-sizing-border w-[100%]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] bg-cover rounded-[0.3rem] m-[0_0_1.3rem_0] w-[99.9%] h-[15rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Pre-S'] font-semibold text-[1.3rem] bg-[#FFFFFF] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Pre-R'] font-normal text-[0.9rem] text-[#CCCCCC]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.3rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.3rem] bg-[#333333] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">React</span>
              </div>
              <div className="rounded-[0.3rem] bg-[#333333] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Pre-R'] font-semibold text-[0.8rem] text-[#FFFFFF]">Spring</span>
              </div>
            </div>
            <div className="m-[0_1rem_0_1rem] flex flex-row justify-between w-[21rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0]break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Pre-R'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
