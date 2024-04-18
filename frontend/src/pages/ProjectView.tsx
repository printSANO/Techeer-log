import Footer from './Footer';
import NavBar from './NavBar';
import GithubIcon from '../shared/assests/Icon-Github.png';
import MediumIcon from '../shared/assests/Icon-Medium.png';
import LinkIcon from '../shared/assests/Icon-Link.png';

function ProjectView() {
  const word = `CONG(콩) : 축하 아카이빙 서비스

CONG은 왜 필요할까?

Unlearn Point 1️⃣ : 좋은 일이라도 나서서 축하해달라고요청하는 것은 왠지 눈치보여 ... 
Unlearn Point 2️⃣ : 축하는 대단한 일이어야만 받을 수 있겠지?

축하의 문제점: 온/오프라인으로 축하받은 내용이 쉽게 휘발된다.
🥲 졸전 포스트잇들이 자꾸 떨어져..간직하고 싶은데 아쉬워요.
🥲 구두로 축하를 받거나, 내가 자리에 없을 때 누가 온지 파악이 힘들어요.
🥲 졸전 포스트잇 집에 들고 갔는데 지금은 어디에 있는지 몰라요.

작은 일이라도 좋은 일이 생겼을 때,내가 먼저 🙌🏻 축하해달라고 하면?
이렇게 받은 축하를 오래 간직할 수 있다면? 📁

'CONG'을 통해 축하받고 싶은 일을 알리고 축하 노트를 받아요!
축하의 순간, 사라지지 않게 콩! `;
  return (
    <div className="bg-[#0F1012] w-[100vw] box-sizing-border">
      <NavBar />
      <div className="w-[1150px] relative ml-auto mr-auto">
        <div className="m-[1rem_0_1.4rem_0] flex flex-col items-centerx break-words font-['Inter'] font-semibold text-[2rem] text-[#FFFFFF]">
          Techeer.log
        </div>
        <div className="m-[0_0_1.3rem_0] inline-block break-words font-['Inter'] font-normal text-[1rem] text-[#C7C7C7]">
          테커 내 모든 프로젝트를 한 번에 살펴볼 수 있는 서비스
        </div>
        <div className="bg-[#FFFFFF] absolute w-[100%] h-[0.1rem]"></div>
        <div className="flex flex-row items-center justify-between w-[100%] mt-[1.5rem] mb-[2rem] box-sizing-border">
          <div className="flex flex-row box-sizing-border items-center ml-[0.4rem]">
            <button className="bg-[url('./shared/assests/Icon-Like.png')] bg-[50%_50%] cursor-pointer bg-contain bg-no-repeat m-[0_0.6rem_0_0] w-[2.5rem] h-[2.5rem]"></button>
            <div className="inline-block break-words font-['Inter'] font-semibold text-[1.1rem] text-[#989898]">
              129
            </div>
          </div>
          <div className="flex flex-row justify-between box-sizing-border mt-[0.5rem]">
            <button className="bg-[url('./shared/assests/Icon-Scrap.png')] bg-[50%_50%] cursor-pointer bg-contain bg-no-repeat m-[0_0_0_0] w-[2.5rem] h-[2.5rem]"></button>
            <button className="bg-[url('./shared/assests/Icon-Share.png')] bg-[50%_50%] cursor-pointer bg-contain bg-no-repeat m-[0_0.6rem_0_0.7rem] w-[2.5rem] h-[2.5rem]"></button>
          </div>
        </div>
        <div className="flex flex-row w-[100%] justify-between box-sizing-border">
          <div className="rounded-[0.9rem] w-[49rem] border border-solid border-[#CCCCCC] h-[100%] relative flex flex-col p-[1.4rem_1.4rem_3rem_1.4rem] box-sizing-border">
            <div className="rounded-[0.6rem] bg-[url('./shared/assests/ThumbNailImg.png')] bg-cover w-[100%] h-[23.2rem]"></div>
            <p className="m-[2rem_1.1rem_0_1.1rem] whitespace-pre-wrap leading-5 self-start break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
              {word}
            </p>
          </div>
          <div className="relative m-[0.2rem_0_0_0] flex flex-col w-[21rem] box-sizing-border">
            <div className="relative m-[0_0_1.5rem_0] flex flex-row items-center w-[100%] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#242424] relative flex flex-col p-[2.3rem_1.5rem_1.3rem_2.3rem] w-[100%] box-sizing-border">
                <div className="m-[0_0_2.1rem_0] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                  프로젝트 정보
                </div>
                <div className="flex flex-row">
                  <div className="flex flex-col justify-between self-start w-[8rem] box-sizing-border">
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                      프로젝트 기간
                    </span>
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                      진행 기수
                    </span>
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                      프로젝트 형태
                    </span>
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                      서비스 상태
                    </span>
                    <div className="m-[0.1rem_0.6rem_0.2rem_0] h-12 inline-block w-[10.9rem] break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                      프로젝트 링크
                    </div>
                  </div>
                  <div className="flex flex-col justify-between self-start w-[17.8rem] box-sizing-border">
                    <span className="break-words font-['Inter'] h-12 font-normal text-[1rem] text-[#FFFFFF]">
                      2023.12 - 2024.02
                    </span>
                    <span className="break-words font-['Inter'] h-12 font-normal text-[1rem] text-[#FFFFFF]">
                      2023 동계 부트캠프
                    </span>
                    <span className="break-words font-['Inter'] h-12 font-normal text-[1rem] text-[#FFFFFF]">웹</span>
                    <span className="break-words font-['Inter'] h-12 font-normal text-[1rem] text-[#FFFFFF]">
                      운영중
                    </span>
                    <div className="flex flex-row w-[3.7rem] box-sizing-border">
                      <img src={GithubIcon} className="mr-[1rem] w-[1.8rem] h-[1.8rem]" />
                      <img src={MediumIcon} className="mr-[1rem] w-[2.1rem] h-[2.1rem]" />
                      <img src={LinkIcon} className="w-[1.6rem] h-[1.6rem] mt-[0.2rem]" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="rounded-[0.9rem] bg-[#242424] mb-[1.5rem] flex flex-col p-[2.3rem_1.3rem_1.3rem_2.3rem] w-[21rem] box-sizing-border">
              <div className="m-[0_0.2rem_0.5rem_0.2rem] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                기술 스택
              </div>
              <span className="w-[8.7rem] m-[1rem_0_1rem_0.2rem] break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                프론트엔드
              </span>
              <div className="rounded-[0.9rem] flex flex-wrap flex-row self-start w-[fit-content] box-sizing-border">
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">React</span>
                </div>
              </div>
              <span className="w-[8.7rem] m-[0.4rem_0_1rem_0.2rem] break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                백엔드
              </span>
              <div className="rounded-[0.9rem] flex flex-wrap flex-row self-start w-[fit-content] box-sizing-border">
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
                </div>
                <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[0.8rem] text-[#CCCCCC]">Spring</span>
                </div>
              </div>
            </div>
            <div className="rounded-[0.9rem] bg-[#242424] relative flex flex-col p-[2.3rem_1.3rem_1.3rem_2.3rem] w-[21rem] box-sizing-border">
              <div className="m-[0_0_2.1rem_0] inline-block self-start break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                프로젝트 팀원
              </div>
              <div className="flex flex-row">
                <div className="flex flex-col justify-between self-start w-[17.9rem] box-sizing-border">
                  <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-16 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                    Team Leader
                  </span>
                  <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-16 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                    Backend
                  </span>
                  <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-16 break-words font-['Inter'] font-semibold text-[1rem] text-[#CCCCCC]">
                    Frontend
                  </span>
                </div>
                <div className="flex flex-col justify-between self-start w-[17.8rem] box-sizing-border">
                  <span className="break-words font-['Inter'] h-16 font-normal text-[1rem] text-[#FFFFFF]">어쩌구</span>
                  <span className="break-words font-['Inter'] h-16 font-normal text-[1rem] text-[#FFFFFF]">
                    어쩌구, 저쩌구, 가나다, 마바사
                  </span>
                  <span className="break-words font-['Inter'] h-16 font-normal text-[1rem] text-[#FFFFFF]">
                    아자차, 타파하, 먕먕먕
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="relative flex flex-col w-[90%] mt-[5rem] mr-auto ml-auto box-sizing-border">
          <div className="rounded-[0.3rem] mb-[4rem] flex flex-col w-[100%] box-sizing-border">
            <div className="m-[0_0_3.3rem_0] inline-block self-start break-words font-['Inter'] font-semibold text-[1.5rem] text-[#FFFFFF]">
              2개의 댓글
            </div>
            <input
              placeholder="댓글을 작성하세요."
              className="placeholder-white bg-transparent w-[100%] border-none m-[0_0_1.5rem_0] inline-block self-start break-words font-['Inter'] font-normal text-[1.3rem] text-[#FFFFFF]"
            ></input>
            <div className="bg-[#989898] w-[100%] h-[0.1rem]"></div>
            <button className="rounded-[0.3rem] mt-[2rem] bg-[#696868] relative flex flex-row justify-center self-end p-[0.8rem_0rem_0.8rem_0] w-[8rem] box-sizing-border">
              <span className="break-words font-['Inter'] font-semibold text-[1.2rem] tracking-[0.1rem] text-[#FFFFFF]">
                댓글 작성
              </span>
            </button>
          </div>
          <div className="w-[100%] mb-[1.5rem]">
            <div className="flex justify-between self-start w-[100%] box-sizing-border mb-[3rem]">
              <div className="flex flex-row">
                <div className="rounded-[16.3rem] bg-[url('./shared/assests/BigProfileImg.png')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_1.3rem_0_0] w-[4.3rem] h-[4.3rem]"></div>
                <div className="m-[0.5rem_0_0.6rem_0] flex flex-col flex-start box-sizing-border">
                  <div className="m-[0_0_0.6rem_0] inline-block break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                    이이름
                  </div>
                  <span className="m-[0_0.7rem_0_0] break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                    2023.10.12
                  </span>
                </div>
              </div>

              <div className="m-[1.7rem_0rem_1.5rem_0] inline-block break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                수정 삭제
              </div>
            </div>
            <span className="self-start break-words font-['Inter'] font-normal text-[1.3rem] text-[#FFFFFF]">
              우왕 저도 참고해서 이번 부트캠프 열심히 해보겠습니다~~
            </span>
          </div>
          <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
          <div className="w-[100%] mr-auto ml-auto mb-[1.5rem]">
            <div className="flex justify-between self-start w-[100%] box-sizing-border mb-[3rem]">
              <div className="flex flex-row">
                <div className="rounded-[16.3rem] bg-[url('./shared/assests/BigProfileImg.png')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_1.3rem_0_0] w-[4.3rem] h-[4.3rem]"></div>
                <div className="m-[0.5rem_0_0.6rem_0] flex flex-col flex-start box-sizing-border">
                  <div className="m-[0_0_0.6rem_0] inline-block break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                    이이름
                  </div>
                  <span className="m-[0_0.7rem_0_0] break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                    2일 전
                  </span>
                </div>
              </div>

              <div className="m-[1.7rem_0rem_1.5rem_0] inline-block break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                수정 삭제
              </div>
            </div>
            <span className="self-start break-words font-['Inter'] font-normal text-[1.3rem] text-[#FFFFFF]">
              우왕 저도 참고해서 이번 부트캠프 열심히 해보겠습니다~~
            </span>
          </div>
          <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default ProjectView;
