import { useEffect, useState } from 'react';
import axios from 'axios';
import { useAuthStore } from '../../../shared/store/authStore';
import { useNavigate } from 'react-router-dom';
import * as api from '../../../shared/api/index';
// import { handleLogin } from '../api/login';

export function LogIn() {
  const [loginId, setLoginId] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  // 토큰 상태 관리 함수
  // const authStore = useAuthStore((state) => state.login);
  // const logout = useAuthStore((state) => state.logout);
  const { login, setnickname, accessToken } = useAuthStore();
  const callToken = async () => {
    try {
      const tokenData = await api.anonymousToken();
      if (accessToken === null) login(tokenData, '');
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    callToken();
  }, []);

  const loginIdChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setLoginId(event.target.value);
  };

  const passwordChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(event.target.value);
  };

  const toLogin = () => {
    navigate('/signup');
  };
  // // 액세스 토큰 재발급
  // const refreshAccessToken = async () => {
  //   try {
  //     // zustand에서 상태 가져오기
  //     const { refreshToken } = useAuthStore.getState();
  //     console.log('refreshAccessToken: ');

  //     // axios 요청 헤더에 토큰 정보 포함하여 요청 보내기
  //     const response = await axios.post(
  //       '/api/v1/auth/refresh',
  //       {},
  //       {
  //         headers: {
  //           refresh_token: refreshToken,
  //         },
  //       },
  //     );

  //     // 새로 발급받은 토큰 정보 저장
  //     if (refreshToken != null) {
  //       // 응답 헤더에서 토큰 정보 추출 : response.headers['authorization']
  //       authStore(response.headers['authorization'], refreshToken);
  //       // authStore('new', refreshToken);
  //     }
  //   } catch (error) {
  //     console.error('토큰 재발급에 실패했습니다.', error);
  //   }
  // };

  // 액세스 토큰 만료 5분 전에 토큰 재발급
  // const setAccessTokenTimeout = () => {
  //   // 액세스 토큰 만료 시간 55분으로 설정
  //   const EXPIRES_IN = 55 * 60 * 1000;
  //   setTimeout(() => {
  //     refreshAccessToken();
  //   }, EXPIRES_IN);
  // };

  const handleNickname = async (newAccessToken: string) => {
    try {
      const response = await axios.get('/api/v1/members/profile', {
        headers: {
          authorization: newAccessToken,
        },
      });
      console.log('handleNickname: ', response.data.data.nickname, accessToken);
      setnickname(response.data.data.nickname);
      navigate('/');
    } catch (error) {
      console.error('닉네임 정보를 가져오는데 실패했습니다', error);
    }
  };

  const handleLogin = async () => {
    try {
      console.log('handleLogin: ', loginId, password);
      const response = await axios.post(
        '/api/v1/auth/login',
        {
          loginId,
          password,
        },
        {
          headers: {
            authorization: accessToken,
          },
        },
      );

      // 응답 헤더에서 토큰 정보 추출
      const newAccessToken = response.headers['authorization'];
      const newRefreshToken = response.headers['refresh-token'];

      // const accessToken = 'Bearer asdf';
      // const refreshToken = 'Bearer asdf';

      console.log('handleLogin: ', newAccessToken, newRefreshToken);

      // 발급받은 토큰 정보 저장
      // Access Token은 클라이언트 관리, Refresh Token은 전역 관리
      //localStorage.setItem('accessToken', newAccessToken);
      login(newAccessToken, newRefreshToken);
      handleNickname(newAccessToken);
      // logout(); //test

      // 토큰 타이머
      // setAccessTokenTimeout();
    } catch (error) {
      alert('로그인에 실패했습니다');
    }
  };

  const handleSubmit = async () => {
    handleLogin();
  };

  return (
    // 전체 배경
    <div className="bg-[#111111] bg-opacity-90 flex w-screen h-screen justify-center items-center">
      {/* 모달 이미지 배경 */}
      <div className="rounded-[1.25rem] bg-cover bg-[url('./src/shared/assets/image/loginImg/Background-Login.png')] bg-no-repeat flex flex-row w-[60rem] h-[37.5rem]">
        {/* 왼쪽 박스 텍스트 그룹 */}
        <div className="flex flex-col justify-center ml-8 box-sizing-border w-[55%] gap-2">
          <p className="break-words font-['Bayon'] font-normal text-[3rem] text-[#FFFFFF]">Techeer.log</p>
          <p className="break-words font-['Pretendard'] font-light text-[1rem] text-[#FFFFFF]">
            테커에서 진행한 <span className="font-['Pretendard-SemiBold']">다양한 프로젝트를 한눈에</span>
          </p>
        </div>
        {/* 오른쪽 박스 블러 배경 */}
        {/* 로그인 폼 */}
        <div className="gap-4 backdrop-blur-[1.25rem] rounded-r-[1.25rem] bg-[rgba(0,1,58,0.7)] flex flex-col justify-center items-center w-[31.875rem]">
          <div className="m-[0_0_4.625rem_0] inline-block break-words font-['Pretendard'] font-semibold text-[2.25rem] tracking-[0.044rem] leading-[1.333] text-[#F0F0F0]">
            로그인
          </div>
          {/* 아이디 입력 Input */}
          <div className="rounded-[0.375rem] border border-solid border-[#E2E2E2] border-1 relative flex flex-row w-[18.25rem] h-[3.125rem]">
            <div className="flex flex-row justify-center items-center p-[0.625rem]">
              <img className="w-[1.125rem] h-[1.125rem]" src="./src/shared/assets/image/loginImg/Icon-Id.png" />
            </div>
            {/* <span className="break-words font-['Pretendard'] font-normal text-[1rem] tracking-[0.019rem] leading-[3] text-[#BABABA]">
              아이디
            </span> */}
            <input
              type="text"
              name="id"
              placeholder="아이디"
              required
              className="w-[11.25rem] m-[0.625rem] bg-transparent font-['Pretendard'] text-[1rem] text-[#E2E2E2] focus:outline-none bg-transparent"
              value={loginId}
              onChange={loginIdChange}
            />
          </div>
          {/* 비밀번호 입력 Input */}
          <div className="rounded-[0.375rem] border border-solid border-[#E2E2E2] border-1 relative flex flex-row w-[18.25rem] h-[3.125rem]">
            <div className="flex flex-row justify-center items-center p-[0.625rem]">
              <img className="w-[1.125rem] h-[1.125rem]" src="./src/shared/assets/image/loginImg/Icon-Password.png" />
            </div>
            {/* <span className="break-words font-['Pretendard'] font-normal text-[1rem] tracking-[0.019rem] leading-[3] text-[#BABABA]">
              비밀번호
            </span> */}
            <input
              type="password"
              name="password"
              placeholder="비밀번호"
              required
              className="w-[11.25rem] m-[0.625rem] bg-transparent font-['Pretendard'] text-[1rem] text-[#E2E2E2] focus:outline-none bg-transparent"
              value={password}
              onChange={passwordChange}
            />
          </div>
          {/* 로그인 버튼 */}
          <div
            onClick={handleSubmit}
            className="cursor-pointer rounded-[0.375rem] bg-[#4344E0] relative flex flex-row justify-center w-[292px]"
          >
            <button
              type="submit"
              className="relative break-words font-['Pretendard'] font-normal text-[1rem] tracking-[0.019rem] leading-[3] text-[#FFFFFF]"
            >
              로그인
            </button>
          </div>
          <span
            onClick={toLogin}
            className="cursor-pointer m-[0_0_0_0.063rem] break-words font-['Pretendard'] font-normal text-[1rem] underline tracking-[0.019rem] leading-[3] text-[#757575]"
          >
            회원가입
          </span>
        </div>
      </div>
    </div>
  );
}
