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
  startDate: string; // YYYY-MM-DD 형식의 날짜 문자열
  endDate: string; // YYYY-MM-DD 형식의 날짜 문자열
  platform: 'WEB' | 'MOBILE' | 'DESKTOP' | 'OTHER'; // 가능한 플랫폼 값
  projectType: 'BOOTCAMP' | 'PERSONAL' | 'TEAM'; // 프로젝트 유형
  year: number;
  semester: 'FIRST' | 'SECOND'; // 학기 정보
  projectStatus: 'RUNNING' | 'COMPLETED' | 'PLANNING'; // 프로젝트 상태
  loveCount: number;
  writer: Writer;
  loved: boolean;
  scraped: boolean;
}

// ProjectList 타입 정의
export interface ProjectList {
  data: Project[];
}
