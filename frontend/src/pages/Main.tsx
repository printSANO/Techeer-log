import styled from "styled-components";
import NavBar from "../components/NavBar";
import clock from "../assets/Schedule.png";

const Background = styled.div`
  width: 100vw;
  height: 100vh;
  background: #121212;
`;

const Header = styled.div`
  width: 100%;
  height: 51px;
  position: absolute;
  top: 66px;
  display: flex;
  flex-direction: row;
`;

const NewImg = styled.img`
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const NewWord = styled.p`
  display: flex;
  width: 211px;
  height: 49px;
  flex-direction: column;
  justify-content: center;
  color: #959595;
  text-align: center;
  font-family: Inter;
  font-size: 20px;
  font-style: normal;
  font-weight: 600;
  line-height: normal;
`;

function Main() {
  return (
    <Background>
      <NavBar />
      <Header>
        <NewImg src={clock} />
        <NewWord>최신</NewWord>
      </Header>
    </Background>
  );
}

export default Main;
