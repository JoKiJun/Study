CREATE table winning_Numbers
(
 "round" number(4)primary key
 , no1 number (2) not null
 , no2 number (2) not null
 , no3 number (2) not null
 , no4 number (2) not null
 , no5 number (2) not null
 , no6 number (2) not null
 , bonus_no number (2) not null
 );
 
 commit;
 
 select * from winning_numbers
 order by "round";
 select count(*) from winning_numbers;
 
SELECT *
from winning_numbers
where round;

 
 delete from winning_numbers;
 commit;

 