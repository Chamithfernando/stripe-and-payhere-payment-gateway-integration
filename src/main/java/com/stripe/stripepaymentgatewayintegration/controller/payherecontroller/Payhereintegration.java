package com.stripe.stripepaymentgatewayintegration.controller.payherecontroller;

import com.stripe.stripepaymentgatewayintegration.request.PayhereChargeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;

@RestController
public class Payhereintegration {


    @PostMapping("/notify")
    public Serializable notifyRequest(@RequestBody PayhereChargeRequest chargeRequest){

        PayhereChargeRequest request = new PayhereChargeRequest();
        request.setMerchant_id(chargeRequest.getMerchant_id());
        request.setOrder_id(chargeRequest.getOrder_id());
        request.setPayment_id(chargeRequest.getPayment_id());
        request.setPayhere_amount(chargeRequest.getPayhere_amount());
        request.setPayhere_currency(chargeRequest.getPayhere_currency());
        request.setMethod(chargeRequest.getMethod());
        request.setStatus_code(chargeRequest.getStatus_code());
        request.setStatus_message(chargeRequest.getStatus_message());

        if (chargeRequest.getCard_holder_name() != null) {

            request.setCard_holder_name(chargeRequest.getCard_holder_name());
            request.setCard_no(chargeRequest.getCard_no());
            request.setCard_expiry(chargeRequest.getCard_expiry());

        }

        String message = "";
        switch (chargeRequest.getStatus_code()){
            case "0" :
                message =  "Transaction is Pending";
                break;
            case "2" :
                message ="Transaction is Successful";
                break;
            case "-1" :
                message ="Transaction Canceled";
                break;
            case "-2" :
                message ="Transaction Failed";
                break;
            case "-3":
                message ="Charged Back";
                break;
            default:
                message ="Unknown Error";

        }
        return new ResponseStatusException(HttpStatus.OK, message);

    }

}
