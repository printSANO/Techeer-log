import styled from "styled-components";
import NavBar from "../components/NavBar";
import { AiOutlineClockCircle } from "react-icons/ai";
import more from "../assets/More.png";
import mainimg from "../assets/MainImg.png";
import line from "../assets/Line.png";
import profileimg from "../assets/ProfileImg.png";
import LoginModal from "../components/LoginModal";
import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Background = styled.div`
  width: 100vw;
  height: 200vh;
  background: #121212;
  display: flex;
  flex-direction: column;
  position: relative;
`;

const Header = styled.div`
  width: 100%;
  height: 51px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 1.5rem;
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
  margin-top: 32px;

  margin-left: auto;
  margin-right: auto;
  gap: 40px 55px;
`;

const Box = styled.div`
  width: 310px;
  height: 380px;
  background-color: #1e1e1e;
  border-radius: 10px;
  cursor: pointer;
`;

const MainImg = styled.img`
  width: 310px;
  height: 175.75px;
  border-radius: 10px;
`;

const Bottom = styled.div`
  padding-top: 12px;
`;

const Title = styled.p`
  display: flex;
  width: 100%;
  height: 32px;
  flex-direction: column;
  color: #fff;
  font-family: Inter;
  font-size: 1rem;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  padding-left: 16px;
`;

const Info = styled.p`
  display: flex;
  width: 100%;
  height: 43px;
  flex-direction: column;
  justify-content: center;
  color: #acacac;
  font-family: Inter;
  font-size: 0.75rem;
  line-height: 1.5;
  font-style: normal;
  font-weight: 400;
  padding: 16px;
  margin-top: 50px;
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
  align-items: center;
  padding: 0.425rem 1rem;
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
  font-size: 15px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
`;

const ModalWrapper = styled.div`
  position: absolute;
  z-index: 2;
`;

interface FormType {
  title: string;
  nickname: string;
  createdAt: string;
}

function MainPage() {
  //마지막 게시글 번호 조회
  const [lastPost, setLastPost] = useState("");
  const [posts, setPosts] = useState([]);
  const getPostList = (): void => {
    axios
      .get("/post/0", {
        params: { page: 0, size: 10, sort: "desc" },
      })
      .then((res) => {
        const postsData = res.data.data.posts;
        setPosts(postsData);
        setLastPost(res.data.data.posts[0].id);
        console.log(lastPost);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  useEffect(() => {
    getPostList();
  }, []);

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
          {posts.length > 0 &&
            posts.map((data: FormType, index) => (
              <Link to="/board">
                <Box key={index}>
                  <MainImg src={mainimg} />
                  <Bottom>
                    <Title>{data.title}</Title>
                    <Info>
                      작성일 : {data.createdAt.replace("T", " ")} · 5개의 댓글
                    </Info>
                    <Line src={line} />
                    <DetailUnder>
                      <a style={{ display: "flex", paddingTop: "4px" }}>
                        <ProfileImg src={profileimg} />
                        <span style={{ color: "#fff", paddingLeft: "8px" }}>
                          by
                          <b
                            style={{
                              color: "#ECECEC",
                              fontWeight: "bold",
                              paddingLeft: "5px",
                            }}
                          >
                            {data.nickname}
                          </b>
                        </span>
                      </a>
                      <Like>❤︎ 54</Like>
                    </DetailUnder>
                  </Bottom>
                </Box>
              </Link>
            ))}
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
