package com.example.addConfig.kafkaService;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	Logger log = LoggerFactory.getLogger(Producer.class);

	
	public void ProducerData(String module , String data , String key)
	{
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "DESKTOP-GABUEQ7:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.ACKS_CONFIG, "all");
		Thread.currentThread().setContextClassLoader(null);

		KafkaProducer<String , String> producer = new KafkaProducer<String, String>(props);

		ProducerRecord<String, String> records = new ProducerRecord<String, String>("CaseAnalysisAuditTopic", key , data);


		RecordMetadata future;
		try {
			future = producer.send(records).get();
			log.info("Addition of Record for module - "+module+" completed successfully with reference - " + future.partition());
		} catch (InterruptedException e1) {
			log.info("Addition of Record for module - "+module+" failde with error - "+e1.getMessage());
		} catch (ExecutionException e1) {
			log.info("Addition of Record for module - "+module+" failde with error - "+e1.getMessage());
		}
		finally {
			producer.flush();
			producer.close();
		}


	}

}
