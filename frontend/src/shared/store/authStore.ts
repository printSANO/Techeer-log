import { create } from 'zustand';

type AuthState = {
  nickname: string | null;
  accessToken: string | null;
  refreshToken: string | null;
  setnickname: (nickname: string) => void;
  login: (accessToken: string, refreshToken: string) => void;
  logout: () => void;
};

export const useAuthStore = create<AuthState>((set) => ({
  nickname: sessionStorage.getItem('nickname') || null,
  accessToken: sessionStorage.getItem('accessToken') || null,
  refreshToken: null,
  setnickname: (nickname) => {
    set({ nickname });
    sessionStorage.setItem('nickname', nickname);
  },
  login: (accessToken: string, refreshToken: string) => {
    set({ accessToken, refreshToken });
    sessionStorage.setItem('accessToken', accessToken);
  },
  logout: () => {
    set({ accessToken: null, refreshToken: null });
    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('refreshToken');
    sessionStorage.removeItem('nickname');
    console.log('useAuthStore logout: ');
  },
}));
