// store.js
import create from 'zustand';

const useStore = create((set) => ({
  title: '',
  subtitle: '',
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
  frameworkRequestList: [
    {
      name: '',
      frameworkTypeEnum: '',
    },
  ],
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
}));

export default useStore;
