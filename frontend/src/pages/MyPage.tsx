import styled from "styled-components";
//import NavBar from "../components/NavBar";
import ProfileImg from "../shared/assests/BigProfileImg.png";
//import line from "../assets/Line2.png";

const Background = styled.div`
  width: 100vw;
  height: 200vh;
  background: #121212;
`;

const MyPageInfo = styled.div`
  width: 768px;
  margin-left: auto;
  margin-right: auto;
`;

const Profile = styled.div`
  display: flex;
  align-items: center;
  margin-top: 8rem;
  justify-content: center;
`;

const ProfileImage = styled.a`
  width: 120px;
  height: 118px;
  border-radius: 120px;
  border: 0px solid #ececec;
`;

const Image = styled.img`
  width: 100%;
  height: 100%;
  border-radius: 120px;
`;

const Words = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-left: 5rem;
`;

const Id = styled.p`
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: #0047ff;
  font-family: PretendSemiBold;
  font-size: 1.8rem;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;
const Name = styled.p`
  display: flex;
  flex-direction: column;
  color: #b3b3b3;
  font-family: PretendSemiBold;
  font-size: 1.125rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
`;

const Email = styled.p`
  display: flex;
  flex-direction: column;
  color: #b3b3b3;
  font-family: PretendRegular;
  font-size: 1.125rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
`;

const Intro = styled.p`
  display: flex;
  flex-direction: column;
  color: #ededed;
  font-family: PretendRegular;
  font-size: 1.25rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
  margin-top: 2.5rem;
`;
/* 
const Line = styled.img`
  width: 100%;
  stroke-width: 1px;
  stroke: #626262;
  height: 1px;
  margin-top: 2rem;
  margin-bottom: 1.5rem;
`; */

const Posts = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: row;
  margin-top: 6rem;
  margin-bottom: 3rem;
`;

const UploadProjectBtn = styled.button`
  display: flex;
  width: 430px;
  height: 29px;
  color: #0047ff;
  text-align: center;
  font-family: PretendRegular;
  font-size: 1.125rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
  margin-top: 3rem;
  margin-bottom: 2rem;
  border: 0;
  background-color: transparent;
`;

const ScrapProjectBtn = styled.button`
  display: flex;
  width: 430px;
  height: 29px;
  color: #cccccc;
  text-align: center;
  font-family: PretendRegular;
  font-size: 1.125rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
  margin-top: 3rem;
  margin-bottom: 2rem;
  border: 0;
  background-color: transparent;
`;
const MyProjectBtn = styled.button`
  display: flex;
  width: 430px;
  height: 29px;
  color: #cccccc;
  text-align: center;
  font-family: PretendRegular;
  font-size: 1.125rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
  margin-top: 3rem;
  margin-bottom: 2rem;
  border: 0;
  background-color: transparent;
`;

function MyPage() {
  return (
    <div className="bg-[#111111] flex flex-col items-center w-[1920px] box-sizing-border">
      <div className="backdrop-blur-[4px] m-[0_0_174px_0] flex flex-row justify-between p-[6px_0_6px_0] w-[1920px] box-sizing-border">
        <span className="m-[0_24px_0_0] w-[1061.7px] break-words font-['Saira_Stencil_One'] font-normal text-[32px] leading-[1.5] text-[#FFFFFF]">
          Techeer.log
        </span>
        <div className="m-[9px_0px_9px_0] flex flex-row justify-between w-[184px] h-[fit-content] box-sizing-border">
          <div className="m-[4px_0_4px_0] flex flex-row justify-between w-[99.6px] h-[fit-content] box-sizing-border">
            <div className="flex flex-row justify-center box-sizing-border">
              <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[14px] leading-[1.571] text-[#FFFFFF]">
                소개
              </span>
            </div>
            <div className="flex flex-row justify-center box-sizing-border">
              <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[14px] leading-[1.571] text-[#FFFFFF]">
                프로젝트
              </span>
            </div>
          </div>
          <div className="rounded-[4px] flex flex-row w-[51.6px] box-sizing-border">
            <div className="rounded-[260px] bg-[url('assets/images/Img24941.jpeg')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_10px_0_0] w-[30px] h-[30px]"></div>
            <img className="rotate-[-60deg] m-[9.1px_0_9.1px_0] w-[11.6px] h-[11.8px]" />
          </div>
        </div>
      </div>
      <div className="rounded-[260px] m-[0_0_178px_25.6px] flex flex-row w-[fit-content] box-sizing-border">
        <div className="rounded-[260px] bg-[url('assets/images/Img24941.jpeg')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_89px_0_0] w-[150px] h-[150px]"></div>
        <div className="m-[0_0_1px_0] flex flex-col box-sizing-border">
          <div className="m-[0_0_1px_0] inline-block self-start break-words font-['Pretendard','Roboto_Condensed'] font-semibold text-[40px] text-[#0047FF]">
            thisisid
          </div>
          <div className="m-[0_0_43px_0] flex flex-row self-start w-[fit-content] box-sizing-border">
            <span className="m-[0_11.8px_0_0] break-words font-['Pretendard','Roboto_Condensed'] font-semibold text-[24px] text-[#B3B3B3]">
              이이름
            </span>
            <span className="m-[0_0px_0_0] break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[24px] text-[#B3B3B3]">
              thistisemail@email.com
            </span>
          </div>
          <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[26px] text-[#EDEDED]">
            한 줄 소개입니다. 한 줄 소개입니다. 한 줄 소개입니다.
          </span>
        </div>
      </div>
      <div className="m-[0_0_24px_30.1px] flex flex-row justify-between w-[1036.1px] box-sizing-border">
        <span className="m-[0_14px_0_0] w-[399px] break-words font-['Pretendard','Roboto_Condensed'] font-medium text-[24px] text-[#0047FF]">
          업로드한 프로젝트
        </span>
        <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[24px] text-[#CCCCCC]">
          스크랩한 프로젝트
        </span>
        <span className="break-words font-['Pretendard','Roboto_Condensed'] font-normal text-[24px] text-[#CCCCCC]">
          참여한 프로젝트
        </span>
      </div>
      <div className="bg-[#444444] relative m-[0_0_1421px_0] w-[1280px] h-[1px]"></div>
      <div className="bg-[url('assets/images/PointBanner.png')] flex flex-row justify-between p-[46px_0_33px_147px] w-[1920px] box-sizing-border">
        <span className="m-[0_33.5px_0_0] w-[684px] break-words font-['Bayon'] font-normal text-[37px] text-[#EFEFEF]">
          Techeer.log
        </span>
        <div className="m-[18px_0_29px_0] flex flex-row justify-center box-sizing-border">
          <span className="break-words font-['Noto_Sans_KR'] font-normal text-[14px] text-[#FFFFFF]">
            © 2024 Techeer.log • All Rights Reserved
          </span>
        </div>
        <div className="m-[11px_0_33px_0] flex flex-row justify-center box-sizing-border">
          <span className="break-words font-['Noto_Sans_KR'] font-normal text-[16px] text-[#FFFFFF]">
            contact: techeer@gmail.com
          </span>
        </div>
      </div>
      <div className="bg-[#0047FF] absolute left-[457px] top-[614px] w-[172px] h-[3px]"></div>
    </div>
  );
}

export default MyPage;
