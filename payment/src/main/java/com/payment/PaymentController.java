package com.payment;

import com.payment.model.Payment;
import com.payment.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payment")
    public boolean getPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setPrice(paymentRequest.price);
        payment.setProductID(paymentRequest.productID);
        paymentRepository.save(payment);
        if(this.getPaymentStatus(payment)) {

            return true;
        }
            return false;

    }

    private boolean getPaymentStatus(Payment payment){

        //hier müsste die Bezahlt Logik rein, 3th party app-> für uns immer bezahlt

        return true;
    }
}
