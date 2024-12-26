package edu.diplom.agronomistadviser.application.port.notification;

import edu.diplom.agronomistadviser.adapter.driven.notification.email.EmailDetails;

import java.util.concurrent.CompletableFuture;

public interface UserNotifier {
    //    @Async
    CompletableFuture<Boolean> sendMail(EmailDetails emailDetails);
}
