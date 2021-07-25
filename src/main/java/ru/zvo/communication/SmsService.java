package ru.zvo.communication;

public class SmsService {

    private static final String MESSAGE_PATTERN = "Sent SMS to subscriber[%s] with content[%s].\n";
    private static SmsService instance;

    private SmsService() {

    }

    public static SmsService getInstance() {
        if (instance == null) {
            instance = new SmsService();
        }
        return instance;
    }

    public void sendSms(String phoneTo, String content) {
        System.out.printf(MESSAGE_PATTERN, phoneTo, content);
    }

}
