import { Framework } from './project.ts';

export interface Writer {
  id: number;
  loginId: string;
  nickname: string;
  profileImageUrl: string;
}

// Project 타입 정의
export interface Project {
  id: number;
  mainImageUrl: string;
  title: string;
  subtitle: string;
  startDate: string;
  endDate: string;
  platform: 'WEB' | 'APP' | 'WEB_APP';
  projectType: 'BOOTCAMP' | 'PERSONAL_PROJECT' | 'TEAM_PROJECT';
  year: number;
  semester: 'FIRST' | 'SECOND'; // 학기 정보
  projectStatus: 'RUNNING' | 'COMPLETED' | 'PREPARING';
  rankEnum: 'FIRST' | 'SECOND' | 'THIRD' | 'NONE';
  loveCount: number;
  writer: Writer;
  frameworkResponseList: Framework[];
  loved: boolean;
  scraped: boolean;
}

// ProjectList 타입 정의
export interface ProjectList {
  data: Project[];
}
