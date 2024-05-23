import GithubIcon from '../../../shared/assets/image/projectViewImg/Icon-Github.png';
import MediumIcon from '../../../shared/assets/image/projectViewImg/Icon-Medium.png';
import LinkIcon from '../../../shared/assets/image/projectViewImg/Icon-Link.png';
import {
  Framework,
  ProjectData,
  ProjectMember,
} from '../../../shared/types/project.ts';
import { LikeButton } from './LikeButton.tsx';
import { ScrapButton } from './ScrapButton.tsx';
import { ShareButton } from './ShareButton.tsx';
export const ProjectView = (props: { data: ProjectData }) => {
  const project: ProjectData = props.data;
  const projectMember: ProjectMember[] = props.data.nonRegisterProjectMemberResponseList;
  // if(projectMember[0].projectMemberTypeEnum === 'BACKEND'){
  //   console.log('hi',projectMember[0].name)
  // }
  const techStack: Framework[] = props.data.frameworkResponseList;

  return (
    <div key={project.id} className="bg-[#0F1012] w-[100vw] box-sizing-border">
      <div className="w-[1150px] pt-[5.5rem] relative ml-auto mr-auto">
        <div className="m-[1rem_0_1.4rem_0] flex flex-col items-centerx break-words font-['Pretendard'] font-semibold text-[2rem] text-[#FFFFFF]">
          {project.title}
        </div>
        <div className="m-[0_0_1.3rem_0] inline-block break-words font-['Pretendard'] font-normal text-[1.1em] text-[#C7C7C7]">
          {project.subtitle}
        </div>
        <div className="bg-[#989898] absolute w-[100%] h-[0.1rem]"></div>
        {/*좋아요, 저장, 공유*/}
        <div className="flex flex-row items-center justify-between w-[100%] mt-[1.5rem] mb-[2rem] box-sizing-border">
          <div className="flex flex-row justify-between box-sizing-border mt-[0.5rem]">
            <LikeButton projectId={project.id} loveCount={project.loveCount} isLoved={project.loved} />
          </div>
          <div className="flex flex-row justify-between box-sizing-border mt-[0.5rem]">
            <ScrapButton projectId={project.id} />
            <ShareButton />
          </div>
        </div>
        {/*글*/}
        <div className="flex flex-row w-[100%] justify-between box-sizing-border">
          {/*소개*/}
          <div className="rounded-[0.9rem] w-[49rem] border border-solid border-[#CCCCCC] h-[100%] relative flex flex-col p-[1.4rem_1.4rem_3rem_1.4rem] box-sizing-border">
            <div
              className="rounded-[0.6rem] w-[100%] h-[23.2rem]"
            >
              <img src={project.mainImageUrl}/>
            </div>
            <p className="m-[2rem_1.1rem_0_1.1rem] whitespace-pre-wrap leading-5 self-start break-words font-['Pretendard'] font-normal text-[1rem] text-[#FFFFFF]">
              {project.content}
            </p>
          </div>
          {/*요약 박스*/}
          <div className="relative m-[0.2rem_0_0_0] flex flex-col w-[21rem] box-sizing-border">
            {/*프로젝트 소개*/}
            <div className="relative m-[0_0_1.5rem_0] flex flex-row items-center w-[100%] box-sizing-border">
              <div className="rounded-[0.9rem] bg-[#242424] relative flex flex-col p-[2.3rem_1.5rem_1.3rem_2.3rem] w-[100%] box-sizing-border">
                <div className="m-[0_0_2.1rem_0] inline-block self-start break-words font-['Pretendard'] font-semibold text-[1.1rem] text-[#FFFFFF]">
                  프로젝트 정보
                </div>
                <div className="flex flex-row">
                  <div className="flex flex-col justify-between self-start w-[8rem] box-sizing-border">
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                      프로젝트 기간
                    </span>
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                      진행 기수
                    </span>
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                      프로젝트 형태
                    </span>
                    <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-12 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                      서비스 상태
                    </span>
                    <div className="m-[0.1rem_0.6rem_0.2rem_0] h-12 inline-block w-[10.9rem] break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                      프로젝트 링크
                    </div>
                  </div>
                  <div className="flex flex-col justify-between self-start w-[17.8rem] mt-[0.1rem] box-sizing-border ">
                    <span className="break-words font-['Pretendard'] h-12 font-normal text-[0.9rem] text-[#FFFFFF]">
                      {project.startDate} ~ {project.endDate}
                    </span>
                    <span className="break-words font-['Pretendard'] h-12 font-normal text-[0.9rem] text-[#FFFFFF]">
                      {project.projectType}
                    </span>
                    <span className="break-words font-['Pretendard'] h-12 font-normal text-[0.9rem] text-[#FFFFFF]">
                      {project.platform}
                    </span>
                    <span className="break-words font-['Pretendard'] h-12 font-normal text-[0.9rem] text-[#FFFFFF]">
                      {project.projectStatus}
                    </span>
                    <div className="flex flex-row box-sizing-border">
                      {project.githubLink && (
                        <div className="flex">
                          <a href={project.githubLink}>
                            <img src={GithubIcon} className="cursor-pointer mr-[1rem] w-[1.7rem] h-[1.65rem]" />
                          </a>
                        </div>
                      )}
                      {project.blogLink && (
                        <div className="flex">
                          <a href={project.blogLink}>
                            <img src={MediumIcon} className="cursor-pointer mr-[1rem] w-[1.8rem] h-[1.8rem]" />
                          </a>
                        </div>
                      )}
                      {project.websiteLink && (
                        <div className="flex">
                          <a href={project.websiteLink}>
                            <img src={LinkIcon} className="cursor-pointer mr-[1rem] w-[1.8rem] h-[1.8rem]" />
                          </a>
                        </div>
                      )}
                    </div>
                  </div>
                </div>
              </div>
            </div>
            {/*기술스택*/}
            <div className="rounded-[0.9rem] bg-[#242424] mb-[1.5rem] flex flex-col p-[2.3rem_1.3rem_1.3rem_2.3rem] w-[21rem] box-sizing-border">
              <div className="m-[0_0.2rem_0.5rem_0.2rem] inline-block self-start break-words font-['Pretendard'] font-semibold text-[1.1rem] text-[#FFFFFF]">
                기술 스택
              </div>
              <span className="w-[8.7rem] m-[1rem_0_1rem_0.2rem] break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                Backend
              </span>
              <div className="rounded-[0.9rem] flex flex-wrap flex-row self-start w-[fit-content] box-sizing-border">
                {techStack &&
                  techStack.map((tech) => {
                    if (tech.frameworkTypeEnum === "BACKEND") {
                      return (
                        <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                          <span className="break-words font-['Pretendard'] font-semibold text-[0.8rem] text-[#CCCCCC]">
                            {tech.name}
                          </span>
                        </div>
                      );
                    }
                  })}
              </div>
              <span className="w-[8.7rem] m-[0.4rem_0_1rem_0.2rem] break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                Frontend
              </span>
              <div className="rounded-[0.9rem] flex flex-wrap flex-row self-start w-[fit-content] box-sizing-border">
                {techStack &&
                  techStack.map((tech) => {
                    if (tech.frameworkTypeEnum === "FRONTEND") {
                      return (
                        <div className="rounded-[0.9rem] bg-[#464646] relative m-[0_0.8rem_1rem_0] flex flex-row justify-center p-[0.4rem_1rem_0.4rem_1rem] box-sizing-border">
                          <span className="break-words font-['Pretendard'] font-semibold text-[0.8rem] text-[#CCCCCC]">
                            {tech.name}
                          </span>
                        </div>
                      );
                    }
                  })}
              </div>
            </div>
            {/*팀원*/}
            <div className="rounded-[0.9rem] bg-[#242424] relative flex flex-col p-[2.3rem_1.3rem_1.3rem_2.3rem] w-[21rem] box-sizing-border">
              <div className="m-[0_0_2.1rem_0] inline-block self-start break-words font-['Pretendard'] font-medium text-[1.1rem] text-[#FFFFFF]">
                프로젝트 팀원
              </div>
              <div className="flex flex-row">
                <div className="flex flex-col justify-between self-start w-[17.9rem] box-sizing-border">
                  <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-16 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                    Team Leader
                  </span>
                  <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-16 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                    Backend
                  </span>
                  <span className="m-[0_0.6rem_0_0] w-[8.7rem] h-16 break-words font-['Pretendard'] font-medium text-[1rem] text-[#CCCCCC]">
                    Frontend
                  </span>
                </div>
                <div className="flex flex-col justify-between self-start w-[17.8rem] box-sizing-border">
                  {projectMember &&
                    projectMember.map((member) => {
                      if (member.projectMemberTypeEnum === "LEADER") {
                        return (
                          <span className="break-words font-['Pretendard'] h-16 font-normal text-[1rem] text-[#FFFFFF]">
                            {member.name}
                          </span>
                        );
                      }
                      if (member.projectMemberTypeEnum === "BACKEND") {
                        return (
                          <span className="break-words font-['Pretendard'] h-16 font-normal text-[1rem] text-[#FFFFFF]">
                            {member.name}
                          </span>
                        );
                      }
                      if (member.projectMemberTypeEnum === "FRONTEND") {
                        return (
                          <span className="break-words font-['Pretendard'] h-16 font-normal text-[1rem] text-[#FFFFFF]">
                            {member.name}
                          </span>
                        );
                      }
                    })}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
