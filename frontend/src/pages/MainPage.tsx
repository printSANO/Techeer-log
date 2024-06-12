import NavBar from '../shared/ui/NavBar.tsx';
import { DropDown } from '../entities/filter';
import { Search } from '../entities/search';
import { EmblaCarousel } from '../entities/carousel';
import { EmblaOptionsType } from 'embla-carousel';
import { useState } from 'react';
import { ProjectList } from '../entities/projectList';
import Footer from '../shared/ui/Footer.tsx';
import { useLocation } from 'react-router-dom';
import ProjectCard from '../shared/ui/ProjectCard.tsx';

export default function MainPage() {
  const OPTIONS: EmblaOptionsType = { loop: true };
  const SLIDE_COUNT = 5;
  const SLIDES = Array.from(Array(SLIDE_COUNT).keys());
  const [result, setResult] = useState<any>([]);
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const searchQuery = queryParams.get('search') || '';
  const [selectedType, setSelectedType] = useState<string>('프로젝트 종류');
  const [selectedPeriod, setSelectedPeriod] = useState<string>('프로젝트 기간');
  
  return (
    <div className="bg-[#111111] flex flex-col w-screen justify-center items-center">
      <NavBar />
      {/* 메인페이지-소개 */}
      <div className="w-[100vw] h-[41.6vw] bg-cover bg-[url('./shared/assets/image/mainImg/Background-Main.png')] flex justify-center items-center">
        <div className="w-[100vw] flex flex-col justify-center items-center font-['Pretendard-Regular'] font-normal text-[#FFFFFF]">
          <span className="font-['Pretendard-Black'] text-[6.25rem] m-[0_0_1.5rem_0]">Techeer</span>
          <span className="font-['Pretendard-Thin'] text-[1.875rem]">
            테커에서 진행하는 <a className="font-['Pretendard-Medium']">다양한 프로젝트를 한눈에</a>
          </span>
          <Search setResult={setResult} />
        </div>
      </div>
      {searchQuery ? (
        <div className="w-[75rem] mt-[6.063rem] flex flex-col justify-center">
          <div className="grid grid-rows-3 grid-cols-3 gap-4 m-4">
            {result && result.length > 0 ? (
              result.map((results: any) => <ProjectCard key={results.id} project={results} />)
            ) : (
              <div>No projects found.</div>
            )}
          </div>
        </div>
      ) : (
        <div className="w-[75rem] mt-[6.063rem] flex flex-col justify-center">
          {/* 우수선정작 */}
          <div className="flex flex-col justify-center items-center mb-12">
            <img
              src="./src/shared/assets/image/mainImg/Icon-Point.png"
              className="w-[1.875rem] h-[0.75rem] mb-[1rem]"
            />
            <span className="font-['Pretendard-Thin'] text-[1.875rem] text-white">
              2023 동계 부트캠프 <a className="font-['Pretendard-Bold']">우수 선정작</a>
            </span>
          </div>
          {/* Carousel */}
          {/* 캐러셀 참고 : https://codesandbox.io/p/sandbox/embla-carousel-loop-react-yvfd5v?file=%2Fsrc%2Fjs%2Findex.tsx */}
          <EmblaCarousel slides={SLIDES} options={OPTIONS} />
          {/* 테커 모든 프로젝트 */}
          <div className="flex flex-col justify-center items-center mb-12">
            <img
              src="./src/shared/assets/image/mainImg/Icon-Point.png"
              className="w-[1.875rem] h-[0.75rem] mb-[1rem]"
            />
            <span className="font-['Pretendard-Thin'] text-[1.875rem] text-white">
              테커 모든 <a className="font-['Pretendard-Bold']">프로젝트</a>
            </span>
          </div>
          {/* Filter */}
          <DropDown
            selectedType={selectedType}
            setSelectedType={setSelectedType}
            selectedPeriod={selectedPeriod}
            setSelectedPeriod={setSelectedPeriod}
          />
          {/* Filtered Projects */}
          <ProjectList selectedType={selectedType} selectedPeriod={selectedPeriod} />
        </div>
      )}
      {/* 메인페이지-프로젝트 */}

      <Footer />
    </div>
  );
}
