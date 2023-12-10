package br.com.mmmsieto.saleservice.adapters.in.controller;

import br.com.mmmsieto.saleservice.adapters.in.controller.mapper.SaleRequestMapper;
import br.com.mmmsieto.saleservice.adapters.in.controller.request.SaleRequest;
import br.com.mmmsieto.saleservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.saleservice.application.ports.in.CreateSaleInputPort;
import br.com.mmmsieto.saleservice.config.kafka.CustomDeserializer;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;
import java.time.Duration;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private CreateSaleInputPort createSaleInputPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("Starting the creation of the sale");
        createSaleInputPort.create(SaleRequestMapper.toSale(saleRequest));
        log.info("Successfully created sale");
    }

    @GetMapping("/{offerId}")
    @ResponseStatus(HttpStatus.OK)
    public SaleMessage find(@PathVariable("offerId") String offerId) {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "your-consumer-group");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        KafkaConsumer<String, SaleMessage> consumer = new KafkaConsumer<>(props);

        String topic = "tp-saga-sale";
        int partitionNumber = 0;
        long specificOffset = Long.parseLong(offerId);

        TopicPartition partition = new TopicPartition(topic, partitionNumber);
        consumer.assign(List.of(partition));
        consumer.seek(partition, specificOffset);

        SaleMessage saleMessage = null;

        ConsumerRecords<String, SaleMessage> records = consumer.poll(Duration.ofMillis(1000)); // Ajuste o tempo de espera conforme necessário
        if (!records.isEmpty()) {
            ConsumerRecord<String, SaleMessage> record = records.iterator().next();
            if (record.offset() == specificOffset) {
                 saleMessage = record.value();
                System.out.println("Consumindo do offset " + record.offset() + ": " + saleMessage);
            }
        }
        consumer.close();

        return saleMessage;

    }

}
