package edu.diplom.agronomistadviser.adapter.driven.notification.email;

public record EmailDetails(
        String recipient,
        String subject,
        String msgBody
//        String attachment
) {
}
