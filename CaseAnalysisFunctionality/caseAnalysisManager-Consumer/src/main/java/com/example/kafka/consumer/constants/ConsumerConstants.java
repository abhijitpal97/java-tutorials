package com.example.kafka.consumer.constants;

public class ConsumerConstants {
	

	public static final String ADD_AUDITS= "insert into audits (auditinternal ,loggedtime , event ,status)  \r\n" + 
			"(\r\n" + 
			"(select AUDITSEQUENCE.nextval,sysdate,?,'Completed' from dual))";

}
