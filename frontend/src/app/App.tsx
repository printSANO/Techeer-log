import '../index.css';
import { RecoilRoot } from 'recoil';
import { GlobalStyle } from './style/globalStyle.ts';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { QueryProvider } from './QueryProvider.tsx';
import { anonymousToken } from '../shared/api';
import { useEffect } from 'react';
import { setAccessToken } from '../shared/authorization/getToken.ts';

const initializeAnonymousToken = async () => {
  const existingToken = sessionStorage.getItem('anonymousToken');
  if (!existingToken) {
    console.log('익명토큰 요청');
    const token = await anonymousToken();
    setAccessToken(token);
  }
};
function App() {
  // 앱 초기화시 익명 사용자 토큰 발급
  useEffect(() => {
    initializeAnonymousToken();
  }, []);

  return (
    <RecoilRoot>
      <QueryProvider>
        <GlobalStyle />
        <RouterProvider router={router} />
      </QueryProvider>
    </RecoilRoot>
  );
}

export default App;
