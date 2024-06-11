import { create } from 'zustand';

type AuthState = {
  nickname: string | null;
  accessToken: string | null;
  refreshToken: string | null;
  setNickname: (nickname: string) => void;
  login: (accessToken: string, refreshToken: string) => void;
  logout: () => void;
};

export const useAuthStore = create<AuthState>((set) => ({
  nickname: sessionStorage.getItem('nickname'),
  accessToken: sessionStorage.getItem('accessToken'),
  refreshToken: sessionStorage.getItem('refreshToken'),
  setNickname: (nickname) => {
    set({ nickname });

    sessionStorage.setItem('nickname', nickname);
  },
  login: (accessToken: string, refreshToken: string) => {
    set({ accessToken, refreshToken });

    sessionStorage.setItem('accessToken', accessToken);
    sessionStorage.setItem('refreshToken', refreshToken);
  },
  logout: () => {
    set({ accessToken: null, refreshToken: null });

    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('refreshToken');
    sessionStorage.removeItem('nickname');
  },
}));
