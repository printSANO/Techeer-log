import axiosInstance from '../../../shared/api/axiosInstance.ts';

interface ProjectData2 {
  title: any;
  subtitle: any;
  onlyText: any;
  startDate: any;
  endDate: any;
  platform: any;
  projectType: any;
  year: any;
  semester: any;
  projectStatus: any;
  githubLink: any;
  blogLink: any;
  websiteLink: any;
  imageUrl: any;
  projectMemberRequestList: any;
  nonRegisterProjectMemberRequestList: any;
  frameworkResponseList: any;
}

interface UploadProjectParams {
  projectData2: ProjectData2;
  projectId: number;
}

export const putProject = async ({ projectData2, projectId }: UploadProjectParams) => {
  const response = await axiosInstance.put(`/api/v1/projects/${projectId}`, {
    title: projectData2.title,
    subtitle: projectData2.subtitle,
    content: projectData2.onlyText,
    startDate: projectData2.startDate,
    endDate: projectData2.endDate,
    platform: projectData2.platform,
    projectTypeEnum: projectData2.projectType,
    year: projectData2.year,
    semesterEnum: projectData2.semester,
    projectStatusEnum: projectData2.projectStatus,
    githubLink: projectData2.githubLink,
    blogLink: projectData2.blogLink,
    websiteLink: projectData2.websiteLink,
    mainImageUrl: projectData2.imageUrl,
    projectMemberRequestList: projectData2.projectMemberRequestList,
    nonRegisterProjectMemberRequestList: projectData2.nonRegisterProjectMemberRequestList,
    frameworkRequestList: projectData2.frameworkResponseList,
  });
  return response.data.data;
};
