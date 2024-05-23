import { useNavigate } from 'react-router-dom';
import { useAuthStore } from '../store/authStore';
import axios from 'axios';

export default function NavBar() {
  const { logout, nickname, accessToken } = useAuthStore();
  const navigate = useNavigate();

  const goLogin = () => {
    navigate('/login');
  };
  const loginApi = async () => {
    try {
      await axios.get('/api/v1/auth/logout', {
        headers: {
          authorization: accessToken,
        },
      });
      logout();
      window.location.replace('/');
    } catch (error) {
      alert('로그인에 실패했습니다');
    }
  };
  const handleLogout = () => {
    loginApi();
  };
  return (
    <div className="fixed top-0 w-screen flex justify-center items-center">
      <div className="backdrop-blur-[4px] flex flex-row items-center justify-between py-2 px-3 w-[1200px] box-sizing-border">
        <div className="flex flex-row justify-center my-2">
          <span className="break-words font-['Bayon'] font-normal text-[2rem] text-[#EFEFEF]">Techeer.log</span>
        </div>
        <div className="flex flex-row justify-between w-[11rem] h-[fit-content] box-sizing-border">
          <div className="flex flex-row justify-center box-sizing-border">
            <span className="break-words font-['Pretendard'] font-normal text-[1rem] leading-[1.5] text-[#FFFFFF]">
              소개
            </span>
          </div>
          <div className="flex flex-row justify-center box-sizing-border">
            <span className="break-words font-['Pretendard'] font-normal text-[1rem] leading-[1.5] text-[#FFFFFF]">
              프로젝트
            </span>
          </div>
          <div className="rounded-[0.3rem] flex flex-row justify-center box-sizing-border">
            {!nickname ? (
              <span
                onClick={goLogin}
                className="cursor-pointer break-words font-['Pretendard'] font-medium text-[1rem] leading-[1.5] text-[#FFFFFF]"
              >
                LOGIN
              </span>
            ) : (
              <span
                onClick={handleLogout}
                className="cursor-pointer break-words font-['Pretendard'] font-medium text-[1rem] leading-[1.5] text-[#FFFFFF]"
              >
                LOGOUT
              </span>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}
