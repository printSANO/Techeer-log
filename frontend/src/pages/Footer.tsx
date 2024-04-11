const Footer = () => {
  return (
    <div className="bg-[url('./src/shared/assests/pointBanner.png')] flex flex-row justify-center items-center w-screen h-[9.375rem]">
      <div className="flex flex-row justify-between items-center w-[1200px]">
        <span className="break-words font-['Bayon'] font-normal text-[2rem] leading-[1.5] text-[#FFFFFF]">
          Techeer.log
        </span>
        <span className="break-words font-['Pretendard'] font-normal text-[0.875rem] text-[#FFFFFF]">
          © 2024 Techeer.log • All Rights Reserved
        </span>
        <span className="break-words font-['Pretendard'] font-normal text-[1rem] text-[#FFFFFF]">
          contact: techeer@gmail.com
        </span>
      </div>
    </div>
  );
};

export default Footer;
