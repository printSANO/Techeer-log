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
  nickname: localStorage.getItem('nickname') || null,
  accessToken: localStorage.getItem('accessToken') || null,
  refreshToken: null,
  setnickname: (nickname) => {
    set({ nickname });
    localStorage.setItem('nickname', nickname);
  },
  login: (accessToken: string, refreshToken: string) => {
    set({ accessToken, refreshToken });
    localStorage.setItem('accessToken', accessToken);
  },
  logout: () => {
    set({ accessToken: null, refreshToken: null });
    localStorage.removeItem('accessToken');
    localStorage.removeItem('nickname');
    console.log('useAuthStore logout: ');
  },
}));
