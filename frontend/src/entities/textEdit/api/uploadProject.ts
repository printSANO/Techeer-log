import axiosInstance from '../../../shared/api/axiosInstance.ts';

export const UploadProject = async (
  title: any,
  subtitle: any,
  onlyText: any,
  startDate: any,
  endDate: any,
  enumPlatform: any,
  enumProjectType: any,
  year: any,
  enumSemester: any,
  enumProjectStatus: any,
  githubLink: any,
  blogLink: any,
  websiteLink: any,
  imageUrl: any,
  projectMemberRequestList: any,
  nonRegisterProjectMemberRequestList: any,
  frameworkRequestList: any,
) => {
  const response = await axiosInstance.post('/api/v1/projects', {
    title,
    subtitle,
    content: onlyText,
    startDate,
    endDate,
    platform: enumPlatform,
    projectTypeEnum: enumProjectType,
    year,
    semesterEnum: enumSemester,
    projectStatusEnum: enumProjectStatus,
    githubLink,
    blogLink,
    websiteLink,
    mainImageUrl: imageUrl,
    projectMemberRequestList,
    nonRegisterProjectMemberRequestList,
    frameworkRequestList,
  });
  return response.data.data;
};
