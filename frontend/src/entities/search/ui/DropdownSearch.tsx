import { useEffect, useState } from 'react';
import iconSearch from '../../../shared/assets/image/searchImg/Icon-Search.png';

interface DropdownProps {
  searchresult: string;
  setSearchresult: React.Dispatch<React.SetStateAction<string>>;
  onSubmitSearch: any;
}

export function DropdownSearch({ setSearchresult, onSubmitSearch }: DropdownProps) {
  const [recentSearches, setRecentSearches] = useState<string[]>([]);
  const setsearchtoRecent = (recentsearch: string) => {
    setSearchresult(recentsearch);
    onSubmitSearch({ key: 'Click' });
  };
  useEffect(() => {
    const searches = localStorage.getItem('recentSearches');

    if (searches) {
      setRecentSearches(JSON.parse(searches));
    }
  }, []);
  return (
    <div className="absolute mt-[29rem] rounded-[1rem] w-[28.125rem] flex border border-1 border-solid border-white border-opacity-90 bg-[#111111] bg-opacity-60 backdrop-blur-[24px]">
      <div className="flex flex-col w-[90%] p-[0.625rem] text-left bg-transparent">
        <p className="mb-[0.5rem] text-[#6a737b] text-[0.85rem] font-normal leading-7">최근 검색어</p>
        {recentSearches.map((recent) => (
          <button onClick={() => setsearchtoRecent(recent)} className="flex flex-row mb-[0.4rem] h-[1.3rem]">
            <img src={iconSearch} className="w-[0.938rem] h-[0.938rem] m-[0.1rem_0.625rem_0_0]" />
            <p className="text-left">{recent}</p>
          </button>
        ))}
      </div>
    </div>
  );
}
