package br.com.mmmsieto.paymentservice.application.core.usecase;

import br.com.mmmsieto.paymentservice.application.core.domain.Payment;
import br.com.mmmsieto.paymentservice.application.core.domain.Sale;
import br.com.mmmsieto.paymentservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.paymentservice.application.ports.in.FindUserByIdInputPort;
import br.com.mmmsieto.paymentservice.application.ports.in.SalePaymentInputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.SavePaymentOutputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.SendToKafkaOutputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort,
                              UpdateUserOutputPort updateUserOutputPort,
                              SavePaymentOutputPort savePaymentOutputPort,
                              SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void payment(Sale sale) {

        try {
            var user = findUserByIdInputPort.find(sale.getUserId());

            if (user.getBalance().compareTo(sale.getPrice()) < 0) {
                throw new RuntimeException("Insufficient balance");
            }

            user.debitBalance(sale.getPrice());
            updateUserOutputPort.update(user);
            savePaymentOutputPort.save(createPayment(sale));
            sendToKafkaOutputPort.send(sale, SaleEvent.PAYMENT_EXECUTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.PAYMENT_FAILED);
        }



    }

    private Payment createPayment(Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getPrice());
    }

}
