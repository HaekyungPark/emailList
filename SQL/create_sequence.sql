--create sequence
--다시 1부터 시작하고싶으면 drop
drop SEQUENCE seq_emaillist;

create sequence seq_emaillist
start WITH 1
increment by 1
maxvalue 9999999999;