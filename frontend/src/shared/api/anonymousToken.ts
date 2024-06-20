import axios from 'axios';

//익명 사용자 토큰 발급
const baseURL = import.meta.env.VITE_BASE_URL;

export const anonymousToken = async () => {
  const response = await axios.get(`${baseURL}/api/v1/auth/anonymous`);
  return response.headers.authorization;
};
