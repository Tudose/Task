/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elfy.TaskCreator.mail;

import com.elfy.TaskCreator.dataTypes.Protocol;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Victor
 */
public class EmailSessionBean {

    private int port = 465;
        private String host = "Smtp.gmail.com";
        private String from = "";
        private boolean auth = true;
        private String  username = "";
        private String password = "";
        private Protocol protocol = Protocol.SMTPS;
        private boolean debug = true;
        
        
        public void sendEmail(String to , String subject , String body){
            
            Properties prop = new Properties();
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.port", port);
                
                switch(protocol){
                    case SMTPS :
                        prop.put("mail.smtp.ssl.enable",true);
                        break;
                    case TLS:
                        prop.put("mail.smtp.starttls.enable", true);
                        break;
                }
                
                Authenticator authenticator = null;
                if(auth){
                    prop.put("mail.smtp.auth", true);
                    authenticator = new Authenticator() {
                        private PasswordAuthentication pa = new PasswordAuthentication(username, password);
                        public PasswordAuthentication getPasswordAuthentication(){
                            return pa;
                        }
};
                }
            
                Session session = Session.getDefaultInstance(prop,authenticator);
                session.setDebug(debug);
                
                
                MimeMessage message = new MimeMessage(session);
                try{
                        message.setFrom(new InternetAddress(from));
                        InternetAddress[] address = { new InternetAddress(to)};
                        message.setRecipients(Message.RecipientType.TO, address);
                        message.setSubject(subject);
                        message.setSentDate(new Date());
                        message.setText(body);
                        Transport.send(message);
                    } catch (MessagingException ex) {
                            ex.printStackTrace();
            }
                }
                
        }
