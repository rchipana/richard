/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.jsf.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author rchipana
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
////        String servidorSMTP = "smtp.gmail.com";
////        String puerto = "587";
////        String usuario = "sonidochipana@gmail.com";
////        String password = "uwnizrmzikksjjma";
////
////        String destino = "yuly_0702@hotmail.com";
////        String asunto = "Prueba chancho!";
////        String mensaje = "Este es un mensaje de prueba Chancho.";
////
////        Properties props = new Properties();
////
////        props.put("mail.debug", "true");
////        props.put("mail.smtp.auth", true);
////        props.put("mail.smtp.starttls.enable", true);
////        props.put("mail.smtp.host", servidorSMTP);
////        props.put("mail.smtp.port", puerto);
////
////        Session session = Session.getInstance(props, null);
////
////        try {
////            MimeMessage message = new MimeMessage(session);
////            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
////                    destino));
////            message.setSubject(asunto);
////            message.setSentDate(new Date());
////            message.setText(mensaje);
////
////            Transport tr = session.getTransport("smtp");
////            tr.connect(servidorSMTP, usuario, password);
////            message.saveChanges();
////            tr.sendMessage(message, message.getAllRecipients());
////            tr.close();
////
////        } catch (MessagingException e) {
////            e.printStackTrace();
////        }
////    }
////}

        String str = "5445544554";

        //encode data on your side using BASE64
        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
        System.out.println("ecncoded value is " + new String(bytesEncoded));
        String bbbbb = new String(bytesEncoded);
        System.out.println("-------------<->>>>>" + bbbbb);
       // Decode data on other side
       // , by processing encoded data
        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
        System.out.println("Decoded value is " + new String(valueDecoded));

    
}
}