package archiveApp;

import archiveApp.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) throws IOException {

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("You have not selected an archive file or selected the wrong file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error has occurred. Check the entered data.");
            }

        } while (operation != Operation.EXIT);
    }


    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Select an operation:");
        ConsoleHelper.writeMessage(String.format("\t %d - pack files into the archive", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - add a file to the archive", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - delete file from archive", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - unpack archive", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - view archive contents", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - exit", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}