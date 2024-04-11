const LogIn = () => {

    return (
        // 전체 배경
        <div className="bg-[#111111] bg-opacity-90 flex w-screen h-screen justify-center items-center">
            {/* 모달 이미지 배경 */}
            <div className="rounded-[1.25rem] bg-cover bg-[url('./src/shared/assests/Background-Login.png')] bg-no-repeat flex flex-row w-[60rem] h-[37.5rem]">
                {/* 왼쪽 박스 텍스트 그룹 */}
                <div className="flex flex-col justify-center ml-8 box-sizing-border w-[55%] gap-2">
                    <p className="break-words font-['Bayon'] font-normal text-[3rem] text-[#FFFFFF]">Techeer.log</p>
                    <p className="break-words font-['Pretendard'] font-light text-[1rem] text-[#FFFFFF]">
                        테커에서 진행한 <span className="font-['Pretendard-SemiBold']">다양한 프로젝트를 한눈에</span>
                    </p>
                </div>
                {/* 오른쪽 박스 블러 배경 */}
                <div className="gap-4 backdrop-blur-[1.25rem] rounded-r-[1.25rem] bg-[rgba(0,1,58,0.7)] flex flex-col justify-center items-center w-[31.875rem]">
                    <div className="m-[0_0_4.625rem_0] inline-block break-words font-['Pretendard'] font-semibold text-[2.25rem] tracking-[0.044rem] leading-[1.333] text-[#F0F0F0]">
                    로그인
                    </div>
                    {/* 아이디 입력 Input */}
                    <div className="rounded-[0.375rem] border border-solid border-[#E2E2E2] border-1 relative flex flex-row w-[18.25rem] h-[3.125rem]">
                        <div className="flex flex-row justify-center items-center p-[0.625rem]">
                            <img className="w-[1.125rem] h-[1.125rem]" src="./src/shared/assests/Icon-Id.png" />
                        </div>
                        <span className="break-words font-['Pretendard'] font-normal text-[1rem] tracking-[0.019rem] leading-[3] text-[#BABABA]">
                        아이디
                        </span>
                        <input
                            type="text"
                            name="id"
                            className="w-[11.25rem] m-[0.625rem] bg-transparent text-[#FFFFFF] focus:outline-none bg-transparent"
                        />
                    </div>
                    {/* 비밀번호 입력 Input */}
                    <div className="rounded-[0.375rem] border border-solid border-[#E2E2E2] border-1 relative flex flex-row w-[18.25rem] h-[3.125rem]">
                        <div className="flex flex-row justify-center items-center p-[0.625rem]">
                            <img className="w-[1.125rem] h-[1.125rem]" src="./src/shared/assests/Icon-Password.png" />
                        </div>
                        <span className="break-words font-['Pretendard'] font-normal text-[1rem] tracking-[0.019rem] leading-[3] text-[#BABABA]">
                        비밀번호
                        </span>
                        <input
                            type="text"
                            name="password"
                            className="w-[10.625rem] m-[0.625rem] bg-transparent text-[#FFFFFF] focus:outline-none bg-transparent"
                        />
                    </div>
                    {/* 로그인 버튼 */}
                    <div className="rounded-[0.375rem] bg-[#4344E0] relative flex flex-row justify-center w-[292px]">
                        <button className="relative break-words font-['Pretendard'] font-normal text-[1rem] tracking-[0.019rem] leading-[3] text-[#FFFFFF]">
                        로그인
                        </button>
                    </div>
                    <span className="m-[0_0_0_0.063rem] break-words font-['Pretendard'] font-normal text-[1rem] underline tracking-[0.019rem] leading-[3] text-[#757575]">
                    회원가입
                    </span> 
                </div>
            </div> 
        </div>      
    );
};

export default LogIn