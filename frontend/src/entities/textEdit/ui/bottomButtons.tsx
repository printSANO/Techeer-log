/* eslint-disable react-hooks/rules-of-hooks */
/* 하단 취소, 완료버튼 */
import useStore from '../../../shared/store/store';
import * as api from '../api/index';
import { useNavigate } from 'react-router-dom';
import * as projectWrite from '../../../shared/constants/index';
import { useMutation } from '@tanstack/react-query';

export const bottomButtons = ({ setStep }: any) => {
  const navigate = useNavigate();
  const {
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
    frameworkResponseList,
  } = useStore();
  const handleGoBack = () => {
    setStep('prev');
  };
  const engChange = (platformName: any) => {
    const platform = projectWrite.projectWrite.find((item) => item.name === platformName);
    return platform ? platform.enum : '';
  };
  const enumPlatform = engChange(platform);
  const enumProjectType = engChange(projectType);
  const enumSemester = engChange(semester);
  const enumProjectStatus = engChange(projectStatus);
  const handleSubmit = useMutation({
    mutationFn: () =>
      api.UploadProject(
        title,
        subtitle,
        content,
        startDate,
        endDate,
        enumPlatform,
        enumProjectType,
        year,
        enumSemester,
        enumProjectStatus,
        githubLink,
        blogLink,
        websiteLink,
        mainImageUrl,
        projectMemberRequestList,
        nonRegisterProjectMemberRequestList,
        frameworkResponseList,
      ),
    onSuccess: () => {
      navigate('/');
    },
    onError: (error) => {
      alert('프로젝트 등록에 실패하였습니다.' + error);
    },
  });
  const { mutate } = handleSubmit;
  const onSubmit = async () => {
    mutate();
  };
  return (
    <div className="fixed bottom-0 flex flex-row w-full h-[7%] bg-[#212121] items-center justify-between p-[2rem_2rem]">
      <div
        onClick={handleGoBack}
        className="rounded-[0.3rem] bg-transparent border-solid border-[0.1rem] border-[#333333] flex flex-row justify-center items-center w-[6.7rem] h-[2.7rem] box-sizing-border cursor-pointer"
      >
        <span className="break-words font-medium text-[1.2rem] text-white mt-[0.2rem]">취소</span>
      </div>
      <div
        onClick={onSubmit}
        className="rounded-[0.3rem] bg-[#333333] flex flex-row justify-center items-center w-[6.7rem] h-[2.7rem] box-sizing-border cursor-pointer"
      >
        <span className="break-words font-medium text-[1.2rem] leading-[1.2] text-white mt-[0.2rem]">완료</span>
      </div>
    </div>
  );
};
