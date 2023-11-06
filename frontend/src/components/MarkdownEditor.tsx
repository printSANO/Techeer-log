import React, { useState, ChangeEvent } from "react";
import ReactMarkdown from "react-markdown";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { materialDark } from "react-syntax-highlighter/dist/esm/styles/prism";
import remarkGfm from "remark-gfm";
import style from "styled-components";

const Preview = style.div`
  font-size: 1.125rem;
  color: #ECECEC;
  transition: color 0.125s ease-in 0s;
  line-height: 1.7;
  letter-spacing: -0.004em;
  word-break: keep-all;
  overflow-wrap: break-word;
`;

const MarkdownEditor = () => {
  const [markdown, setMarkdown] = useState(""); // Markdown 내용을 저장하는 상태

  // Markdown 내용이 변경될 때 호출되는 함수
  const handleMarkdownChange = (e: ChangeEvent<HTMLTextAreaElement>) => {
    setMarkdown(e.target.value);
  };

  return (
    <div>
      <textarea
        value={markdown}
        onChange={handleMarkdownChange}
        rows={10}
        cols={50}
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
