import '../index.css';
import { RecoilRoot } from 'recoil';
import { GlobalStyle } from './style/globalStyle.ts';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { QueryProvider } from './QueryProvider.tsx';
import { anonymousToken } from '../shared/api';
import { useEffect, useState } from 'react';
import { setAccessToken } from '../shared/authorization/getToken.ts';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';

const initializeAnonymousToken = async () => {
  const accessToken = sessionStorage.getItem('accessToken');
  if (!accessToken) {
    const token = await anonymousToken();
    setAccessToken(token);
  }
};
function App() {
  const [isInitialized, setIsInitialized] = useState(false);

  useEffect(() => {
    const init = async () => {
      await initializeAnonymousToken();
      setIsInitialized(true);
    };
    init();
  }, []);

  if (!isInitialized) {
    return <div className="w-screen h-screen bg-[#111111]"></div>;
  }

  return (
    <RecoilRoot>
      <QueryProvider>
        <ReactQueryDevtools initialIsOpen={true} />
        <GlobalStyle />
        <RouterProvider router={router} />
      </QueryProvider>
    </RecoilRoot>
  );
}

export default App;
