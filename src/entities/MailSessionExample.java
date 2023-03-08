/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
 
    
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class MailSessionExample {

    public static final String ACCOUNT_SID = "AC3d4b4fc732980bfdd7ba4ea1ad08922f";
    public static final String AUTH_TOKEN = "2b913469ae928b70afca58fe67672524";
    public static final String FROM_NUMBER = "+15673132427";
    public static final String TO_NUMBER = "+21628899807";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
                "Hello from Twilio!").create();

        System.out.println(message.getSid());
    }
}

