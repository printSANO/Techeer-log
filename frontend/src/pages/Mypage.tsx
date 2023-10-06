import styled from "styled-components";
import NavBar from "../components/NavBar";
import ProfileImg from "../assets/BigProfileImage.png";
import line from "../assets/Line2.png";

const Background = styled.div`
  width: 100vw;
  height: 100vh;
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
  margin-top: 7.625rem;
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
`;

const Name = styled.p`
  display: flex;
  width: 132px;
  height: 58px;
  flex-direction: column;
  justify-content: center;
  color: #ececec;
  text-align: center;
  font-family: Inter;
  font-size: 28px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;

const Intro = styled.p`
  display: flex;
  width: 194px;
  height: 33px;
  flex-direction: column;
  color: #ececec;
  font-family: Inter;
  font-size: 18px;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
  margin-left: 23px;
`;

const Line = styled.img`
  width: 797.006px;
  stroke-width: 1px;
  stroke: #626262;
  height: 1px;
  margin-top: 2rem;
  margin-bottom: 1.5rem;
`;

function MyPage() {
  return (
    <Background>
      <NavBar />
      <MyPageInfo>
        <Profile>
          <ProfileImage>
            <Image src={ProfileImg} />
          </ProfileImage>
          <Words>
            <Name>김이름</Name>
            <Intro>안녕하세요.</Intro>
          </Words>
        </Profile>
        <Line src={line} />
      </MyPageInfo>
    </Background>
  );
}

export default MyPage;
