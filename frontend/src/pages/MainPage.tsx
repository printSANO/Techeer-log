import styled from "styled-components";
import NavBar from "../components/NavBar";
import { AiOutlineClockCircle } from "react-icons/ai";
import more from "../assets/More.png";
import mainimg from "../assets/MainImg.png";
import line from "../assets/Line.png";
import profileimg from "../assets/ProfileImg.png";
import LoginModal from "../components/LoginModal";

const Background = styled.div`
  width: 100vw;
  height: 100vh;
  background: #121212;
  display: flex;
  flex-direction: column;
  position: relative;
`;

const Header = styled.div`
  width: 100%;
  height: 51px;
  position: relative;
  top: 66px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 30px;
`;

const Headers = styled.div`
  display: flex;
  flex-direction: row;
  position: relative;
  width: 14rem;
  height: 100%;
  margin-left: 85px;
  margin-bottom: 1rem;
  gap: 20px;
`;

const NewWord2 = styled.a`
  color: #ececec;
  text-align: center;
  font-family: Inter;
  font-size: 20px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;

const ButtonLine = styled.div`
  position: absolute;
  width: 50%;
  height: 2px;
  background: #e0e0e0;
  bottom: 0;
`;

const Buttonleft = styled.button`
  background-color: transparent;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  border: none;
  gap: 10px;
`;

const More = styled.img`
  width: 30px;
  height: 30px;
  position: absolute;
  right: 70px;
`;

const Row = styled.div`
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(2, 1fr);
  margin-top: 100px;

  margin-left: auto;
  margin-right: auto;
  gap: 30px 55px;
`;

const Box = styled.div`
  width: 310px;
  height: 380px;
  background-color: #1e1e1e;
  border-radius: 10px;
`;

const MainImg = styled.img`
  width: 310px;
  height: 175.75px;
  border-radius: 10px;
`;

const Bottom = styled.div`
  padding-top: 5px;
`;

const Title = styled.p`
  display: flex;
  width: 100%;
  height: 32px;
  flex-direction: column;
  justify-content: center;
  color: #fff;
  text-align: center;
  font-family: Inter;
  font-size: 15px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  padding-right: 25px;
`;

const Detail = styled.p`
  display: flex;
  width: 100%;
  height: 43px;
  flex-direction: column;
  justify-content: center;
  color: #cfcfcf;
  font-family: Inter;
  font-size: 13px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  padding: 15px;
  margin-bottom: 25px;
`;

const Info = styled.p`
  display: flex;
  width: 100%;
  height: 43px;
  flex-direction: column;
  justify-content: center;
  color: #cfcfcf;
  font-family: Inter;
  font-size: 11px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  padding: 15px;
`;

const Line = styled.img`
  width: 100%;
  height: 1px;
  background: #403f3f;
`;

const DetailUnder = styled.div`
  display: flex;
  line-height: 1.5;
  justify-content: space-between;
  padding: 0px 15px 0px 15px;
  align-items: center;
`;

const ProfileImg = styled.img`
  width: 23px;
  height: 23px;
`;

const Like = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: #cfcfcf;
  font-family: Inter;
  font-size: 11px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
`;

const ModalWrapper = styled.div`
  position: absolute;
  z-index: 2;
`;

function MainPage() {
  return (
    <>
      <Background>
        <NavBar />
        <Header>
          <Headers>
            <Buttonleft>
              <AiOutlineClockCircle size="24" color="#ececec" />
              <NewWord2>최신</NewWord2>
              <ButtonLine />
            </Buttonleft>
          </Headers>
          <More src={more} />
        </Header>
        <Row>
          <Box>
            <MainImg src={mainimg} />
            <Bottom>
              <Title>개발자가 되고싶으시다구요? (매운맛)</Title>
              <Detail>
                결과에서 오는 성취감도 없으면 그만두세요. 힘들어요.
              </Detail>
              <Info>5일전 ∙ 33개의 댓글</Info>
              <Line src={line} />
              <DetailUnder>
                <a style={{ display: "flex", paddingTop: "4px" }}>
                  <ProfileImg src={profileimg} />
                  <span style={{ color: "#fff", paddingLeft: "5px" }}>
                    by
                    <b
                      style={{
                        color: "#ECECEC",
                        fontWeight: "bold",
                        paddingLeft: "5px",
                      }}
                    >
                      junjun
                    </b>
                  </span>
                </a>
                <Like>❤︎ 54</Like>
              </DetailUnder>
            </Bottom>
          </Box>
          <Box />
          <Box />
          <Box />
          <Box />
          <Box />
          <Box />
          <Box />
          <Box />
          <Box />
        </Row>
        {/* 
        <ModalWrapper>
          <LoginModal />
        </ModalWrapper> */}
      </Background>
    </>
  );
}

export default MainPage;
