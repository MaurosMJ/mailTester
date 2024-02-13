/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailtester;

import javax.mail.PasswordAuthentication;

/**
 *
 * @author Mauros
 */
class GJMailAuthenticator extends javax.mail.Authenticator{  

    String email_w = "";
    String senha_w = "";
    
     public GJMailAuthenticator (String email, String senha){
      this.email_w = email;
      this.senha_w = senha;
     }
     
     protected PasswordAuthentication getPasswordAuthentication()  
     
             //"mauros99milach@gmail.com","njasjjaaqchtczbt"
     {  

         return new PasswordAuthentication(this.email_w,this.senha_w);  



     }  

 } 
