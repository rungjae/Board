drop table BOARD;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARD(
    SEQ number constraint BOARD_PK primary key,
    WRITER varchar2(12),
    EMAIL varchar2(20),
    SUBJECT varchar2(20),
    CONTENT varchar2(20),
    RDATE date default SYSDATE
);
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(BOARD_SEQ.nextval, '김민경', 'kmj@hanmail.net','제목1', '내용1', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김수환', 'ksh@hanmail.net','제목2', '내용2', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김지수', 'kjs@hanmail.net','제목3', '내용3', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김지협', 'kjh@hanmail.net','제목4', '내용4', SYSDATE);

commit;