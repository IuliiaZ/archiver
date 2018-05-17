package archiveApp.command;

import archiveApp.ConsoleHelper;
import archiveApp.FileProperties;
import archiveApp.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("View the contents of the archive.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Archive content:");

        List<FileProperties> files = zipFileManager.getFilesList();
        for (FileProperties file : files) {
            ConsoleHelper.writeMessage(file.toString());
        }

        ConsoleHelper.writeMessage("The contents of the archive have been read.");
    }
}
