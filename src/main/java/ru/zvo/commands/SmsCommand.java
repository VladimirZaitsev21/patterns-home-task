package ru.zvo.commands;

import ru.zvo.clients.Client;
import ru.zvo.communication.SmsService;

public class SmsCommand implements Command {

    private String message;
    private Command nextCommand;

    public SmsCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(Client client) {
        SmsService.getInstance().sendSms(client.getPhoneNumber(), message);
        if (nextCommand != null) {
            nextCommand.execute(client);
        }
    }

    @Override
    public void setNextCommand(Command command) {
        nextCommand = command;
    }

}
