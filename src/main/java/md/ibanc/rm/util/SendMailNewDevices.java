/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import md.ibanc.rm.beans.MailProperties;

/**
 *
 * @author PC01017745
 */
public class SendMailNewDevices {

    String emailRecipients;
    private String filePatch;

    public SendMailNewDevices() {

    }

    public SendMailNewDevices(String emailRecipients, String filePatch) {
        this.emailRecipients = emailRecipients;
        this.filePatch = filePatch;

        if (filePatch == null) {
            System.out.println(" SendMailNewDevices request is NULL ");
        }

        System.out.println("SendMailNewDevices request= " + filePatch);
        //System.out.println("MailProperties request getContextPath= " + request.getContextPath());
        //   System.out.println("SendMailNewDevices request getRealPath(\"/\")= " + request.getRealPath("/"));
    }

    public boolean sendMail(String subject, String content) {

        final MailProperties mailProperties = new MailProperties(filePatch);
        System.out.println("Send email example NEW: " + mailProperties.toString());

        if (emailRecipients == null) {
            System.out.println(" emailRecipients is null ");
            return false;
        }
        System.out.println(" emailRecipients is not null ");
        System.out.println(" receive email = " + emailRecipients);
        Properties props = new Properties();
        Session sessionMail = null;

        if (mailProperties.getPass().length() == 0) {
            boolean sessionDebug = false;
            props.put("mail.smtp.host", mailProperties.getHost());
            props.put("mail.smtp.port", mailProperties.getPort());
            props.put("mail.transport.protocol", "smtp");

            sessionMail = Session.getDefaultInstance(props, null);
            sessionMail.setDebug(sessionDebug);
        } else if (mailProperties.getPass().length() > 0) {

            props.put("mail.smtp.host", mailProperties.getHost());
            props.put("mail.smtp.socketFactory.port", mailProperties.getPort());
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", mailProperties.getPort());
            props.put("mail.smtp.socketFactory.fallback", "true");

            sessionMail = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailProperties.getUser(), mailProperties.getPass());
                }
            });
        }
        System.out.println("Send mail before try-catch()");
        try {

            Message message = new MimeMessage(sessionMail);
            message.setFrom(new InternetAddress(mailProperties.getFrom()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailRecipients));
            message.setSubject(subject);

            message.setContent(content, "text/html");
            Transport.send(message);
            System.out.println("Succes send MAIL " + mailProperties.toString());
            return true;
        } catch (MessagingException e) {

            System.out.println("Fatal erorr in sending message: " + e.getMessage() + " String message " + e.toString());
            // return false;
            throw new RuntimeException(e);

        }

    }

}
