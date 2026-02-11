package com.pos.payload.StoreAnalysis;

import com.pos.domain.PaymentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentInsightDTO {
    private PaymentType paymentMethod; // Cash, UPI, Card, Wallet
    private Double totalAmount;
}
