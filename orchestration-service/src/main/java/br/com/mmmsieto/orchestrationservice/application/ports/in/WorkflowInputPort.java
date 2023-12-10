package br.com.mmmsieto.orchestrationservice.application.ports.in;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent event);

}
