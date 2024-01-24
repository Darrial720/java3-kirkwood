package edu.kirkwood.shared;


import com.azure.communication.email.*;
import com.azure.communication.email.models.*;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import io.github.cdimascio.dotenv.Dotenv;

public class CommunicationService
{
    public static void sendEmail(String emailAddress, String message)
    {
        Dotenv dotenv = Dotenv.load();
        String connectionString = dotenv.get("Email_CONNECTION");
        EmailClient emailClient = new EmailClientBuilder().connectionString(connectionString).buildClient();

        EmailAddress toAddress = new EmailAddress(emailAddress);

        EmailMessage emailMessage = new EmailMessage()
                .setSenderAddress(dotenv.get("Mail_FROM"))
                .setToRecipients(toAddress)
                .setSubject("Testing Azure Email")
                .setBodyPlainText("Hello world via Azure email.");

        SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(emailMessage, null);
        PollResponse<EmailSendResult> result = poller.waitForCompletion();
    }
}

