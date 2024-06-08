import axios from 'axios';

//익명 사용자 토큰 발급
export const anonymousToken = async () => {
  const response = await axios.get('/api/v1/auth/anonymous');
  return response.headers.authorization;
};

export const setAnonymousToken = (token: string) => {
  sessionStorage.setItem('anonymousToken', token);
};

export const getStoredAnonymousToken = () => {
  return sessionStorage.getItem('anonymousToken');
};
