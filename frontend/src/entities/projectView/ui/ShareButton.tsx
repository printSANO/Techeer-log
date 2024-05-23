import ShareIcon from '/src/shared/assets/image/projectViewImg/Icon-Share.png';
import { useState } from 'react';
export const ShareButton = () => {
  const [isClick, setIsClick] = useState<boolean>(false);
  const clickShare = () => {
    //링크 생성
  };
  return (
    <div
      onClick={() => {
        setIsClick(!isClick);
        clickShare();
      }}
      className="cursor-pointer bg-contain m-[0_0.6rem_0_0.7rem] w-[1.8rem] h-[1.8rem]"
    >
      <img src={ShareIcon} />
    </div>
  );
};
