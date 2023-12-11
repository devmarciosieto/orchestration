package br.com.mmmsieto.orchestrationservice;

import br.com.mmmsieto.orchestrationservice.adapters.out.message.SaleMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KafkaTemplateInjectionTest {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Test
    void kafkaTemplateShouldBeInjected() {
        assertNotNull(kafkaTemplate, "KafkaTemplate should be injected");
    }
}
