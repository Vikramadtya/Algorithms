package org.experiment;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {
    public static Path RESULTS_DIR = Paths.get(System.getProperty("user.dir"),"src", "main","resources").toAbsolutePath();
    public static Path FILE_NAME=Paths.get(System.getProperty("user.dir"),"src", "main","resources","Arrays.txt").toAbsolutePath();
}
