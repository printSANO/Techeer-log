import ReactMarkdown from "react-markdown";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import dracula from "react-syntax-highlighter/dist/cjs/styles/prism/dracula";
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

const MarkdownPreview = ({ markdown }: { markdown: string }) => {
  return (
    <Preview>
      <ReactMarkdown
        remarkPlugins={[remarkGfm]}
        components={{
          code({ node, inline, className, children, ...props }) {
            const match = /language-(\w+)/.exec(className || "");
            
            return inline ? (
              // 강조
              <code
                style={{
                  background: "var(--highlight-color)",
                  padding: "2px",
                }}
                {...props}
              >
                {children}
              </code>
            ) : match ? (
              // 코드
              // 언어가 선택됨
              <SyntaxHighlighter
                children={String(children).replace(/\n$/, "")}
                style={dracula}
                language={match[1]}
                PreTag="div"
                {...props}
              />
            ) : (
              // 언어가 선택되지 않음
              <SyntaxHighlighter
                children={String(children).replace(/\n$/, "")}
                style={dracula}
                language="textile"
                PreTag="div"
                {...props}
              />
            );
          },
        }}
      >
        {markdown
          .replace(/\n\s\n\s/gi, "\n\n&nbsp;\n\n")
          .replace(/\*\*/gi, "@$_%!^")
          .replace(/\**\*/gi, "/")
          .replace(/@\$_%!\^/gi, "**")
          .replace(/<\/?u>/gi, "*")}
      </ReactMarkdown>
    </Preview>
  );
};

export default MarkdownPreview;
