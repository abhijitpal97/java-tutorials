package com.example.searchmessage.interfaces;

import java.io.IOException;
import java.util.List;

import com.example.searchmessage.bean.MessageSearchBean;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;

public interface SearchDataInterface {

	public List<MessageSearchBean> searchMessage(String searchdata) throws ElasticsearchException, IOException;
}
