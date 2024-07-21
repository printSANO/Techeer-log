import axiosInstance from '../../../shared/api/axiosInstance.ts';

interface ProjectData {
  title: any;
  subtitle: any;
  onlyText: any;
  startDate: any;
  endDate: any;
  enumPlatform: any;
  enumProjectType: any;
  year: any;
  enumSemester: any;
  enumProjectStatus: any;
  githubLink: any;
  blogLink: any;
  websiteLink: any;
  imageUrl: any;
  projectMemberRequestList: any;
  nonRegisterProjectMemberRequestList: any;
  frameworkResponseList: any;
}

export const UploadProject = async (projectData: ProjectData) => {
  const response = await axiosInstance.post('/api/v1/projects', {
    title: projectData.title,
    subtitle: projectData.subtitle,
    content: projectData.onlyText,
    startDate: projectData.startDate,
    endDate: projectData.endDate,
    platform: projectData.enumPlatform,
    projectTypeEnum: projectData.enumProjectType,
    year: projectData.year,
    semesterEnum: projectData.enumSemester,
    projectStatusEnum: projectData.enumProjectStatus,
    githubLink: projectData.githubLink,
    blogLink: projectData.blogLink,
    websiteLink: projectData.websiteLink,
    mainImageUrl: projectData.imageUrl,
    projectMemberRequestList: projectData.projectMemberRequestList,
    nonRegisterProjectMemberRequestList: projectData.nonRegisterProjectMemberRequestList,
    frameworkRequestList: projectData.frameworkResponseList,
  });
  return response.data.data;
};
