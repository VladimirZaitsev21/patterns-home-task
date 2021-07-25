package ru.zvo.app;

import ru.zvo.clients.Client;
import ru.zvo.commands.Command;
import ru.zvo.commands.EmailCommand;
import ru.zvo.commands.SmsCommand;
import ru.zvo.notifier.Notifier;

import java.io.File;

public class App {

    public static final String FORM_URL = "https://credit-form.ru";
    public static final String FORM_PDF = "CreditForm.pdf";

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        Client client1 = new Client("John", "89209708134", "vlzaitsev2000@gmail.com");
        Client client2 = new Client("Michael", "89542434242", "michael@gmail.com");
        Client client3 = new Client("Ann", "89209876534", "ann2048@mail.ru");
        Notifier notifier = new Notifier();
        runSmsMode(client1, notifier);
        runEmailMode(client2, notifier);
        runSmsAndEmailMode(client3, notifier);
    }

    private void runSmsMode(Client client, Notifier notifier) {
        Command smsCommand = new SmsCommand(FORM_URL);
        System.out.println("------------------1) Режим SMS----------------------");
        notifier.notifyClient(client, smsCommand);
    }

    private void runEmailMode(Client client, Notifier notifier) {
        Command emailCommand = new EmailCommand(new File(FORM_PDF));
        System.out.println("------------------2) Режим Email---------------------");
        notifier.notifyClient(client, emailCommand);
    }

    private void runSmsAndEmailMode(Client client, Notifier notifier) {
        Command smsCommand = new SmsCommand(FORM_URL);
        Command emailCommand = new EmailCommand(new File(FORM_PDF));
        smsCommand.setNextCommand(emailCommand);
        System.out.println("------------------3) Режим SMS и Email----------------");
        notifier.notifyClient(client, smsCommand);
    }

}
