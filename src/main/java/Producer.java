import org.apache.kafka.clients.producer.*;

import java.util.Date;
import java.util.Properties;


public class Producer {
    public static void main(String[] args) {
        String clientId = "my-producer";
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("client.id", clientId);

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        int numOfRecords = 100;
        String topic = "strings";

        // example 1 - Numbers as strings for key and value without any delay
        for (int i = 0; i < numOfRecords; ++i) {
            System.out.println("Message " + i + " was just sent");
            producer.send(new ProducerRecord<>(topic, Integer.toString(i), Integer.toString(i)));

        }
        producer.close();

        
    }
}
