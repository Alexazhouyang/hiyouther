package com.service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* @ClassName: Sendmail
* @Description: 发送Email
* @author: 孤傲苍狼
* @date: 2015-1-12 下午9:42:56
*
*/ 
@Service
@Transactional
public class SendEmailService {
		/**
		 * 配置发件人基础信息
		 *  邮箱服务器，发件人密码，发件人邮箱
		 * */
		private final static String  mailHost ="smtp.sina.com";
		private final static String mailAddress="forvoid@sina.com";
		private final static String mailPWD = "tao15987";
		
	
	

	    /**
	     * @param args
	     * @throws Exception 
	     * 发送邮件。
	     * 返回状态码：0：成功，-1失败
	     */
	    public int sendEmail(String title,String content,String toEmail) throws Exception {
	        try{
	        Properties prop = new Properties();
	        prop.setProperty("mail.host", mailHost);
	        prop.setProperty("mail.transport.protocol", "smtp");
	        prop.setProperty("mail.smtp.auth", "true");
	        //使用JavaMail发送邮件的5个步骤
	        //1、创建session
	        Session session = Session.getInstance(prop);
	        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	        session.setDebug(true);
	        //2、通过session得到transport对象
	        Transport ts = session.getTransport();
	        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	        ts.connect(mailHost, mailAddress, mailPWD);
	        //4、创建邮件
	        Message message = createSimpleMail(session,title,content,toEmail);
	        //5、发送邮件
	        ts.sendMessage(message, message.getAllRecipients());
	        ts.close();
	        return 1;}catch(Exception e){
	        	e.printStackTrace();
	        	return -1;
	        }
	    }
	    
	    /**
	    * @Method: createSimpleMail
	    * @Description: 创建一封只包含文本的邮件
	    * @Anthor:孤傲苍狼
	    *
	    * @param session
	    * @return
	    * @throws Exception
	    */ 
	    public static MimeMessage createSimpleMail(Session session,String title,String content,String toEmail)
	            throws Exception {
	        //创建邮件对象
	        MimeMessage message = new MimeMessage(session);
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress(mailAddress));
	        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	        //邮件的标题
	        message.setSubject(title);
	        //邮件的文本内容
	        message.setContent(content, "text/html;charset=UTF-8");
	        //返回创建好的邮件对象
	        return message;
	    }
	
}
