import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Email {

	public static void main(String[] args) {
		
		if(args.length > 1) {
			try {
				sendEmail(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
		
	@SuppressWarnings("deprecation")
	public static void sendEmail(String hostName, String portStr, String to, String from, String name, String subject, String msg, String user, String pass) throws EmailException {
		
		int port = Integer.parseInt(portStr);
		
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(hostName);  
			email.setSmtpPort(port);  
			email.addTo(to);
			
			email.setFrom(from, name); 
			
			email.setSubject(subject);
			
			email.setHtmlMsg(msg);
			
			email.setSSL(true);
			email.setAuthentication(user, pass);
			
			email.send();
			
			System.out.println("ok!");
			
		} catch (Exception e) {
			System.out.println("Erro!");
	        e.printStackTrace();
	    }
	
		
	}

}
