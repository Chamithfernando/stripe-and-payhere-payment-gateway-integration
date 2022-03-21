package com.stripe.stripepaymentgatewayintegration.request;

import lombok.Data;

@Data
public class PayhereChargeRequest {

    public enum Currency {
        EUR, USD;
    }

    private Currency payhere_currency;
    private String order_id ;
    private String merchant_id;
    private String payment_id;
    private int payhere_amount;
    private String method;
    private String status_code;
    private String status_message;
    private String card_holder_name;
    private String card_no;
    private String card_expiry;






}
