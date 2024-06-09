import axios from 'axios';
import { getAccessToken, getRefreshToken, setAccessToken } from '../authorization/getToken.ts';
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
    const originalRequest = error.config;

    if (error.response.status === 400 && !originalRequest._retry) {
      originalRequest._retry = true;

      const refreshToken = getRefreshToken();
      if (!refreshToken) {
        const anonymousToken = await setAnonymousToken();
        originalRequest.headers.Authorization = anonymousToken;
        return axiosInstance(originalRequest);
      }

      try {
        const {
          headers: { authorization: accessToken },
        } = await axios.get('/api/v1/auth/refresh', {
          headers: { authorization: getAccessToken(), 'refresh-token': refreshToken },
        });
        setAccessToken(accessToken);

        axiosInstance.defaults.headers.common.Authorization = accessToken;
        originalRequest.headers.Authorization = accessToken;
        return axiosInstance(originalRequest);
      } catch (e) {
        // console.log('expired-refreshToken', refreshToken);

        useAuthStore.getState().logout();

        await setAnonymousToken();

        window.location.assign('/login');
      }
    }

    return Promise.reject(error);
  },
);

const setAnonymousToken = async () => {
  const accessToken = await anonymousToken();
  setAccessToken(accessToken);
  axiosInstance.defaults.headers.common.Authorization = `${accessToken}`;
  return accessToken;
};

export default axiosInstance;
