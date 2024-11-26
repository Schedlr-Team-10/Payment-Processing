package com.payment.stripe_payment.Controller;

import com.payment.stripe_payment.Model.PaymentRequest;
import com.payment.stripe_payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public String createPaymentIntent(@RequestBody PaymentRequest paymentRequest) {
        try {
            // Convert amount (e.g., dollars to cents) and create PaymentIntent
            long amount = paymentRequest.getAmount() * 100; // Convert dollars to cents
            return paymentService.createPaymentIntent(amount);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating payment intent";
        }
    }
}