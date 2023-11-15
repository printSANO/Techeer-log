import { useState, ChangeEvent } from "react";
import styled from "styled-components";
import MarkdownPreview from "./MarkdownPreview";

const Textarea = styled.textarea`
  background: transparent;
  display: inline-flex;
  outline: none;
  cursor: text;
  font-family: "Fira Mono", monospace;
  font-size: 18px;
  margin-bottom: 0.75rem;
  min-width: 8rem;
  border: none;
  color: #abbabf;
  padding: 0 0.1px 0 0;
  width: 100%;
  max-width: 54rem;
  height: 30rem;
  outline: none;
  resize: none;
  caret-color: #61afef;
  line-height: 1.5;
`;

const MarkdownEditor = () => {
  const [markdown, setMarkdown] = useState(""); // Markdown 내용을 저장하는 상태

  // Markdown 내용이 변경될 때 호출되는 함수
  const handleMarkdownChange = (e: ChangeEvent<HTMLTextAreaElement>) => {
    setMarkdown(e.target.value);
  };

  return (
    <div>
      <Textarea
        value={markdown}
        onChange={handleMarkdownChange}
        rows={10}
        cols={100}
        placeholder="당신의 이야기를 적어보세요..."
      />
      <MarkdownPreview markdown={markdown} />
    </div>
  );
};

export default MarkdownEditor;
