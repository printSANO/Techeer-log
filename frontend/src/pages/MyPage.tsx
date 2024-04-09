//import NavBar from "../components/NavBar";

function MyPage() {
  return (
    <div className="bg-[#111111] flex flex-col items-center w-[100vw] box-sizing-border">
      <div className="backdrop-blur-[0.3rem] m-[0_0_10.9rem_0] flex flex-row justify-between p-[0.4rem_0_0.4rem_0] w-[120rem] box-sizing-border"></div>
      <div className="w-[1200px] ml-auto mr-auto">
        <div className="rounded-[16.3rem] m-[0_0_11.1rem_0] flex flex-row w-[100%] box-sizing-border justify-center">
          <div className="rounded-[16.3rem] bg-[url('shared/assests/BigProfileImg.png')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_5.6rem_0_0] w-[9.4rem] h-[9.4rem]"></div>
          <div className="m-[0_0_0.1rem_0] flex flex-col box-sizing-border">
            <div className="m-[0_0_0.1rem_0] inline-block self-start break-words font-['Pretendard','Roboto_Condensed'] font-semibold text-[2.5rem] text-[#0047FF]">
              thisisid
            </div>
            <div className="m-[0_0_2.7rem_0] flex flex-row self-start w-[fit-content] box-sizing-border">
              <span className="m-[0_0.7rem_0_0] break-words font-['Pretendard','Roboto_Condensed'] font-semibold text-[1.5rem] text-[#B3B3B3]">
                이이름
              </span>
              <span className="m-[0_0rem_0_0] break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[1.5rem] text-[#B3B3B3]">
                thistisemail@email.com
              </span>
            </div>
            <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[1.6rem] text-[#EDEDED]">
              한 줄 소개입니다. 한 줄 소개입니다. 한 줄 소개입니다.
            </span>
          </div>
        </div>
        <div className="m-[0_0_1.5rem_0] flex flex-row justify-between w-[100%] box-sizing-border">
          <span className="break-words font-['Pretendard','Roboto_Condensed'] font-medium text-[1.5rem] ml-28 text-[#0047FF]">
            업로드한 프로젝트
            <div className="bg-[#0047FF] absolute w-[10.8rem] h-[0.2rem] mt-[1.5rem]"></div>
          </span>
          <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[1.5rem] text-[#CCCCCC]">
            스크랩한 프로젝트
          </span>
          <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[1.5rem] mr-28 text-[#CCCCCC]">
            참여한 프로젝트
          </span>
        </div>
        <div className="bg-[#444444] relative m-[0_0_6.8rem_0] w-[100%] h-[0.1rem]"></div>
        <div className="grid grid-rows-3 grid-cols-3 gap-12 m-12">
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
          <div className="rounded-[0.9rem] border-solid border border-blue-200 flex flex-col p-[0_0_1rem_0] box-sizing-border w-[21.2rem]">
            <div className="bg-[url('shared/assests/ThumbNailImg.png')] rounded-[0.5rem] m-[0_0_1.3rem_0] w-[21rem] h-[12rem]"></div>
            <div className="m-[0_1rem_0.4rem_1rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] bg-[linear-gradient(92.12deg,#89F7FE_0%,#66A6FF_99.3%)] text-[transparent] bg-clip-text">
              어쩌구저쩌구
            </div>
            <div className="m-[0_1rem_0.7rem_1rem] inline-block self-start break-words font-['Inter'] font-normal text-[0.9rem] text-[#FFFFFF]">
              어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
            </div>
            <div className="rounded-[0.9rem] m-[0_1rem_2.2rem_1rem] flex flex-row self-start w-[fit-content] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.3rem_0_0] flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.6rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
              </div>
              <div className="rounded-[0.9rem] bg-[#464646] relative flex flex-row justify-center p-[0.3rem_0.7rem_0.2rem_0.7rem] box-sizing-border">
                <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
              </div>
            </div>
            <div className="m-[0_0.9rem_0_0.9rem] flex flex-row justify-between w-[19.3rem] box-sizing-border">
              <p className="m-[0_0.5rem_0_0] w-[16.6rem] break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">
                <span className="container-17-sub-10"></span>
                <span>• 서비스 운영중</span>
              </p>
              <span className="break-words font-['Inter'] font-normal text-[0.8rem] text-[#B0B0B0]">♥︎ 129</span>
            </div>
          </div>
        </div>
      </div>

      <div className="bg-[url('assets/images/PointBanner.png')] flex flex-row justify-between p-[2.9rem_0_2.1rem_9.2rem] w-[120rem] box-sizing-border"></div>
    </div>
  );
}

export default MyPage;
