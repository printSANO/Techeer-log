export interface Reply {
  parentId: number;
  id: number;
  nickname: string;
  profileImageUrl: string;
  content: string;
  createdAt: string;
  likeCount: number;
  like: boolean;
}

export interface Comment {
  commentId: number;
  nickname: string;
  profileImageUrl: string;
  content: string;
  createdAt: string;
  likeCount: number;
  like: boolean;
  replies?: Reply[];
}

export interface CommentData {
  comments: Comment[];
  totalCount: number;
}
