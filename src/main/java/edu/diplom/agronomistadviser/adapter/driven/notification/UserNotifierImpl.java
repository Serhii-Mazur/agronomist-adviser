package edu.diplom.agronomistadviser.adapter.driven.notification;

import edu.diplom.agronomistadviser.adapter.driven.notification.email.EmailDetails;
import edu.diplom.agronomistadviser.application.port.notification.UserNotifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserNotifierImpl implements UserNotifier {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public UserNotifierImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @Async
    public CompletableFuture<Boolean> sendMail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(emailDetails.recipient());
            message.setSubject(emailDetails.subject());
            message.setText(emailDetails.msgBody());
            mailSender.send(message);

            return CompletableFuture.completedFuture(true);
        } catch (Exception e) {

            return CompletableFuture.completedFuture(false);
        }

    }
}
