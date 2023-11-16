import { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const DropdownWrapper = styled.div`
    position: absolute;
    top: 100%;
    margin-top: 5%;
    right: 0;
`;

const DropdownBox = styled.div<{isOpen: boolean}>`
    position: relative;
    z-index: 3;
    width: 11rem;
    display: ${({ isOpen }) => (isOpen ? "flex" : "none")};
    flex-direction: column;
    /* background: blue; */
    background-color: #1e1e1e;
    color: white;
`;

const DropdownList = styled.ul`
    color: #ececec;
    padding: 0.75rem 1rem;
    line-height: 2;
    font-weight: 400;
    font-size: 100%;
    cursor: pointer;
    &:hover {
    color:#63e6be;
    }
`;

function Dropdown() {
    
  const navigate =useNavigate();
  const [isOpen, setIsOpen] = useState(true);
  console.log(isOpen);

  const handleDropdownClick = (path:string) => {
    navigate(path);
    setIsOpen(
        (prev)=>!prev
        );
  };

  const dropdownItems = [
    { label: "마이페이지", path: "/mypage" },
    { label: "새 글 작성", path: "/posting" },
    { label: "로그아웃", path: "/" },
  ];

  return (
    <DropdownWrapper>
      <DropdownBox isOpen={isOpen} >
        {dropdownItems.map((item, index) => (
          <DropdownList key={index} onClick={() => handleDropdownClick(item.path)}>
            {item.label}
          </DropdownList>
        ))}
      </DropdownBox>
    </DropdownWrapper>
  );
}

export default Dropdown;