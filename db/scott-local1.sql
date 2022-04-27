create table member
(
    memberid varchar2(20) primary key,
    passwd varchar2(100) not null,
    email varchar2(50) null,
    active char(1) default ('1'),
    regdate date default (sysdate)
);

-- 테이블 만들기 2
-- 이름 : 게시판 (Board)
-- 컬럼 : 글번호(boardno), 제목(title), 작성자(writer), 내용(content),
--        작성일자(writedate), 수정일자(modifydate), 조회수 (readcount)
-- 제약조건 : 글번호 : pk / 제목, 작성자 : not null
--           작성일자, 수정일자 : default 현재, 조회수 : default 0

create table board
(
    boardno number not null,
    title varchar2(100 char) not null,
    writer varchar2(20) not null,
    content varchar2(4000 char) null,
    writerdate date default(sysdate),
    modifydate date default(sysdate),
    readcount number(7) default (0),
    constraint pk_board primary key (boardno),
    constraint fk_board_member 
    foreign key (writer) references member(memberid)
);
