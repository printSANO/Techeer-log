// store.js
import create from 'zustand';

const useStore = create((set) => ({
  nowProject: () =>
    set({
      title: '',
      subtitle: '',
      content: '',
      startDate: '',
      endDate: '',
      platform: '',
      projectType: '',
      year: 0,
      semester: '',
      projectStatus: '',
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
    }),
}));

export default useStore;
