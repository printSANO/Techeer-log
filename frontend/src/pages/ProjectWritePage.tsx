import * as textEdit from '../entities/textEdit/index';
import * as Modal from '../entities/projectInputModal/index';

export const ProjectWritePage = () => {
  return (
    <>
      <div className="relative flex flex-col w-screen h-screen bg-black px-[0rem]">
        <textEdit.headerInput />
        <textEdit.markdownView />
        <textEdit.bottomButtons />
        <div className="fixed">
          <Modal.ProjectInfo />
        </div>
      </div>
    </>
  );
};
