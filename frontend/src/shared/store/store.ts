// store.js
import create from 'zustand';

interface Type {
  title: string;
  subtitle: string;
  content: string;
  startDate: string;
  endDate: string;
  platform: string;
  projectType: string;
  year: number;
  semester: string;
  projectStatus: string;
  githubLink: string;
  blogLink: string;
  websiteLink: string;
  mainImageUrl: string;
  projectMemberRequestList: [
    {
      memberId: number;
      projectMemberTypeEnum: string;
    },
  ];
  frontframeworkRequestList: [];
  backframeworkRequestList: [];
  frontprojectMemberList: [];
  backprojectMemberList: [];
  leader: string;
  changeplatform: (value: string) => void;
  changeprojectType: (value: string) => void;
  changeyear: (value: any) => void;
  changeprojectStatus: (value: any) => void;
  changegithubLink: (value: any) => void;
  changeblogLink: (value: any) => void;
  changewebsiteLink: (value: any) => void;
  changesemester: (value: any) => void;
  changefrontframeworkRequestList: (value: any) => void;
  changebackframeworkRequestList: (value: any) => void;
  changefrontprojectMemberList: (value: any) => void;
  changebackprojectMemberList: (value: any) => void;
  changeleader: (value: any) => void;
  changeTitle: (value: any) => void;
  changeSubtitle: (value: any) => void;
}

const useStore = create<Type>((set) => ({
  title: '제목',
  subtitle: '부제목',
  content: '',
  startDate: '',
  endDate: '',
  platform: '웹',
  projectType: '부트캠프',
  year: 2024,
  semester: '동계',
  projectStatus: '서비스 운영 중',
  githubLink: '',
  blogLink: '',
  websiteLink: '',
  mainImageUrl: '',
  projectMemberRequestList: [
    {
      memberId: 0,
      projectMemberTypeEnum: '',
    },
  ],
  nonRegisterProjectMemberRequestList: [
    {
      name: 'string',
      projectMemberTypeEnum: 'FRONTEND',
    },
  ],
  frontframeworkRequestList: [],
  backframeworkRequestList: [],
  frontprojectMemberList: [],
  backprojectMemberList: [],
  leader: '',
  changeplatform: (value: string) =>
    set({
      platform: value,
    }),
  changeprojectType: (value: string) =>
    set({
      projectType: value,
    }),
  changeyear: (value: any) =>
    set({
      year: value,
    }),

  changeprojectStatus: (value: any) =>
    set({
      projectStatus: value,
    }),
  changegithubLink: (value: any) =>
    set({
      githubLink: value,
    }),
  changeblogLink: (value: any) =>
    set({
      blogLink: value,
    }),
  changewebsiteLink: (value: any) =>
    set({
      websiteLink: value,
    }),
  changesemester: (value: any) =>
    set({
      semester: value,
    }),
  changefrontframeworkRequestList: (value: any) =>
    set({
      frontframeworkRequestList: value,
    }),
  changebackframeworkRequestList: (value: any) =>
    set({
      backframeworkRequestList: value,
    }),

  changefrontprojectMemberList: (value: any) =>
    set({
      frontprojectMemberList: value,
    }),
  changebackprojectMemberList: (value: any) =>
    set({
      backprojectMemberList: value,
    }),
  changeleader: (value: any) =>
    set({
      leader: value,
    }),
  changeTitle: (value: any) =>
    set({
      title: value,
    }),
  changeSubtitle: (value: any) =>
    set({
      subtitle: value,
    }),
}));

export default useStore;
