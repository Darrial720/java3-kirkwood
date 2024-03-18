package edu.kirkwood.shared;


import com.azure.communication.email.*;
import com.azure.communication.email.implementation.models.ErrorResponseException;
import com.azure.communication.email.models.*;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.http.HttpServletRequest;

public class CommunicationService
{
    public static void main(String[] args){
        sendEmail("darryl", "Testing", "Testing again");
    }
    private static EmailClient createEmailClient() {
        Dotenv dotenv = Dotenv.load();
        String connectionString = dotenv.get("Email_CONNECTION");
        EmailClient emailClient = new EmailClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        return emailClient;
    }

    public static String sendNewUserEmail(String email, String code){
        String subject = "LearnX New User";
        String message = "<h2>Welcome to LearnX</h2>";
        message += "<p>Please enter code <b>" + code + "</b> on the website to activate your account</p>";
        boolean sent = CommunicationService.sendEmail(email, subject, message);
        // To do: If the email is not send, delete the user by email and delete the 2fa
        return sent ? code : "";
    }

    public static String sendNewUserEmail2(String email, String code){
        String subject = "DBZ Game New User";
        String message = "<h2>Welcome to the DragonBallZ Game website!</h2>";
        message += "<p>Please enter code <b>" + code + "</b> on the website to activate your account</p>";
        boolean sent = CommunicationService.sendEmail(email, subject, message);
        // To do: If the email is not send, delete the user by email and delete the 2fa
        return sent ? code : "";
    }

    public static Boolean sendPasswordResetEmail(String email, String uuid, HttpServletRequest req){
        String subject = "LearnX Reset Password";
        String message = "<h2>LearnX Reset Password</h2>";
        //To do: add a message saying that the link expires in 30 minutes
        message += "<p>Please use this link to securely reset your password.</p>";
        String appURL;
        if(req.isSecure()){
            appURL = req.getServletContext().getInitParameter("appURLCloud");
        }
        else {
            appURL = req.getServletContext().getInitParameter("appURLLocal");
        }
        String fullURL = String.format("%s/new-password?token=%s", appURL, uuid);
        message += String.format("<p><a href=\"%s\" target= \"_blank\"></a></p>", fullURL, fullURL);
        message += "<p>If you did not request to reset your password you can ignore this message, your password will not be changed.</p>";
        boolean sent = CommunicationService.sendEmail(email, subject, message);
        // To do: If the email is not send, delete the user by email and delete the 2fa
        return sent;
    }

    public static boolean sendEmail(String toEmailAddress, String subject, String message)    {
        try {
            EmailClient emailClient = createEmailClient();

            EmailAddress toAddress = new EmailAddress(toEmailAddress);

            EmailMessage emailMessage = new EmailMessage()
                    .setSenderAddress(Dotenv.load().get("Mail_FROM"))
                    .setToRecipients(toAddress)
                    .setSubject(subject)
                    .setBodyHtml(message);

            SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(emailMessage, null);
            PollResponse<EmailSendResult> result = poller.waitForCompletion();
            return true;
        }
        catch(ErrorResponseException e){
            System.err.println(e.getMessage());
            return false;
        }
    }
}

