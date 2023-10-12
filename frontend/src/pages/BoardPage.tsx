import styled from "styled-components";
import NavBar from "../components/NavBar";
import boardimg from "../assets/BoardImg.png"
import heartline from "../assets/Heart.png"
import share from "../assets/Share.png"

const Background = styled.div`
    width: 100vw;
    height: 100vh;
    background: #121212;    
    overflow-x: hidden;
`;

const Body = styled.div`
    /* background: #121212; */
    /* width: 100%; */
    height: 100vh;
    margin: 10% 20%;
    display: flex;
    flex-direction: column;  
    /* overflow-x: hidden; */
`;

const Header = styled.div`
    margin: 20px 10px;
    justify-content: left;
`;

const Title = styled.div`
    color: #ECECEC;
    font-size: 50px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    margin-bottom: 20px;
`;

const BoardInfo = styled.div`
    display: flex;
    flex-direction: row;
    height: 30px;
    vertical-align: middle;
`;

const User = styled.p`
    color: #FFF;
    font-size: 20px;
    font-style: normal;
    font-weight: 600;
    /* line-height: normal; */
    margin-right: 20px;
`;

const DateTime = styled.p`
    color: #FFF;
    font-family: Inter;
    font-size: 20px;
    font-style: normal;
    font-weight: 400;
    /* line-height: normal; */
`;


const KeyWord = styled.a`
    
    border-radius: 20px;
    background: #414141;
    padding: 0.4rem 1rem;
    margin-right: 20px;

    color: #96F2D7;
    font-size: 16px;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
`;

const KeyWordBox = styled.div`
    display: flex;
    flex-direction: row;
    /* justify-content: center; */
    align-items: center;
    margin-top: 10px;
`;

const Main = styled.div`
    margin-top: 10%;
    box-sizing: inherit;
    display: block;
    align-items: center;
`;

const Sentence = styled.p`
    box-sizing: inherit;
    margin: 5px 10px;
    color: #FFF;
    font-size: 18px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    letter-spacing: 1.6px;
`;

const BoardImage = styled.img`
    width: 546px;
    height: 327px;
`;

const Box = styled.div`
    box-sizing: inherit;
    display: block;
    position: relative;
    /* margin-top: 1rem; */

`
const SideBox = styled.div`
    position: absolute;
    left: -7rem;
    box-sizing: inherit;
`

const AbsoluteBox = styled.div`
    position: absolute;
    left: 100%;
    box-sizing: inherit;
`
const SideBoxRight = styled.div`
    box-sizing: inherit;
    display: flex;
    flex-direction: column;
    position: fixed;
    width: 240px;
    margin-left: 5rem;
    border-left: 2px solid #2a2a2a;
    padding: 0.25rem 0.75rem;
    color: #acacac;
`;

const Summary = styled.p`
    display: block;
    margin-bottom: 8px;
    font-size: 15px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
`

const SideBoxLeft = styled.div`
    position: fixed;
    width: 4rem;
    background: #1e1e1e;
    border: 1px solid #2a2a2a;
    border-radius: 2rem;
    padding: 0.5rem;
    display: flex;
    flex-direction: column;
    align-items: center;
`;

const CircleBox = styled.div`
    box-sizing: inherit;
    height: 3rem;
    width: 3rem;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #1e1e1e;
    border: 1px solid #4d4d4d;
    border-radius: 1.5rem;
    /* color: #acacac; */
    cursor: pointer;
    z-index: 5;
`;

const LikeNum = styled.div`
    margin-top: 0.5rem;
    color: #d9d9d9;
    line-height: 1;
    font-size: 0.75rem;
    margin-bottom: 1rem;
    font-weight: bold;
`

const Like = styled.img`
    width: 24px;
    height: 24px;
`

const Share = styled.img`
    width: 24px;
    height: 24px;
`


export default function BoardPage(){
    return(
        <Background>
            <NavBar/>
            
            
            <Body>
                <Header>
                    <Title>Promise 실전에서 사용해보기</Title>
                    <BoardInfo>
                        <User>sososo</User>
                        <DateTime>2023년 10월 12일</DateTime>
                    </BoardInfo>
                    <KeyWordBox>
                        <KeyWord>Javascript</KeyWord>
                        <KeyWord>Javascript</KeyWord>
                        <KeyWord>Javascript</KeyWord>
                    </KeyWordBox>
                    <Box>
                        <SideBox>
                            <SideBoxLeft>
                                <CircleBox>
                                    <Like src={heartline}/>
                                </CircleBox>
                                <LikeNum>7</LikeNum>
                                <CircleBox>
                                    <Share src={share}/>
                                </CircleBox>
                            </SideBoxLeft>
                        </SideBox>

                    </Box>
                    <Box>
                        <AbsoluteBox>
                            <SideBoxRight>
                                <Summary>사이드 프로젝트란 무엇일까?</Summary>
                                <Summary>promise를 생성하는 방법</Summary>
                                <Summary>promise를 생성하는 방법</Summary>
                                <Summary>promise를 생성하는 방법</Summary>
                            </SideBoxRight>
                        </AbsoluteBox>
                    </Box>
                </Header>

                
                
                <Main>
                    <BoardImage src={boardimg}/>
                    <Sentence>
                    비동기 작업이란 특정 코드의 로직이 끝날 때까지 기다리지 않고, 나머지 코드를 먼저 실행하는 것이에요. 웹사이트 개발에는 비동기 작업을 자주 사용해요. 서버에서 데이터를 불러올 때 오래 걸릴 수도 있는데, 그동안 다른 코드를 실행하지 않고 가만히 기다리면 웹 사이트를 로딩하는 게 굉장히 오래 걸리기 때문이죠.
                    </Sentence>
                </Main>




                
            </Body>

        </Background>
        

    );
}