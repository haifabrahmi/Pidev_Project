/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author ThinkPad
 */
public class SMSUtil {
     private static final String ACCOUNT_SID = "AC1bb9840f8f8007bc2c7bcf54da4c5b4c";
   // Votre jeton d'authentification Twilio
   private static final String AUTH_TOKEN = "0dbea2026bb788155eef851f160cab60";
   // Votre numéro de téléphone Twilio
   private static final String TWILIO_NUMBER = "+15075954649";

   public static void sendSMS(String toPhoneNumber, String message) throws Exception {
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

      Message sms = Message.creator(
            new PhoneNumber(toPhoneNumber),
            new PhoneNumber(TWILIO_NUMBER),
            message
      ).create();

      System.out.println("SMS sent: " + sms.getSid());
   }
}