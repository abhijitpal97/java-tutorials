create table USERTABLE
(
userID NUMBER NOT NULL PRIMARY KEY,
name  VARCHAR2(100) NOT NULL 
);

create table POINTS
(
pointId NUMBER NOT NULL PRIMARY KEY,
point NUMBER NOT NULL,
userId NUMBER NOT NULL,
FOREIGN KEY ( userId )
        REFERENCES USERTABLE ( userid )
);

desc usertable;

create SEQUENCE USERSEQUENCE;

create SEQUENCE POINTSEQUENCE;

select * from usertable;
select * from points;
