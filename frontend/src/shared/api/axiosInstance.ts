import axios from 'axios';
import { getAccessToken, getRefreshToken, setAccessToken } from '../authorization/getToken.ts';
import { useNavigate } from 'react-router-dom';
import { useAuthStore } from '../store/authStore.ts';
import { anonymousToken } from './anonymousToken.ts';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:3000',
});

axiosInstance.interceptors.request.use((config) => {
  const token = getAccessToken();
  if (token) {
    config.headers.Authorization = `${token}`;
  } else {
    console.log('accesstoken이 비어 있습니다.');
  }
  return config;
});

axiosInstance.interceptors.response.use(
  (response) => response,
  async (error) => {
    console.log('error intercept', error);
    const originalRequest = error.config;
    if (error.response.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;

      const refreshToken = getRefreshToken();
      if (refreshToken) {
        console.log('refreshToken:', refreshToken);
        try {
          const response = await axios.get('/api/v1/auth/refresh', { params: { refreshToken } });
          const accessToken = response.headers.authorization;
          setAccessToken(accessToken);

          axiosInstance.defaults.headers.common.Authorization = `${accessToken}`;
          originalRequest.headers.Authorization = `${accessToken}`;
          return axiosInstance(originalRequest);
        } catch (e) {
          console.error('Refresh token is invalid', e);
          //로그아웃
          handleLogout();
          //익명토큰 헤더 설정
          await setAnonymousTokenHeader();

          const navigate = useNavigate();
          navigate('/login');
        }
      } else {
        //익명사용자 토큰요청해서 헤더 설정
        originalRequest.headers.Authorization = `${await setAnonymousTokenHeader()}`;
      }
    }
    return Promise.reject(error);
  },
);

const handleLogout = () => {
  useAuthStore.getState().logout;
};

const setAnonymousTokenHeader = async () => {
  const accessToken = await anonymousToken();
  axiosInstance.defaults.headers.common.Authorization = `${accessToken}`;
  return accessToken;
};

export default axiosInstance;
