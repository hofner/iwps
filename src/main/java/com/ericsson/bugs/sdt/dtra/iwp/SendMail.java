package com.ericsson.bugs.sdt.dtra.iwp;

import java.io.File;
import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ericsson.bugs.sdt.dtra.iwp.data.dao.SettingsRepository;




@Component
public class SendMail {
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired(required=true)
    SettingsRepository settingsDAO;
    private static final String CHARSET = "text/html; charset=utf-8";
    
    public void send() {
        MimeMessage mail = mailSender.createMimeMessage();  
        
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("juan.miguel.olguin@ericsson.com");
            helper.setFrom("jesus.emmanuell.gonzalez@ericsson.com");
            helper.setFrom("juan.miguel.olguin@ericsshon.com");
            helper.setSubject("Lorem ipsum");
            helper.setText("Lorem ipsum dolor sit amet [...]");
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);
        //return helper;
    }
    
    /**
     * Send HTML message.
     *
     * @param subject the subject
     * @param message the message
     * @param tos the tos
     */
    public void sendHTMLMessage(String subject, String message, String... tos2) {
    	((JavaMailSenderImpl)mailSender).setPassword(settingsDAO.getSettingParameterValue("MAIL_PASSWORD"));    	
        MimeMessage mimeMessage = mailSender.createMimeMessage();           
        try {
        	//mimeMessage.setFrom(new InternetAddress(tos[0]));
            mimeMessage.setFrom(new InternetAddress(settingsDAO.getSettingParameterValue("MAIL_FROM")));            
            for (String to : tos2) {
            	if(!to.equals(""))
            		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(message, CHARSET);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
        	e.printStackTrace();
        }
        // Send Message
        mailSender.send(mimeMessage);

    }



    /**
     * Send html message.
     *
     * @param file the file
     * @param subject the subject
     * @param message the message
     * @param tos the tos
     */
    public void sendHTMLMessage(ArrayList<File> files, String subject, String message, String... tos2) {
    	((JavaMailSenderImpl)mailSender).setPassword(settingsDAO.getSettingParameterValue("MAIL_PASSWORD"));
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {        	       	          
        	mimeMessage.setFrom(new InternetAddress(settingsDAO.getSettingParameterValue("MAIL_FROM")));
            for (String to : tos2) {
            	if(!to.equals(""))
            		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }
            mimeMessage.setSubject(subject);
            // Message
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, CHARSET);
            // Attach
            // Multipart Message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            for (int i = 0; i < files.size(); i++) {
                
                BodyPart attachBodyPart = new MimeBodyPart();
                attachBodyPart.setFileName(files.get(i).getName());
                DataHandler fileData1 = new DataHandler((DataSource) new FileDataSource(files.get(i)));
                attachBodyPart.setDataHandler(fileData1);
                multipart.addBodyPart(attachBodyPart);
            }
            //multipart.addBodyPart(attachBodyPart);
            mimeMessage.setContent(multipart);

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // Send Message
        mailSender.send(mimeMessage);

    }
    
    
    
}
