package br.com.mmmsieto.orchestrationservice.adapters.in.consumer;

import br.com.mmmsieto.orchestrationservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.orchestrationservice.application.ports.in.WorkflowInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ReceiveSaleToProcessConsumer {

    @Autowired
    private List<WorkflowInputPort> workflows;

    @RetryableTopic(
            attempts = "3",
            backoff = @Backoff(delay = 1000, multiplier = 2),
            autoCreateTopics = "true",
           include = Exception.class)
    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    public void receive(SaleMessage saleMessage) {

        try {
            //TODO: remove this line, used only to test retry
            if (true) throw new RuntimeException("Teste");

            System.out.println("Sale received: " + saleMessage);

            var workflow = workflows.stream()
                    .filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
                    .findFirst()
                    .orElse(null);

            if (workflow != null) {
                workflow.execute(saleMessage.getSale());
            } else {
                log.error("Workflow not found for event: " + saleMessage.getEvent());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
