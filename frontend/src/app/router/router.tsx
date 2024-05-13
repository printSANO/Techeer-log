import { createBrowserRouter } from 'react-router-dom';
import MainPage from '../../pages/MainPage.tsx';
import { MyPage } from '../../entities/myPage';
import { SignUp } from '../../entities/signup/index.ts';
import { LogIn } from '../../entities/login/index.ts';
import { ProjectInfo } from '../../entities/projectInputModal';
import { ProjectPage, ProjectWritePage } from '../../pages';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <MainPage />,
  },
  {
    path: '/mypage',
    element: <MyPage />,
  },
  {
    path: '/signup',
    element: <SignUp />,
  },
  {
    path: '/login',
    element: <LogIn />,
  },
  {
    path: '/projectview',
    element: <ProjectPage />,
  },
  {
    path: '/modal',
    element: <ProjectInfo />,
  },
  {
    path: '/projectwrite',
    element: <ProjectWritePage />,
  },
]);
