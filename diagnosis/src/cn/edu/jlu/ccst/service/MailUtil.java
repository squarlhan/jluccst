package cn.edu.jlu.ccst.service;


import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * �ʼ�������
 */
@Component("mailUtil")
public class MailUtil {

    protected final Log log = LogFactory.getLog(getClass());
    
    private JavaMailSender javaMailSender;
    private String from = "squarlhan@163.com";
    private String title = "trytry";
    private String encoding = "UTF-8";
    private String[] toEmails;

    public Log getLog() {
		return log;
	}


	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}


	public String getFrom() {
		return from;
	}


	public String getTitle() {
		return title;
	}


	public String getEncoding() {
		return encoding;
	}


	public String[] getToEmails() {
		return toEmails;
	}


	public boolean send(){
        try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(msg, true, "UTF-8");
            message.setFrom(from);
            message.setSubject(title);
            message.setTo(toEmails);
			message.setText(getMessage(), true); // ������Ĳ���html����ȥ��true����
//			message.addInline("myLogo",new ClassPathResource("img/mylogo.gif"));
//			message.addAttachment("myDocument.pdf", new ClassPathResource("doc/myDocument.pdf"));
			javaMailSender.send(msg);
            
        } catch (MessagingException e) {
        	e.printStackTrace();
            if(log.isWarnEnabled()) {
                log.warn("�ʼ���Ϣ����! �ʼ�����Ϊ: "+title);
            }
            return false;
        } catch (MailException me) {
        	me.printStackTrace();
            if(log.isWarnEnabled()) {
                log.warn("�����ʼ�ʧ��! �ʼ�����Ϊ: "+title);
            }
            return false;
        }
        return true;    
    }
    
    
    /**
     * �ʼ�ģ���еõ���Ϣ
     * @return �����ط��͵�����
     */
    private String getMessage() {
		return "gfgsdfgsdfgsdfgsdfgsdg";
    }

    private String[] createToEmail(String to) {
        return new String[] {to};
    }
    
    public void setToEmail(String to) {
        setToEmails(createToEmail(to));
    }
    @Resource
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setToEmails(String[] toEmails) {
        this.toEmails = toEmails;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}