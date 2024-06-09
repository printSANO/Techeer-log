import { ReactNode } from 'react';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import axiosInstance from '../shared/api/axiosInstance.ts';
export const QueryProvider = ({ children }: { children: ReactNode }) => {
  const queryClient = new QueryClient({
    defaultOptions: {
      queries: {
        queryFn: async ({ queryKey }) => {
          const { data } = await axiosInstance.get(queryKey[0] as string);
          return data;
        },
        retry: 1,
      },
    },
  });
  // const queryClient = new QueryClient();

  return <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>;
};
