create table member
(
    memberid varchar2(20) primary key,
    passwd varchar2(100) not null,
    email varchar2(50) null,
    active char(1) default ('1'),
    regdate date default (sysdate)
);

-- ���̺� ����� 2
-- �̸� : �Խ��� (Board)
-- �÷� : �۹�ȣ(boardno), ����(title), �ۼ���(writer), ����(content),
--        �ۼ�����(writedate), ��������(modifydate), ��ȸ�� (readcount)
-- �������� : �۹�ȣ : pk / ����, �ۼ��� : not null
--           �ۼ�����, �������� : default ����, ��ȸ�� : default 0

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
