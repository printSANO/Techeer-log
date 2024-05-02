import { create } from 'zustand';

type AuthState = {
  accessToken: string | null;
  refreshToken: string | null;
  login: (accessToken: string, refreshToken: string) => void;
  logout: () => void;
};

export const useAuthStore = create<AuthState>((set) => ({
  accessToken: null,
  refreshToken: null,
  login: (accessToken: string, refreshToken: string) => {
    set({ accessToken, refreshToken });
  },
  logout: () => {
    set({ accessToken: null, refreshToken: null });
  },
}));
