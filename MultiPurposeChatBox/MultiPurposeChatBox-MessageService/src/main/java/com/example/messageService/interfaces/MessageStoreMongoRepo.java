package com.example.messageService.interfaces;


import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.messageService.bean.MessageStoreBean;
import com.google.common.base.Optional;

public interface MessageStoreMongoRepo extends MongoRepository<MessageStoreBean, Integer>{

	List<MessageStoreBean> findAllBymessageIdIn(List<Integer> result);

}
