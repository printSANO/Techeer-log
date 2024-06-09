import { useAuthStore } from '../store/authStore';

const token = sessionStorage.getItem('accessToken');
export const accessToken = token ? token.split(' ')[1] : '';

// tokenService.ts
export const getAccessToken = () => sessionStorage.getItem('accessToken');
export const setAccessToken = (token: string) => sessionStorage.setItem('accessToken', token);
export const getRefreshToken = () => useAuthStore.getState().refreshToken;
