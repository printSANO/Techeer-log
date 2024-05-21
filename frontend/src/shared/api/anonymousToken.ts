import axios from 'axios';

export const anonymousToken = async () => {
  const response = await axios.get('/api/v1/auth/anonymous');

  return response.headers.authorization;
};
