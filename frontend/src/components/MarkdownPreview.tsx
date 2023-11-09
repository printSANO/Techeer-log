import ReactMarkdown from "react-markdown";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { nord } from "react-syntax-highlighter/dist/esm/styles/prism";
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
  // const input = "This is a header\nAnd this is a paragraph";
  return (
    <Preview>
      <div>
        <ReactMarkdown
          remarkPlugins={[remarkGfm]}
          components={{
            code({ node, inline, className, children, ...props }) {
              const match = /language-(\w+)/.exec(className || "");
              return inline ? (
                // 강조 (``)
                <code
                  style={{
                    background:
                      "linear-gradient( to right, #ececec 15%, #e66c6c 85%, #f50404 )",
                    padding: "2px",
                    borderRadius: "3px",
                  }}
                  {...props}
                >
                  {children}
                </code>
              ) : match ? (
                // 코드 (```)
                <SyntaxHighlighter
                  style={nord}
                  language={match[1]}
                  PreTag="div"
                  {...props}
                >
                  {String(children)
                    .replace(/\n$/, "")
                    .replace(/\n&nbsp;\n/g, "")
                    .replace(/\n&nbsp\n/g, "")}
                </SyntaxHighlighter>
              ) : (
                <SyntaxHighlighter
                  style={nord}
                  language="textile"
                  PreTag="div"
                  {...props}
                >
                  {String(children).replace(/\n$/, "")}
                </SyntaxHighlighter>
              );
            },
            // 인용문 (>)
            blockquote({ node, children, ...props }) {
              return (
                <div
                  style={{
                    background: "#7afca19b",
                    padding: "1px 15px",
                    borderRadius: "10px",
                  }}
                  {...props}
                >
                  {children}
                </div>
              );
            },
            img({ node, ...props }) {
              return (
                <img
                  style={{ maxWidth: "60vw" }}
                  src={props.src.replace("../../../../public/", "/")}
                  alt="MarkdownRenderer__Image"
                />
              );
            },
            em({ node, children, ...props }) {
              return (
                <span style={{ fontStyle: "italic" }} {...props}>
                  {children}
                </span>
              );
            },
          }}
        >
          {markdown
            .replace(/\n/gi, "\n\n")
            .replace(/\*\*/gi, "@$_%!^")
            .replace(/@\$_%!\^/gi, "**")
            .replace(/<\/?u>/gi, "*")}
        </ReactMarkdown>
      </div>
    </Preview>
  );
};

export default MarkdownPreview;
