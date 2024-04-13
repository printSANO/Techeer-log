CREATE DATABASE IF NOT EXISTS console_log;

use console_log;

drop table if exists comment, framework, love, member, project, project_framework, project_member, refresh_token, scrap;

CREATE TABLE comment
(
    comment_id   BIGINT AUTO_INCREMENT NOT NULL,
    parent_id    BIGINT                NULL,
    member_id    BIGINT                NULL,
    project_id   BIGINT                NULL,
    soft_removed BIT(1)                NOT NULL,
    like_count   INT                   NOT NULL,
    created_at   datetime              NULL,
    message      VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (comment_id)
);

CREATE TABLE framework
(
    framework_id BIGINT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255)          NOT NULL,
    status       VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_framework PRIMARY KEY (framework_id)
);

CREATE TABLE love
(
    love_id    BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NULL,
    deleted    BIT(1)                NULL,
    project_id BIGINT                NULL,
    member_id  BIGINT                NULL,
    CONSTRAINT pk_love PRIMARY KEY (love_id)
);

CREATE TABLE member
(
    member_id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at        datetime              NOT NULL,
    updated_at        datetime              NULL,
    deleted           BIT(1)                NULL,
    profile_image_url VARCHAR(255)          NULL,
    role_type         VARCHAR(255)          NULL,
    login_id          VARCHAR(255)          NULL,
    password          VARCHAR(255)          NULL,
    nickname          VARCHAR(255)          NULL,
    CONSTRAINT pk_member PRIMARY KEY (member_id)
);

CREATE TABLE project
(
    project_id     BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime              NOT NULL,
    updated_at     datetime              NULL,
    deleted        BIT(1)                NULL,
    main_image_url VARCHAR(255)          NULL,
    title          VARCHAR(255)          NOT NULL,
    subtitle       VARCHAR(255)          NULL,
    content        LONGTEXT              NOT NULL,
    start_date     date                  NULL,
    end_date       date                  NULL,
    platform       VARCHAR(255)          NULL,
    project_type   VARCHAR(255)          NULL,
    semester       SMALLINT              NULL,
    project_status VARCHAR(255)          NULL,
    github_link    VARCHAR(255)          NULL,
    blog_link      VARCHAR(255)          NULL,
    website_link   VARCHAR(255)          NULL,
    view_count     INT                   NOT NULL,
    like_count     INT                   NOT NULL,
    member_id      BIGINT                NOT NULL,
    CONSTRAINT pk_project PRIMARY KEY (project_id)
);

CREATE TABLE project_framework
(
    project_framework_id BIGINT AUTO_INCREMENT NOT NULL,
    project_id           BIGINT                NOT NULL,
    framework_id         BIGINT                NOT NULL,
    CONSTRAINT pk_projectframework PRIMARY KEY (project_framework_id)
);

CREATE TABLE project_member
(
    project_member_id   BIGINT AUTO_INCREMENT NOT NULL,
    created_at          datetime              NOT NULL,
    updated_at          datetime              NULL,
    deleted             BIT(1)                NULL,
    project_id          BIGINT                NOT NULL,
    member_id           BIGINT                NOT NULL,
    project_member_type VARCHAR(255)          NULL,
    CONSTRAINT pk_projectmember PRIMARY KEY (project_member_id)
);

CREATE TABLE refresh_token
(
    refresh_token_id BIGINT AUTO_INCREMENT NOT NULL,
    token            VARCHAR(255)          NULL,
    member_id        BIGINT                NULL,
    CONSTRAINT pk_refreshtoken PRIMARY KEY (refresh_token_id)
);

CREATE TABLE scrap
(
    scrap_id   BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NULL,
    deleted    BIT(1)                NULL,
    member_id  BIGINT                NOT NULL,
    project_id BIGINT                NOT NULL,
    CONSTRAINT pk_scrap PRIMARY KEY (scrap_id)
);

ALTER TABLE member
    ADD CONSTRAINT uc_member_nickname UNIQUE (nickname);

ALTER TABLE refresh_token
    ADD CONSTRAINT uc_refreshtoken_member UNIQUE (member_id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_PARENT FOREIGN KEY (parent_id) REFERENCES comment (comment_id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (project_id);

ALTER TABLE love
    ADD CONSTRAINT FK_LOVE_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE love
    ADD CONSTRAINT FK_LOVE_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (project_id);

ALTER TABLE project_framework
    ADD CONSTRAINT FK_PROJECTFRAMEWORK_ON_FRAMEWORK FOREIGN KEY (framework_id) REFERENCES framework (framework_id);

ALTER TABLE project_framework
    ADD CONSTRAINT FK_PROJECTFRAMEWORK_ON_PROJECT FOREIGN KEY (project_id) REFERENCES member (member_id);

ALTER TABLE project_member
    ADD CONSTRAINT FK_PROJECTMEMBER_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE project_member
    ADD CONSTRAINT FK_PROJECTMEMBER_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (project_id);

ALTER TABLE project
    ADD CONSTRAINT FK_PROJECT_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE refresh_token
    ADD CONSTRAINT FK_REFRESHTOKEN_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE scrap
    ADD CONSTRAINT FK_SCRAP_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (member_id);

ALTER TABLE scrap
    ADD CONSTRAINT FK_SCRAP_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (project_id);