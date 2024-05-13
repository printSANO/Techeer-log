/* eslint-disable react-hooks/rules-of-hooks */
/* 하단 취소, 완료버튼 */

import { useEffect, useState } from 'react';
import useStore from '../../../shared/store/store';
import * as api from '../api/index';
import { useNavigate } from 'react-router-dom';

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
    frontframeworkRequestList,
    backframeworkRequestList,
    frontprojectMemberList,
    backprojectMemberList,
    frameworkResponseList,
    changenonRegisterProjectMemberRequestList,
    changeframeworkResponseList,
  } = useStore();
  const [projectMemberRequestList2, setProjectMemberRequestList2] = useState<any>([]);
  const [projectMemberRequestList3, setProjectMemberRequestList3] = useState<any>([]);
  useEffect(() => {
    setProjectMemberRequestList2([]);
    setProjectMemberRequestList3([]);
    frontprojectMemberList.map((item: any) => {
      projectMemberRequestList2.push({ name: item, projectMemberTypeEnum: 'FRONTEND' });
    });
    backprojectMemberList.map((item: any) => {
      projectMemberRequestList3.push({ name: item, projectMemberTypeEnum: 'BACKEND' });
    });
    changenonRegisterProjectMemberRequestList([...projectMemberRequestList2, ...projectMemberRequestList3]);
    setProjectMemberRequestList2([]);
    setProjectMemberRequestList3([]);
    frontframeworkRequestList.map((item: any) => {
      projectMemberRequestList2.push({ name: item, frameworkTypeEnum: 'FRONTEND' });
    });
    backframeworkRequestList.map((item: any) => {
      projectMemberRequestList3.push({ name: item, frameworkTypeEnum: 'BACKEND' });
    });
    changeframeworkResponseList([...projectMemberRequestList2, ...projectMemberRequestList3]);
  }, []);
  const handleGoBack = () => {
    setStep('prev');
  };
  const onSubmit = async () => {
    api.UploadProject(
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
      navigate,
    );
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
