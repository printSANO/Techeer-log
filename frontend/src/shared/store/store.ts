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
  projectMemberRequestList: [];
  frontframeworkRequestList: [];
  backframeworkRequestList: [];
  frontprojectMemberList: [];
  backprojectMemberList: [];
  nonRegisterProjectMemberRequestList: [
    {
      name: string;
      projectMemberTypeEnum: string;
    },
  ];
  leader: string;
  frameworkResponseList: [
    {
      name: string;
      frameworkTypeEnum: string;
    },
  ];
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
  changestartDate: (value: any) => void;
  changeendDate: (value: any) => void;
  changenonRegisterProjectMemberRequestList: (value: any) => void;
  changeframeworkResponseList: (value: any) => void;
  changecontent: (value: any) => void;
}

const useStore = create<Type>((set) => ({
  title: '제목',
  subtitle: '부제목',
  content: '',
  startDate: '0000. 00. 00',
  endDate: '0000. 00. 00',
  platform: '웹',
  projectType: '부트캠프',
  year: 2024,
  semester: '동계',
  projectStatus: '서비스 운영 중',
  githubLink: '',
  blogLink: '',
  websiteLink: '',
  mainImageUrl: '',
  projectMemberRequestList: [],
  nonRegisterProjectMemberRequestList: [
    {
      name: 'string',
      projectMemberTypeEnum: 'FRONTEND',
    },
  ],
  frameworkResponseList: [
    {
      name: 'string',
      frameworkTypeEnum: 'FRONTEND',
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
  changestartDate: (value: any) =>
    set({
      startDate: value,
    }),
  changeendDate: (value: any) =>
    set({
      endDate: value,
    }),
  changenonRegisterProjectMemberRequestList: (value: any) =>
    set({
      nonRegisterProjectMemberRequestList: value,
    }),
  changeframeworkResponseList: (value: any) =>
    set({
      nonRegisterProjectMemberRequestList: value,
    }),
  changecontent: (value: any) =>
    set({
      content: value,
    }),
}));

export default useStore;
