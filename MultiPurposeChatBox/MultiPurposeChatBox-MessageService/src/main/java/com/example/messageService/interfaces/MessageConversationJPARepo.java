package com.example.messageService.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.messageService.bean.ConversationContactsBean;

public interface MessageConversationJPARepo extends JpaRepository<ConversationContactsBean, Integer> {

	
	@Query(value = "select DISTINCT RECEIVERID from CONVERSATIONCONTACTSERVICE where SENDERID=?1 AND RECEIVERID=?2",
			nativeQuery = true)
	List<Integer> findBysenderId(int senderId, int receiverId);

	@Query(value = "select DISTINCT RECEIVERID from CONVERSATIONCONTACTSERVICE where SENDERID=?1",
			nativeQuery = true)
	List<Integer> findBysenderId(int senderId);

}
