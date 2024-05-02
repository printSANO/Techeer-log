export interface Writer {
  id: number;
  loginId: string;
  nickname: string;
  profileImageUrl: string;
}

export interface MemberResponse {
  id: number;
  loginId: string;
  nickname: string;
  profileImageUrl: string;
}

export enum ProjectMemberType {
  FRONTEND,
  BACKEND,
  DESIGNER,
}
export interface ProjectMember {
  memberResponse: MemberResponse;
  projectMemberTypeEnum: string;
}

export enum FrameworkType {
  FRONTEND,
  BACKEND,
}
export interface Framework {
  name: string;
  frameworkTypeEnum: string;
}

export interface ProjectData {
  id: number;
  mainImageUrl: string;
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
  viewCount: number;
  loveCount: number;
  writer: Writer;
  projectMemberResponseList: ProjectMember[];
  frameworkResponseList: Framework[];
}
