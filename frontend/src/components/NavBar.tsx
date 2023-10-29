import styled from "styled-components";
import logo from "../assets/logo.png";
import moon from "../assets/Moon.png";
import magnifyingglass from "../assets/MagnifyingGlass.png";
import miniprofile from "../assets/MiniProfile.png";
import underpolygon from "../assets/UnderTri.png";

const Background = styled.div`
  width: 100vw;
  height: 5%;
  background-color: transparent;
  display: flex;
  justify-content: space-between;
  position: relative;
  top: 20px;
`;

const Logo = styled.img`
  width: 28px;
  height: 28px;
`;

const Title = styled.p`
  display: flex;
  width: 130px;
  height: 25px;
  flex-direction: column;
  justify-content: center;
  flex-shrink: 0;
  color: #ececec;
  text-align: center;
  font-family: Fira Mono;
  font-size: 1.3125rem;
  font-style: normal;
  font-weight: bold;
  line-height: normal;
`;

const Theme = styled.img`
  width: 28px;
  height: 28px;
`;

const Search = styled.img`
  width: 28px;
  height: 28px;
`;
const WriteButton = styled.div`
  width: 111px;
  height: 41px;
  border-radius: 20px;
  border: 1px solid #ececec;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Button = styled.div`
  display: flex;
  width: 97px;
  height: 25px;
  flex-direction: column;
  justify-content: center;
  color: #ececec;
  text-align: center;
  font-family: Inter;
  font-size: 20px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;

const MiniProfile = styled.img`
  width: 41px;
  height: 41px;
  border-radius: 41px;
  background: lightgray 50% / cover no-repeat;
`;

const Menu = styled.img`
  width: 13px;
  height: 13px;
  fill: #acacac;
`;

const Left = styled.div`
  display: flex;
  flex-direction: row;
  left: 80px;
  gap: 18px;
  position: absolute;
`;

const Right = styled.div`
  display: flex;
  right: 80px;
  gap: 18px;
  flex-direction: row;
  position: absolute;
  align-items: center;
  justify-content: center;
`;

function NavBar() {
  return (
    <Background>
      <Left>
        <Logo src={logo} />
        <Title>Console.log</Title>
      </Left>
      <Right>
        <Theme src={moon} />
        <Search src={magnifyingglass} />
        <WriteButton>
          <Button>새 글 작성</Button>
        </WriteButton>
        <MiniProfile src={miniprofile} />
        <Menu src={underpolygon} />
      </Right>
    </Background>
  );
}

export default NavBar;
