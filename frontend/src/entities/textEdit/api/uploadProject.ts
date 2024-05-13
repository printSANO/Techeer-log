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
  navigate: any,
) => {
  try {
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
          authorization:
            'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwidHlwZSI6IlVTRVIiLCJuaWNrbmFtZSI6InN0cmluZyIsImlhdCI6MTcxNTYxMjA1NSwiZXhwIjoxNzE1NjE1NjU1fQ.recmy5KdGsRotk6__rtJ2nuVSZjhfcLiYfbcWon5w_RDzSlO77JY5-dSrC7BT5loZB7g6hMLnN-GgB-acVGJ6w',
        },
      },
    );
    console.log(response.data);
    navigate('/');
  } catch (error) {
    alert('제목, 내용을 입력해주세요!');
  }
};
