import { useState, ChangeEvent } from "react";
import ReactMarkdown from "react-markdown";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { materialDark } from "react-syntax-highlighter/dist/esm/styles/prism";
import remarkGfm from "remark-gfm";
import styled from "styled-components";

const Preview = styled.div`
  font-size: 1.125rem;
  color: #ececec;
  transition: color 0.125s ease-in 0s;
  line-height: 1.7;
  letter-spacing: -0.004em;
  word-break: keep-all;
  overflow-wrap: break-word;
  max-width: 54rem;
`;

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
      <Preview>
        <ReactMarkdown
          remarkPlugins={[remarkGfm]}
          components={{
            code({ inline, className, children, ...props }) {
              const match = /language-(\w+)/.exec(className || "");
              return !inline && match ? (
                <SyntaxHighlighter
                  style={materialDark}
                  language={match[1]}
                  PreTag="div"
                  children={String(children).replace(/\n$/, "")}
                  {...props}
                />
              ) : (
                <code className={className} {...props}>
                  {children}
                </code>
              );
            },
          }}
        >
          {markdown}
        </ReactMarkdown>
      </Preview>
    </div>
  );
};

export default MarkdownEditor;
