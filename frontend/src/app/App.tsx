import '../index.css';
import { RecoilRoot } from 'recoil';
import { GlobalStyle } from './style/globalStyle.ts';
import { RouterProvider } from 'react-router-dom';
import { router } from './router/index.ts';
import { QueryClient, QueryClientProvider } from 'react-query';

const queryClient = new QueryClient();
function App() {
  return (
    <>
      <QueryClientProvider client={queryClient}>
        <RecoilRoot>
          <GlobalStyle />
          <RouterProvider router={router} />
        </RecoilRoot>
      </QueryClientProvider>
    </>
  );
}

export default App;
