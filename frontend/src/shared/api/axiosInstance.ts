import axios from 'axios';
import { getStoredAnonymousToken } from './anonymousToken.ts';

const axiosInstance = axios.create({
  baseURL:' http://localhost:8080',
});

axiosInstance.interceptors.request.use((config) => {
  const anonymousToken = getStoredAnonymousToken();
  if (anonymousToken) {
    config.headers.Authorization = `${anonymousToken}`;
  }
  return config;
});

export default axiosInstance;
