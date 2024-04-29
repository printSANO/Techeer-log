import Footer from "../../../shared/ui/Footer.tsx";

export const ProjectComment = () => {
    return (
        <div className="bg-[#0F1012] w-[100vw] box-sizing-border">
            <div className="relative flex flex-col w-[68rem] pt-[5rem] mr-auto ml-auto box-sizing-border">
                <div className="rounded-[0.3rem] mb-[4rem] flex flex-col w-[100%] box-sizing-border">
                    <div
                        className="m-[0_0_3.3rem_0] inline-block self-start break-words font-['Inter'] font-semibold text-[1.5rem] text-[#FFFFFF]">
                        2개의 댓글
                    </div>
                    <input
                        placeholder="댓글을 작성하세요."
                        className="placeholder-white bg-transparent w-[100%] border-none m-[0_0_1.5rem_0] inline-block self-start break-words font-['Inter'] font-normal text-[1.2rem] text-[#FFFFFF]"
                    ></input>
                    <div className="bg-[#989898] w-[100%] h-[0.1rem]"></div>
                    <button
                        className="rounded-[0.3rem] mt-[2rem] bg-[#696868] relative flex flex-row justify-center self-end p-[0.6rem_0rem_0.6rem_0] w-[7.5rem] box-sizing-border">
                  <span className="break-words font-['Inter'] font-semibold text-[1.2rem] tracking-[0.1rem] text-[#FFFFFF]">
                    댓글 작성
                  </span>
                    </button>
                </div>
                <div className="w-[100%] mb-[1.5rem]">
                    <div className="flex justify-between self-start w-[100%] box-sizing-border mb-[3rem]">
                        <div className="flex flex-row">
                            <div
                                className="rounded-[16.3rem] bg-[url('/src/shared/assets/image/BigProfileImg.png')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_1.3rem_0_0] w-[4.3rem] h-[4.3rem]"></div>
                            <div className="m-[0.5rem_0_0.6rem_0] flex flex-col flex-start box-sizing-border">
                                <div
                                    className="m-[0_0_0.6rem_0] inline-block break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                                    이이름
                                </div>
                                <span
                                    className="m-[0_0.7rem_0_0] break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                        2023.10.12
                      </span>
                            </div>
                        </div>

                        <div
                            className="m-[1.7rem_0rem_1.5rem_0] inline-block break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                            수정 삭제
                        </div>
                    </div>
                    <span className="self-start break-words font-['Inter'] font-normal text-[1.2rem] text-[#FFFFFF]">
                  우왕 저도 참고해서 이번 부트캠프 열심히 해보겠습니다~~
                </span>
                </div>
                <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
                <div className="w-[100%] mr-auto ml-auto mb-[1.5rem]">
                    <div className="flex justify-between self-start w-[100%] box-sizing-border mb-[3rem]">
                        <div className="flex flex-row">
                            <div
                                className="rounded-[16.3rem] bg-[url('/src/shared/assets/image/BigProfileImg.png')] bg-[50%_50%] bg-cover bg-no-repeat m-[0_1.3rem_0_0] w-[4.3rem] h-[4.3rem]"></div>
                            <div className="m-[0.5rem_0_0.6rem_0] flex flex-col flex-start box-sizing-border">
                                <div
                                    className="m-[0_0_0.6rem_0] inline-block break-words font-['Inter'] font-semibold text-[1.3rem] text-[#FFFFFF]">
                                    이이름
                                </div>
                                <span
                                    className="m-[0_0.7rem_0_0] break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                        2일 전
                      </span>
                            </div>
                        </div>

                        <div
                            className="m-[1.7rem_0rem_1.5rem_0] inline-block break-words font-['Inter'] font-normal text-[1rem] text-[#FFFFFF]">
                            수정 삭제
                        </div>
                    </div>
                    <span className="self-start break-words font-['Inter'] font-normal text-[1.2rem] text-[#FFFFFF]">
                  우왕 저도 참고해서 이번 부트캠프 열심히 해보겠습니다~~
                </span>
                </div>
                <div className="bg-[#989898] w-[100%] h-[0.05rem] mb-[7rem]"></div>
            </div>
            <Footer />
        </div>
    )
}