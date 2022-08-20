package com.example.kafka.demo;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerClass {

	private static Logger log= LoggerFactory.getLogger(ProducerClass.class.getSimpleName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Create Product Properties
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "DESKTOP-GABUEQ7:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


		// Create Producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		for(int i = 0 ; i<20; i++)
		{
			// Create Producer Record
			ProducerRecord<String, String> record = new ProducerRecord<>("new_topic" , "Send Value from Java Read - Write - Example Windows "+i);
			//ProducerRecord<String, String> record = new ProducerRecord<>("new_topic" , "key_1", "Send Value from Java - Example Again  Windows "+i);
			
			// Send Data
			Future<RecordMetadata> result = producer.send(record);
			
			log.info("Message Sent Topic - " + result.get().topic());
			log.info("Message Sent Partition - " + result.get().partition());
			log.info("Message Sent Offsets - " + result.get().offset());

		}

		//Flush and Close Producer
		producer.flush();  //synchronous
		producer.close();

	}

}
