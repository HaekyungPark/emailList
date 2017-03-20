--SQL TEST

insert INTO emailList values(seq_emailList.nextval, '둘','리','dooly@gamail.com');

select no, first_name, last_name, email from emailList order by no;

rollback;
commit;