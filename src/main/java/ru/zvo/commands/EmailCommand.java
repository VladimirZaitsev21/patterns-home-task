package ru.zvo.commands;

import ru.zvo.clients.Client;
import ru.zvo.communication.EmailService;
import ru.zvo.communication.SmsService;

import java.io.File;

public class EmailCommand implements Command {

    private File formToShow;
    private Command nextCommand;

    public EmailCommand(File formToShow) {
        this.formToShow = formToShow;
    }

    @Override
    public void execute(Client client) {
        EmailService.getInstance().sendEmail(client.getEmailAddress(), formToShow);
        SmsService.getInstance().sendSms(client.getPhoneNumber(), client.getName() + ", please check your mailbox");
        if (nextCommand != null) {
            nextCommand.execute(client);
        }
    }

    @Override
    public void setNextCommand(Command command) {
        nextCommand = command;
    }

}
