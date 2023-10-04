
import {styled} from "styled-components";

const [name, email, id, intro] = '';

const Background = styled.div`
    width: 100vw;
    height: 100vh;
    background: #121212;    
`;
const SignUpBox = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    width: 800px;
    height: 900px;

    position: relative; /* 추후 박스 하단에 추가 버튼을 위치시키기 위한 설정 */
    margin: 0 auto; /* 페이지 중앙에 나타나도록 설정 */
    margin-bottom: 32px;
    /* padding: 40px 20px; */

    flex-shrink: 0;
    text-align: left;
    color: white;
    /* color: #2f2f2f; */
    
`;

const Header = styled.div`
& h1{
    font-size: 60px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    margin-bottom: 15px;
}

& p{
    font-size: 23px;
    font-style: normal;
    font-weight: 400;
    margin-bottom: 50px;
}
    
`;

const InfoBox = styled.div`
    margin-bottom: 10px;
    & p {
        font-size: 18px;
        font-weight: 600;
        margin-bottom: 30px;
    }  

    &:focus-within{
        p{
            color: #38E788;
        }
    }

`;

const InputBox = styled.input`
    font-size: 23px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    outline: none;
    width: ${props=>props.width};

    height: 40px;
    background-color: inherit;
    border-style: none;
    padding-bottom: 10px;
    border-bottom: 2px solid #BBBBBB;
    margin-bottom: 20px;

    &:focus {
        border-bottom: 2px solid #38E788;
    }

    
`;

const ButtonBox = styled.div`
    display: flex;
    flex-direction: row;
    position: absolute;
    bottom: 0px;
`;

const ButtonStyle = styled.button<{bgColor:string}>`
    margin-right: 15px;
    width: 105px;
    height: 47px;
    flex-shrink: 0;
    border-style: none;
    border-radius: 30px;
    background-color: ${props => props.bgColor};

    justify-content: center;
    color:${props => props.color};;
    text-align: center;
    padding-top: 5px;
    font-size: 24px;
    font-weight: 600;
`;


function SignUp(){

    return(
        <Background>
            <SignUpBox>
                <Header>
                    <h1>환영합니다!</h1>
                    <p>기본 회원정보를 등록해주세요.</p>
                </Header>

                <InfoBox>
                    <p>이름</p>
                    <label>
                        <InputBox type='text' value={name} placeholder='이름을 입력하세요' width={"30%"}/>
                    </label>
                </InfoBox>
                <InfoBox>
                    <p>이메일</p>
                    <label>
                        <InputBox type='email' value={email} placeholder='이메일을 입력하세요' width={"35%"}/>
                    </label>
                </InfoBox>
                <InfoBox>
                    <p>아이디</p>
                    <label>
                        <InputBox type='text' value={id} placeholder='아이디를 입력하세요' width={"26%"}/>
                    </label>
                </InfoBox>
                <InfoBox>
                    <p>한 줄 소개</p>
                    <label>
                        <InputBox type='text' value={intro} placeholder='당신을 한 줄로 소개해보세요' width={"50%"}/>
                    </label>
                </InfoBox>

                <ButtonBox>
                    <ButtonStyle type='submit' bgColor="#D9D9D9" color="#000000">취소</ButtonStyle>
                    <ButtonStyle type='submit' bgColor="#38E788" color="#FFFFFF">다음</ButtonStyle>
                </ButtonBox>

            </SignUpBox>
        </Background>
    )

}

export default SignUp;