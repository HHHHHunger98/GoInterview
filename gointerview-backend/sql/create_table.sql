-- create database
create database if not exists gointerviewdb;

-- user table
use gointerviewdb;

create table if not exists user
(
    id 				bigint auto_increment comment 'id' 			primary key,
    userAccount 	varchar(256) 								not null comment 'account',
    userPassword 	varchar(256) 								not null comment 'password',
    subId 			varchar(256) 								null comment 'third party login id',
    userName 		varchar(256) 								null comment 'name',
    userAvatar 		varchar(256) 								null comment 'avatar',
    userProfile 	varchar(512) 								null comment 'profile',
    userRole 		varchar(256) default 'user' 				not null comment 'user role: user/admin',
    editTime 		datetime default CURRENT_TIMESTAMP 			not null comment 'last edited time',
    createTime 		datetime default CURRENT_TIMESTAMP 			not null comment 'created time',
    updateTime 		datetime default CURRENT_TIMESTAMP 			not null on update CURRENT_TIMESTAMP comment 'last updated time',
    isDelete 		tinyint default 0 							not null comment 'logical delete',
    index idx_subId (subId)
) comment 'user' collate = utf8mb4_unicode_ci;

create table if not exists question_bank
(
    id 			bigint auto_increment comment 'id' 	primary key,
    title 		varchar(256) 						null comment 'question bank title',
    description text 								null comment 'question bank description',
    picture 	varchar(2048) 						null comment 'question bank picture',
    userId 		bigint 								not null comment 'the creator id',
    editTime 	datetime default CURRENT_TIMESTAMP 	not null comment 'last edited time',
    createTime 	datetime default CURRENT_TIMESTAMP 	not null comment 'created time',
    updateTime 	datetime default CURRENT_TIMESTAMP 	not null on update CURRENT_TIMESTAMP comment 'last updated time',
    isDelete 	tinyint default 0 					not null comment 'logical delete',
    index idx_title(title)
) comment 'question bank' collate = utf8mb4_unicode_ci;

create table if not exists question
(
    id 			bigint auto_increment comment 'id' 	primary key,
    title 		varchar(256) 						null comment 'question title',
    content 	text 								null comment 'question content',
    tags 		varchar(1024) 						null comment 'tag list(JSON Array)',
    answer 		text 								null comment 'answer to question',
    userId 		bigint 								not null comment 'the creator id',
    editTime 	datetime default CURRENT_TIMESTAMP 	not null comment 'last edited time',
    createTime 	datetime default CURRENT_TIMESTAMP 	not null comment 'created time',
    updateTime 	datetime default CURRENT_TIMESTAMP 	not null on update CURRENT_TIMESTAMP comment 'last updated time',
    isDelete 	tinyint default 0 					not null comment 'logical delete',
    index idx_title(title),
    index idx_userId(userId)
) comment 'question' collate = utf8mb4_unicode_ci;

create table if not exists question_question_bank
(
    id bigint auto_increment comment 'id' primary key,
    questionBankId bigint not null comment 'question bank id',
    questionId bigint not null comment 'question id',
    userId bigint not null comment 'creator id',
    createTime 	datetime default CURRENT_TIMESTAMP 	not null comment 'created time',
    updateTime 	datetime default CURRENT_TIMESTAMP 	not null on update CURRENT_TIMESTAMP comment 'last updated time',
    UNIQUE (questionBankId, questionId)
) comment 'question and question bank relationship' collate = utf8mb4_unicode_ci;

-- post table
create table if not exists post
(
    id         bigint auto_increment comment 'id' primary key,
    title      varchar(512)                       null comment 'title',
    content    text                               null comment 'content',
    tags       varchar(1024)                      null comment 'tags array(json array)',
    thumbNum   int      default 0                 not null comment 'number of likes',
    favourNum  int      default 0                 not null comment 'number of add to favorite',
    userId     bigint                             not null comment 'created user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'created at',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'time updated',
    isDelete   tinyint  default 0                 not null comment 'is deleted',
    index idx_userId (userId)
) comment 'post ' collate = utf8mb4_unicode_ci;

-- post likes table
create table if not exists post_thumb
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment 'post id',
    userId     bigint                             not null comment 'user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'created at',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'time updated',
    index idx_postId (postId),
    index idx_userId (userId)
) comment 'post likes';

-- post favorite table
create table if not exists post_favour
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment 'post id',
    userId     bigint                             not null comment 'user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'created at',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'time updated',
    index idx_postId (postId),
    index idx_userId (userId)
) comment 'post add to favorite';
