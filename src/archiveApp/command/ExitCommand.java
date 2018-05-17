package archiveApp.command;


import archiveApp.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("See you next time!");
    }
}
