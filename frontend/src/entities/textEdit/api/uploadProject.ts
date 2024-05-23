import axios from 'axios';

export const UploadProject = async (
  title: any,
  subtitle: any,
  content: any,
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
  mainImageUrl: any,
  projectMemberRequestList: any,
  nonRegisterProjectMemberRequestList: any,
  frameworkRequestList: any,
  accessToken: any,
) => {
  const response = await axios.post(
    '/api/v1/projects',
    {
      title,
      subtitle,
      content,
      startDate,
      endDate,
      platform,
      projectType,
      year,
      semester,
      projectStatus,
      githubLink,
      blogLink,
      websiteLink,
      mainImageUrl,
      projectMemberRequestList,
      nonRegisterProjectMemberRequestList,
      frameworkRequestList,
    },
    {
      headers: {
        authorization: accessToken,
      },
    },
  );
  return response.data.data;
};
