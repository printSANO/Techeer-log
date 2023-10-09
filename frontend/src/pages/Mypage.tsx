import styled from "styled-components";
import NavBar from "../components/NavBar";
import ProfileImg from "../assets/BigProfileImage.png";
import line from "../assets/Line2.png";
import nopost from "../assets/NoPost.png";

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
  margin-top: 4.5rem;
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
  margin-left: 1rem;
`;

const Name = styled.a`
  display: flex;
  width: 72px;
  height: 45px;
  flex-direction: column;
  justify-content: center;
  color: #ececec;
  text-align: center;
  font-family: Inter;
  font-size: 1.5rem;
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
  font-size: 1.125rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
`;

const Line = styled.img`
  width: 100%;
  stroke-width: 1px;
  stroke: #626262;
  height: 1px;
  margin-top: 2rem;
  margin-bottom: 1.5rem;
`;

const Selector = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  margin-top: 4.5rem;
  margin-bottom: 4.5rem;
`;

const Writing = styled.li`
  display: flex;
  width: 8rem;
  height: 74px;
  flex-direction: column;
  justify-content: center;
  color: #63e6be;
  text-align: center;
  font-family: Inter;
  font-size: 1.325rem;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  position: relative;
`;

const Search = styled.div`
  display: flex;
  justify-content: flex-end;
`;

const Section = styled.section`
  padding-left: 0.625rem;
  padding-right: 0.625rem;
  height: 2.25rem;
  width: 205px;
  border: 1px solid #ececec;
  display: flex;
  align-items: center;
  cursor: text;
  margin-bottom: 2rem;
`;

const Input = styled.input`
  display: flex;
  height: 1rem;
  flex-direction: column;
  justify-content: center;
  color: #ececec;
  font-family: Inter;
  font-size: 0.875rem;
  font-style: normal;
  font-weight: 300;
  line-height: normal;
  border: none;
  outline: 0px;
  background: transparent;
`;

const Posts = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
  margin-top: 6rem;
  margin-bottom: 3rem;
`;

const NoPostImg = styled.img`
  width: 20rem;
`;

const NoPostWord = styled.p`
  display: flex;
  width: 392px;
  height: 89px;
  flex-direction: column;
  justify-content: center;
  color: #acacac;
  text-align: center;
  font-family: Inter;
  font-size: 2rem;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  margin-top: 3rem;
  margin-bottom: 2rem;
`;
const Circle = styled.span`
  position: absolute;
  width: 5px;
  height: 5px;
  border-radius: 5px;
  bottom: -5px;
  left: 0;
  right: 0;
  margin: 0 auto;
  background-color: ${(props) => props.theme.red};
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
        <Selector>
          <Writing>
            글<Circle />
          </Writing>
          <Writing style={{ color: "#ECECEC" }}>시리즈</Writing>
          <Writing style={{ color: "#ECECEC" }}>소개</Writing>
        </Selector>
        <div>
          <Search>
            <Section>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="17"
                height="17"
                viewBox="0 0 17 17"
                fill="none"
                style={{ marginRight: "0.5rem" }}
              >
                <path
                  fill-rule="evenodd"
                  d="M13.66 7.36a6.3 6.3 0 1 1-12.598 0 6.3 6.3 0 0 1 12.598 0zm-1.73 5.772a7.36 7.36 0 1 1 1.201-1.201l3.636 3.635c.31.31.31.815 0 1.126l-.075.075a.796.796 0 0 1-1.126 0l-3.636-3.635z"
                  clip-rule="evenodd"
                  fill="#ececec"
                ></path>
              </svg>
              <Input placeholder="검색어를 입력하세요" />
            </Section>
          </Search>
          <Posts>
            <NoPostImg src={nopost} />
            <NoPostWord>포스트가 없습니다.</NoPostWord>
          </Posts>
        </div>
      </MyPageInfo>
    </Background>
  );
}

export default MyPage;
