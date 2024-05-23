import { useState } from 'react';
import { FaRegBookmark, FaBookmark } from 'react-icons/fa6';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import { postScrap, deleteScrap } from '../api/scrap.ts';

export const ScrapButton = ({ projectId }: { projectId: number }) => {
  const [isScrapped, setIsScrapped] = useState<boolean>(false);
  const queryClient = useQueryClient();

  const postMutation = useMutation({
    mutationFn: (projectId: number) => postScrap(projectId),
    onSuccess: () => {
      console.log('post완료');
      queryClient.invalidateQueries({ queryKey: ['projectData'] });
      //optimitic update적용 예정
    },
  });

  const deleteMutation = useMutation({
    mutationFn: (projectId: number) => deleteScrap(projectId),
    onSuccess: () => {
      console.log('delete완료');
      queryClient.invalidateQueries({ queryKey: ['projectData'] });
    },
  });
  const handleScrapCheck = (isScrapped: boolean) => {
    isScrapped ? postMutation.mutate(projectId) : deleteMutation.mutate(projectId);
  };
  return (
    <div
      onClick={() => {
        setIsScrapped(!isScrapped);
        handleScrapCheck(!isScrapped);
      }}
      style={{ color: '#CCCCCC', fontSize: '1.5rem' }}
      className="cursor-pointer m-[0.1rem_0.2rem_0_0]"
    >
      {isScrapped ? <FaBookmark /> : <FaRegBookmark />}
    </div>
  );
};
