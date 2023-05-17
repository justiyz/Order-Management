package com.ordermanagement.service.notification.whatsapp;


import com.ordermanagement.service.notification.SecurityConstants;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwilioWhatsapp {
    public static void sendWhatsAppMessage(String messageDetails, String customerPhoneNumber){
        if (customerPhoneNumber != null && customerPhoneNumber.startsWith("0")){
            customerPhoneNumber = "234" + customerPhoneNumber.substring(1);
        }
        log.info("CUSTOMER PHONE NUMBER -> {}", customerPhoneNumber);

        Twilio.init(SecurityConstants.ACCOUNT_SID, SecurityConstants.AUTH_TOKEN);
        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("whatsapp:+2347080258886"),
                        new com.twilio.type.PhoneNumber("whatsapp:+"+customerPhoneNumber),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        messageDetails)
                .create();

        System.out.println(message.getSid());
    }

}
