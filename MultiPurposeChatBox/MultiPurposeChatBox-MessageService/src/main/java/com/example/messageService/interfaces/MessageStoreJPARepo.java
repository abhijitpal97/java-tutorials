package com.example.messageService.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.messageService.bean.MessengerBean;



public interface MessageStoreJPARepo extends JpaRepository<MessengerBean, Integer>{

	@Query(value = "select MESSAGEID from MESSAGESERVICE where SENDERID=?1 and RECEIVERID=?2\r\n" + 
			"UNION ALL\r\n" + 
			"select MESSAGEID from MESSAGESERVICE where SENDERID=?2 and RECEIVERID=?1\r\n" + 
			"order by MESSAGEID desc",
			nativeQuery = true)
	List<Integer> findMessengerBeanBysenderIdAndreceiverId(int senderId, int receiverId);

}
