create table Client 
(ClientId NUMBER Primary Key , 
Name VARCHAR2(100),
LOCATION VARCHAR2(100));


create table OrderDetails
(OrderId NUMBER Primary Key , 
Item VARCHAR2(100) NOT NULL,
Quantity NUMBER  NOT NULL,
PRICE  NUMBER  NOT NULL,
ClientId NUMBER REFERENCES Client (ClientId) );


create sequence CLIENTSEQUENCE;
create sequence ORDERSEQUENCE;
