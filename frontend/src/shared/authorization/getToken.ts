// zustand
// import useStore from './useStore'
// import { useTokenStore } from './stores/useTokenStore'
// const token = useStore(useTokenStore, (state) => state.bears)

const token = sessionStorage.getItem('accessToken');
export const accessToken = token? token.split(' ')[1]: '';

// tokenService.ts
export const getAccessToken = () => sessionStorage.getItem('accessToken');
export const setAccessToken = (token: string) => sessionStorage.setItem('accessToken', token);

export const getRefreshToken = () => sessionStorage.getItem('refreshToken');
export const setRefreshToken = (token: string) => sessionStorage.setItem('refreshToken', token);

