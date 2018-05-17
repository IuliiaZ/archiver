package archiveApp.command;

import archiveApp.ConsoleHelper;
import archiveApp.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Enter the full path of the archive file:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}