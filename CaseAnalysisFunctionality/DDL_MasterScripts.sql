-- SEQUENCE
create SEQUENCE CONFIGSEQUENCE;
create SEQUENCE BUSEQUENCE;
create sequence ALERTIDGENERETOR;
create sequence ALERTSEQUENCE;
create sequence CUSTOMERSEQUENCE;
create sequence ACCOUNTSEQUENCE;
create sequence AUDITSEQUENCE;
create sequence ADDRESSSEQUENCE;
create sequence USERSEQUENCE;
create sequence NOTESEQUENCE;
create sequence ATTACHMENTSEQUENCE;
CREATE SEQUENCE groupsequence;


-- TABLE
CREATE TABLE CONFIGURATIONLIST 
(
  CONFIGID NUMBER NOT NULL 
, REGION VARCHAR2(20) NOT NULL 
, CONFIGKEY VARCHAR2(20) NOT NULL 
, CONFIGVALUES VARCHAR2(20) NOT NULL 
, ISACTIVE VARCHAR2(20) NOT NULL 
, PARAM1 VARCHAR2(20) 
, PARAM2 VARCHAR2(20) 
, PARAM3 VARCHAR2(20) 
, PARAM4 NUMBER 
, PARAM5 NUMBER 
, PARAM6 NUMBER 
, PARAM7 DATE 
, PARAM8 DATE 
, PARAM9 DATE 
, CONSTRAINT CONFIGURATIONLIST_PK PRIMARY KEY 
  (
    CONFIGID 
  )
  ENABLE 
);

alter table CONFIGURATIONLIST modify configvalues varchar2(100);

 CREATE TABLE  BUSINESSUNITS
   (	"BU_INTERNAL_ID" NUMBER NOT NULL, 
	"BU_NAME" VARCHAR2(100 BYTE) NOT NULL, 
	 CONSTRAINT "BUSINESSUNITS_PK" PRIMARY KEY ("BU_INTERNAL_ID"));
 
 alter table businessunits  add Region VARCHAR2(50);

CREATE TABLE ALERTS 
(
  ALERTINTERNALID NUMBER NOT NULL 
, ALERTID VARCHAR2(100) 
, FOCUSTYPE VARCHAR2(100) 
, FOCUSID VARCHAR2(100) 
, FOCUSNAME VARCHAR2(100) 
, BUSINESSUNIT VARCHAR2(20) 
, OWNERNAME VARCHAR2(20) 
, PARAM1 VARCHAR2(20) 
, PARAM2 VARCHAR2(20) 
, PARAM3 VARCHAR2(20) 
, PARAM4 NUMBER 
, PARAM5 NUMBER 
, PARAM6 NUMBER 
, PARAM7 DATE 
, PARAM8 DATE 
, PARAM9 DATE 
, ESCALATIONMARKER VARCHAR2(20) 
, CONSTRAINT TABLE1_PK PRIMARY KEY 
  (
    ALERTINTERNALID 
  )
  ENABLE 
);

alter table alerts modify businessunit varchar2(50);

CREATE TABLE CUSTOMER_DETAILS 
(
  CUSTOMERID NUMBER NOT NULL 
, customerName VARCHAR2(100) 
, customerAge VARCHAR2(10) 
, customerMaterialStatus VARCHAR2(10) 
, customerGender VARCHAR2(10) 
, customerNationality VARCHAR2(20) 
, customerReligion VARCHAR2(20) 
, CONSTRAINT CUSTOMER_PK PRIMARY KEY 
  (
    CUSTOMERID 
  )
  ENABLE 
);

CREATE TABLE ACCOUNT_DETAILS 
(
  ACCOUNTID NUMBER NOT NULL ,
  customerId NUMBER NOT NULL 
, accountHolderName VARCHAR2(100) 
, accountType VARCHAR2(10) 
, accountNumber VARCHAR2(100) 
, balance VARCHAR2(1000) 
, accountScore VARCHAR2(20) 
, accountStatus VARCHAR2(20) 
, CONSTRAINT ACCOUNT_PK PRIMARY KEY 
  (
    ACCOUNTID 
  )
  ENABLE 
  ,
  FOREIGN KEY (customerId) REFERENCES CUSTOMER_DETAILS(CUSTOMERID)
);

CREATE TABLE KYC_DETAILS 
(
  uidNumber VARCHAR2(100) 
, uidReference VARCHAR2(10) 
, referenceApprover VARCHAR2(10) 
, CUSTOMERID NUMBER NOT NULL
);

CREATE TABLE ADDRESS_DETAILS 
(
  addressId NUMBER NOT NULL
, customerId NUMBER NOT NULL
, country VARCHAR2(100) 
, state VARCHAR2(10) 
, district VARCHAR2(10) 
, address VARCHAR2(100) 
, postalcode VARCHAR2(20) 
, CONSTRAINT ADDRESS_PK PRIMARY KEY 
  (
    CUSTOMERID 
  )
  ENABLE ,
  FOREIGN KEY (customerId) REFERENCES CUSTOMER_DETAILS(CUSTOMERID)
);

create table USER_DETAILS
(
USERID NUMBER NOT NULL PRIMARY KEY,
USERNAME VARCHAR2(100) NOT NULL,
PASSWORD VARCHAR2(100) NOT NULL,
EMAIL  VARCHAR2(100) NOT NULL
);

create table audits
(
auditInternal number not null primary key,
loggedTime TIMESTAMP,
event CLOB,
status varchar2(50)
);

create table notes
(
alertId number,
noteInternalId number primary key,
notes clob,
addedBy varchar2(100),
addTime TIMESTAMP
);

create table attachments
(
alertId number,
attachmentInternalId number primary key,
attachment clob,
addedBy varchar2(100),
addTime TIMESTAMP
);

CREATE TABLE groupuserdetails (
    groupid NUMBER
        NOT NULL ENABLE,
    userid  NUMBER
        NOT NULL ENABLE,
    isadmin VARCHAR2(10 BYTE),
    FOREIGN KEY ( groupid )
        REFERENCES groupdetails ( groupid )
    ENABLE,
    FOREIGN KEY ( userid )
        REFERENCES chatuserdetails ( userid )
    ENABLE
);

CREATE TABLE groupdetails (
    groupid          NUMBER NOT NULL PRIMARY KEY,
    groupname        VARCHAR2(100) NOT NULL,
    groupdescription VARCHAR2(1000),
    hasgrouppic      VARCHAR2(1000),
    isgroupactive    VARCHAR2(30),
    createdate       VARCHAR2(100) NOT NULL,
    deletedate       VARCHAR2(30),
    createdby        NUMBER,
    ISPRIVATE        NUMBER
);