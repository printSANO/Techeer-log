export const getAccessToken = () => sessionStorage.getItem('accessToken');
export const setAccessToken = (token: string) => sessionStorage.setItem('accessToken', token);
export const getRefreshToken = () => sessionStorage.getItem('refreshToken');
