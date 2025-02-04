import ReactMarkdown from 'react-markdown';
import { Prism as SyntaxHighlighter } from 'react-syntax-highlighter';
import { nord } from 'react-syntax-highlighter/dist/esm/styles/prism';
import remarkGfm from 'remark-gfm';

export const MarkdownView = ({ markdown }: { markdown: string }) => {
  return (
    <div
      className={
        'bg-transparent w-[100%] h-fit text-[1.2rem] outline-none cursor-text border-none text-white focus:text-white px-1 leading-6'
      }
    >
      <ReactMarkdown
        remarkPlugins={[remarkGfm]}
        components={{
          code({ className, children }) {
            const match = /language-(\w+)/.exec(className || '');
            return match ? (
              // 코드 (```)
              <SyntaxHighlighter style={nord} language={match[1]} PreTag="div">
                {String(children)
                  .replace(/\n$/, '')
                  .replace(/\n&nbsp;\n/g, '')
                  .replace(/\n&nbsp\n/g, '')}
              </SyntaxHighlighter>
            ) : (
              <SyntaxHighlighter style={nord} background="green" language="textile" PreTag="div">
                {String(children).replace(/\n$/, '')}
              </SyntaxHighlighter>
            );
          },
          // 인용문 (>)
          blockquote({ children, ...props }) {
            return (
              <blockquote
                style={{
                  background: '#7afca19b',
                  padding: '1px 15px',
                  borderRadius: '10px',
                }}
                {...props}
              >
                {children}
              </blockquote>
            );
          },
          img({ ...props }) {
            return (
              <img
                style={{ maxWidth: '40vw' }}
                src={props.src?.replace('../../../../public/', '/')}
                alt="MarkdownRenderer__Image"
              />
            );
          },
          em({ children, ...props }) {
            return (
              <span style={{ fontStyle: 'italic' }} {...props}>
                {children}
              </span>
            );
          },
        }}
      >
        {markdown
          .replace(/\*\*/gi, '@$_%!^')
          .replace(/@\$_%!\^/gi, '**')
          .replace(/<\/?u>/gi, '*')}
      </ReactMarkdown>
    </div>
  );
};
