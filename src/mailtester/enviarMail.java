/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailtester;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Security;  

 import java.util.Properties;  


 import javax.mail.Message;  

 import javax.mail.NoSuchProviderException;  

 import javax.mail.Session;  
 import javax.mail.Transport;  

 import javax.mail.PasswordAuthentication;  

 import javax.mail.internet.AddressException;  

 import javax.mail.internet.InternetAddress;  

 import javax.mail.internet.MimeMessage;  

public class enviarMail {
    
 public String to;  
 public String subject;  
 public String text;
 public String senha = "";
 public String email = "";
 public String host = "";
 public String porta;
 
 public enviarMail(String to, String subject, String text, String from, String senha, String host, String porta){  

      this.to = to;  
     this.subject = subject;
      this.text = text;  
      this.email = from;
      this.senha = senha;
      this.host = host;
      this.porta = porta;
     }   
 
  public String send() throws NoSuchProviderException, AddressException{  
      String logs = "";
  try 

        {  

           Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  

           Properties props=new Properties();  

           props.setProperty("mail.transport.protocol","smtp");  

           props.setProperty("mail.host",host);  

           props.put("mail.smtp.auth","true");  

           props.put("mail.smtp.port",465);  

           props.put("mail.debug","true");  

           props.put("mail.smtp.socketFactory.port",465);  

           props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  

           props.put("mail.smtp.socketFactory.fallback","false");  

           Session session=Session.getDefaultInstance(props,new GJMailAuthenticator(this.email, this.senha));  

           session.setDebug(true);  
           Transport transport=session.getTransport();  

           InternetAddress addressFrom=new InternetAddress("abc");  

           MimeMessage message=new MimeMessage(session);  

           message.setSender(addressFrom);  

           message.setSubject(subject);  

           message.setContent(text,"text/html");  

           InternetAddress addressTo=new InternetAddress(to);  

           message.setRecipient(Message.RecipientType.TO,addressTo);  

           transport.connect();  

           Transport.send(message);  

           transport.close();  




         }  

         catch(Exception e)  

         {  

            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);

            // Preenche o StringWriter com a stack trace
            e.printStackTrace(printWriter);
            String stackTrace = stringWriter.toString();
           logs = stackTrace;
 

         }  
         return logs;
    }  

 }  


