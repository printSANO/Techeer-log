import '../index.css';
import { RecoilRoot } from 'recoil';
import { GlobalStyle } from './style/globalStyle.ts';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { QueryProvider } from './QueryProvider.tsx';
import { anonymousToken, setAnonymousToken } from '../shared/api/anonymousToken.ts';
import { useEffect } from 'react';

const initializeAnonymousToken = async () => {
  const existingToken = sessionStorage.getItem('anonymousToken');
  if (!existingToken) {
    const token = await anonymousToken();
    setAnonymousToken(token);
  }
};
function App() {
  // 앱 초기화시 익명 사용자 토큰 발급
  useEffect(()=>{
    initializeAnonymousToken();
  },[]);

  return (
    <>
      <RecoilRoot>
        <QueryProvider>
          <GlobalStyle />
          <RouterProvider router={router} />
        </QueryProvider>
      </RecoilRoot>
    </>
  );
}

export default App;
