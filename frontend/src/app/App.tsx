import '../index.css';
import { RecoilRoot } from 'recoil';
import { GlobalStyle } from './style/globalStyle.ts';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'; // QueryClient 및 QueryClientProvider 추가
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';
const queryClient = new QueryClient();
function App() {
  return (
    <>
      <QueryClientProvider client={queryClient}>
        <ReactQueryDevtools initialIsOpen={true} />
        <RecoilRoot>
          <GlobalStyle />
          <RouterProvider router={router} />
        </RecoilRoot>
      </QueryClientProvider>
    </>
  );
}

export default App;
