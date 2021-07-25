package ru.zvo.commands;

import ru.zvo.clients.Client;

import java.io.File;

public interface Command {

    void execute(Client client);

    void setNextCommand(Command command);

}
