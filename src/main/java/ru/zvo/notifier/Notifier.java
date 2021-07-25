package ru.zvo.notifier;

import ru.zvo.clients.Client;
import ru.zvo.commands.Command;

public class Notifier {

    public void notifyClient(Client client, Command command) {
        command.execute(client);
    }

}
