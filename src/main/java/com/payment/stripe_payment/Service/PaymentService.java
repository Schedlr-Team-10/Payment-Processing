package com.payment.stripe_payment.Service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // Inject the Stripe Secret Key from application.properties
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    // Optionally, inject the Publishable Key if needed
    @Value("${stripe.publishable.key}")
    private String stripePublishableKey;

    public PaymentService() {
        // Set the secret key to interact with Stripe API
        Stripe.apiKey = stripeSecretKey;
    }

    public String createPaymentIntent(long amount) throws Exception {
        // Create PaymentIntent with amount and currency
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(amount) // Amount in the smallest currency unit (e.g., cents)
                        .setCurrency("usd")
                        .build();

        PaymentIntent intent = PaymentIntent.create(params);

        // Return the client secret to frontend for confirming payment
        return intent.getClientSecret();
    }
}
