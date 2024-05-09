export interface Comment {
  commentId: number;
  nickname: string;
  profileImageUrl: string;
  content: string;
  createdAt: string;
  authorized: boolean;
}

export interface CommentData {
  comments: Comment[];
  totalCount: number;
}
