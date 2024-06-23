import axiosInstance from '../../../shared/api/axiosInstance.ts';

export const UploadProject = async (
  title: any,
  subtitle: any,
  onlyText: any,
  startDate: any,
  endDate: any,
  platform: any,
  projectType: any,
  year: any,
  semester: any,
  projectStatus: any,
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
    platform,
    projectTypeEnum: projectType,
    year,
    semesterEnum: semester,
    projectStatusEnum: projectStatus,
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
