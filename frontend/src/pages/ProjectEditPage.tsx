import * as textEdit from '../entities/textEdit/index';
import * as Modal from '../entities/projectInputModal/index';
import { useState } from 'react';
import { ProjectWrite } from '../feature/ProjectWrite';
import { useNavigate } from 'react-router-dom';

export const ProjectEditPage = () => {
  const [modalOpen, setModalOpen] = useState(true);
  const [step, setStep] = useState(1);
  const navigate = useNavigate();

  const combinedStep = (direction: any) => {
    if (direction === 'next') {
      setStep(step + 1);
      if (step === 3) setModalOpen(false);
    } else if (direction === 'prev') {
      setModalOpen(true);
      setStep(step - 1);
      if (step === 1) navigate('/');
    }
  };
  return (
    <>
      <div className="relative flex flex-col w-screen h-screen bg-black px-[0rem]">
        <textEdit.HeaderInput />
        {!modalOpen && <ProjectWrite setStep={combinedStep} />}
        {modalOpen && (
          <>
            {step === 1 && (
              <div className="fixed">
                <Modal.ProjectInfo setStep={combinedStep} />
              </div>
            )}
            {step === 2 && (
              <div className="fixed">
                <Modal.TechStackInfo setStep={combinedStep} />
              </div>
            )}
            {step === 3 && (
              <div className="fixed">
                <Modal.MemberInfo setStep={combinedStep} />
              </div>
            )}
          </>
        )}
      </div>
    </>
  );
};
