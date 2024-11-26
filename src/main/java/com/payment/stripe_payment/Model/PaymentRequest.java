package com.payment.stripe_payment.Model;

public class PaymentRequest {
    private int amount; // Amount in dollars

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
