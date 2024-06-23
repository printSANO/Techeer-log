import { SetStateAction } from 'react';
import { Fragment } from 'react';
import { Menu, Transition } from '@headlessui/react';
import iconDropdown from '../image/Icon-Dropdown.png';

type DropDownProps = {
  selectedType: string;
  setSelectedType: React.Dispatch<SetStateAction<string>>;
  selectedYear: string;
  setSelectedYear: React.Dispatch<SetStateAction<string>>;
  selectedPeriod: string;
  setSelectedPeriod: React.Dispatch<SetStateAction<string>>;
};
type DropdownMenuProps = {
  options: string[];
  selectedOption: string;
  setSelectedOption: React.Dispatch<SetStateAction<string>>;
};

export function DropDown({
  selectedType,
  setSelectedType,
  selectedYear,
  setSelectedYear,
  selectedPeriod,
  setSelectedPeriod,
}: DropDownProps) {
  const firstDropdown = ['전체', '부트캠프', '팀 프로젝트', '개인 프로젝트'];
  const secondDropdown = ['전체', '2022', '2023', '2024'];
  const bootCampDropdown = ['전체', '동계', '하계'];

  // 첫 번째 드롭다운의 상태값이 바뀌면 두 번째 드롭다운의 상태값이 초기값으로 바뀜
  const handleFirstDropdownChange = (option: SetStateAction<string>) => {
    setSelectedType(option);
    setSelectedPeriod('전체');
  };

  return (
    <div className="space-x-4 mb-8 flex justify-center">
      <DropdownMenu
        options={firstDropdown}
        selectedOption={selectedType}
        setSelectedOption={handleFirstDropdownChange}
      />
      <DropdownMenu options={secondDropdown} selectedOption={selectedYear} setSelectedOption={setSelectedYear} />
      {selectedType === '부트캠프' ? (
        <DropdownMenu
          options={bootCampDropdown}
          selectedOption={selectedPeriod}
          setSelectedOption={setSelectedPeriod}
        />
      ) : (
        <></>
      )}
    </div>
  );
}

function DropdownMenu({ options, selectedOption, setSelectedOption }: DropdownMenuProps) {
  return (
    <Menu as="div" className="relative inline-block text-left font-['Pretendard-Thin']">
      <div>
        <Menu.Button className="w-[10rem] inline-flex justify-between rounded-md bg-[#111111] px-4 py-2 text-sm text-[#888888] shadow-sm ring-1 ring-inset ring-[#444444] hover:bg-[#242628] hover:text-[#cccccc]">
          {selectedOption}
          <img src={iconDropdown} className="w-[0.625rem] h-[0.375rem] self-center ml-auto" alt="Dropdown Icon" />
        </Menu.Button>
      </div>
      <Transition
        as={Fragment}
        enter="transition ease-out duration-100"
        enterFrom="transform opacity-0 scale-95"
        enterTo="transform opacity-100 scale-100"
        leave="transition ease-in duration-75"
        leaveFrom="transform opacity-100 scale-100"
        leaveTo="transform opacity-0 scale-95"
      >
        <Menu.Items className="w-[10rem] absolute right-0 z-10 mt-2 origin-top-right rounded-md bg-[#111111] shadow-lg ring-1 ring-[#444444] focus:outline-none">
          <div className="py-1">
            {options.map((option) => (
              <Menu.Item key={option}>
                {({ active }) => (
                  <button
                    onClick={() => setSelectedOption(option)}
                    className={`${
                      active ? 'bg-[#242628] text-[#cccccc]' : 'text-[#888888]'
                    } block w-full px-4 py-2 text-left text-sm`}
                  >
                    {option}
                  </button>
                )}
              </Menu.Item>
            ))}
          </div>
        </Menu.Items>
      </Transition>
    </Menu>
  );
}
