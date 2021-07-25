package ru.zvo.communication;

import java.io.File;

public class EmailService {

    private static final String MESSAGE_PATTERN = "Sent Email to subscriber[%s] with file[%s].\n";
    private static EmailService instance;

    private EmailService() {

    }

    public static EmailService getInstance() {
        if (instance == null) {
            instance = new EmailService();
        }
        return instance;
    }

    public void sendEmail(String mailTo, File file) {
        System.out.printf(MESSAGE_PATTERN, mailTo, file.getName());
    }

}
