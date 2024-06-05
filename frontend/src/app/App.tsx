import '../index.css';
import { RecoilRoot } from 'recoil';
import { GlobalStyle } from './style/globalStyle.ts';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
const queryClient = new QueryClient();
function App() {
  return (
    <>
      <RecoilRoot>
        <QueryClientProvider client={queryClient}>
            <GlobalStyle />
            <RouterProvider router={router} />
        </QueryClientProvider>
      </RecoilRoot>
    </>
  );
}

export default App;
