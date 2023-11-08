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
            return !inline && match ? (
              <SyntaxHighlighter
                language={match[1]}
                PreTag="div"
                children={String(children).replace(/\n$/, "")}
                style={dracula}
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
  );
};

export default MarkdownPreview;
