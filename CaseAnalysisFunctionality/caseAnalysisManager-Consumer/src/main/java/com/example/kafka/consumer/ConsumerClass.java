package com.example.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerClass {

	private static Logger log= LoggerFactory.getLogger(ConsumerClass.class.getSimpleName());

	public static void main(String[] args) { 

		//Set property
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "DESKTOP-GABUEQ7:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "CaseAnalysisLogReaderGroup");
		props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		try (
				//Create Consumer 
				KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) 
		{
			//Get Reference of the Current Consumer
			Thread mainThread = Thread.currentThread();

			// Adding Shutdown
			Runtime.getRuntime().addShutdownHook(new Thread(

					() ->

					{
						log.info("Detected Shutdown !");
						consumer.wakeup();

						//join Main Thread

						try {
							mainThread.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					));

			try
			{
				//Subsribe the Consumer to topic
				consumer.subscribe(Arrays.asList("CaseAnalysisAuditTopic"));

				//poll for new record
				while(true)
				{
					ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

					for(ConsumerRecord<String, String> record : records)
					{
						log.info("Key - "+record.key() + " with value - "+record.value());
						log.info("Partion - "+record.partition() + " from offset - "+record.offset());
					}

				}
			}
			catch (WakeupException e) {
				log.info("Wakeup exception !");
			}
			catch (Exception e) {
				log.error("UnExpected Exception - "+e.getMessage() , e);
			}
			finally {
				consumer.close(); //Will commit offset
			}
		}

	}

}
