
import {styled} from "styled-components";
import signupimg from "../assets/MainImg.png"
import { ChangeEvent, useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Background = styled.div`
    width: 98.5vw;
    height: 140vh;
    background: #121212;    
`;

const SignUpBox = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    width: 800px;
    /* height: 100vh; */

    position: relative; /* 추후 박스 하단에 추가 버튼을 위치시키기 위한 설정 */
    margin: 0 auto; /* 페이지 중앙에 나타나도록 설정 */
    margin-bottom: 32px;
    padding: 40px 0px;

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

const ProfileBox = styled.div`
    display: flex;
    flex-direction: column;
    margin-bottom: 40px;

`;
const ImgBox = styled.div`
    height: 9rem;
    width: 9rem;
    display: flex;
    align-items: center;
    justify-content: center;

    margin-left: 30px;
    margin-bottom: 20px;
`;

const ProfileImg = styled.img`
    border: none;
    border-radius: 50%;

    width: 130px;
    height: 130px;
    
`;
const ImgLabel = styled.label`
    font-size: 20px;
    font-weight: 600;
    margin-left: 30px;
    color: #bcbcbc;
    cursor: pointer;
    /* margin-bottom: 20px; */
`;

const ImgFile = styled.input`
    display: none;
    /* margin-bottom: 20px; */
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
    /* position: absolute; */
    margin-top: 20px;
    /* bottom: 10px; */
`;

const ButtonStyle = styled.button<{bgColor:string}>`
    margin-right: 15px;
    width: 120px;
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
    const navigate = useNavigate();

    const [username, setUser] = useState("");
    const [userid, setId] = useState("");
    const [password, setPassword] = useState("");
    const [passwordCheck, setPasswordCheck] = useState("");
    const [isLoading, setLoading] = useState(false);

    useEffect(()=>{

    },[username, userid, password, passwordCheck]
    )

    const onChange = (e:ChangeEvent<HTMLInputElement>)=>{
        const {
            target:{name, value},
        } = e
        
        if(name === "username"){
            setUser(value);
        }else if(name ==="id"){
            setId(value);
        }else if(name === "password"){
            setPassword(value);
        }else if(name === "passwordcheck"){
            setPasswordCheck(value);
        }
    }

    const onSubmit = () => {
        setLoading(true);
        try {
            handleSignUp()
              .then(() => {})
              .catch((error) => {
                console.log(error);
              });
          } catch (error) {
            console.log(error);
          }
    }

    const handleGoBack = () => {
        navigate(-1);
    };

    return(
        <Background>
            <SignUpBox>
                <Header>
                    <h1>환영합니다!</h1>
                    <p>기본 회원정보를 등록해주세요.</p>
                </Header>

                <ProfileBox>
                    <ImgBox>
                        <ProfileImg src={signupimg}/>
                    </ImgBox>

                    <ImgLabel htmlFor="profileImg"> 
                        프로필 이미지 추가 
                            <ImgFile type="file" accept="image/*" id="profileImg"></ImgFile>
                    </ImgLabel>
                </ProfileBox>

                <InfoBox>
                    <p>이름</p>
                    <label>
                        <InputBox type='text' name="username" value={username} onChange={onChange} placeholder='이름을 입력하세요' required width={"30%"}/>
                    </label>
                </InfoBox>
                {/* <InfoBox>
                    <p>이메일</p>
                    <label>
                        <InputBox type='email' value={email} placeholder='이메일을 입력하세요' width={"35%"}/>
                    </label>
                </InfoBox> */}
                <InfoBox>
                    <p>아이디</p>
                    <label>
                        <InputBox type='text' name="userid" value={userid} onChange={onChange} placeholder='아이디를 입력하세요' required width={"26%"}/>
                    </label>
                </InfoBox>
                <InfoBox>
                    <p>비밀번호</p>
                    <label>
                        <InputBox type='text' name="password" value={password} onChange={onChange} placeholder='비밀번호를 입력하세요' required width={"40%"}/>
                    </label>
                </InfoBox>
                <InfoBox>
                    <p>비밀번호 확인</p>
                    <label>
                        <InputBox type='text' name="passwordcheck" value={passwordCheck} onChange={onChange}placeholder='비밀번호를 한 번 더 입력하세요'required width={"40%"}/>
                    </label>
                </InfoBox>

                <ButtonBox>
                    <ButtonStyle type='submit' onClick={handleGoBack} bgColor="#D9D9D9" color="#000000">취소</ButtonStyle>
                    <ButtonStyle 
                        type='submit' 
                        onClick={onSubmit} 
                        value={isLoading? "Loading..." : "Create Account"} 
                        bgColor="#38E788" 
                        color="#FFFFFF"
                    >
                        가입하기
                    </ButtonStyle>
                </ButtonBox>

            </SignUpBox>
        </Background>
    )

}

export default SignUp;