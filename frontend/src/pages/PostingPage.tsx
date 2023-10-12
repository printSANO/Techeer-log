import styled from "styled-components";

const Background = styled.div`
  width: 100vw;
  height: 100vh;
  background: #0c0c0c;
`;

const LeftBox = styled.div`
  width: 50vw;
  height: 100vh;
  background: #121212;
`;

const Title = styled.div`
  max-height: 540px;

  padding-top: 2rem;
  padding-left: 3rem;
  padding-right: 3rem;
`;

const TitleWrite = styled.textarea`
  background: transparent;
  display: block;
  padding: 0px;
  font-size: 2.75rem;
  width: 100%;
  resize: none;
  line-height: 1.5;
  outline: none;
  border: none;
  font-weight: bold;
  font-family: inherit;
  color: #ececec;
  height: 66px;
  &::placeholder {
    color: #aaaaaa; // placeholder 텍스트의 색상을 원하는 색상으로 변경합니다.
  }
`;

const Underbar = styled.div`
  background: rgb(73, 80, 87);
  height: 6px;
  width: 4rem;
  margin-top: 1.5rem;
  margin-bottom: 1rem;
  border-radius: 1px;
`;

const WriteTag = styled.textarea`
  background: transparent;
  display: inline-flex;
  outline: none;
  cursor: text;
  font-size: 1.125rem;
  line-height: 2rem;
  margin-bottom: 0.75rem;
  min-width: 8rem;
  border: none;
  color: #ececec;
  font-family: inherit;
  resize: none;
`;

function PostingPage() {
  return (
    <Background>
      <LeftBox>
        <Title>
          <TitleWrite placeholder="제목을 입력하세요" />
          <Underbar />
          <WriteTag placeholder="태그를 입력하세요" />
        </Title>
      </LeftBox>
    </Background>
  );
}

export default PostingPage;
