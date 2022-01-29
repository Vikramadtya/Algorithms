package org.experiment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class FileReader <T,V> {
    public void readLineAndCall(Path filePath , Consumer<String> function) {
        try (Stream<String> stream = Files.lines(filePath)) {
            stream.forEach(function::accept);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendToFile(Path path, String obj) throws IOException {
        PrintWriter out = null;
        try (FileWriter fstream = new FileWriter(path.toString() , true)) {
            out = new PrintWriter(fstream);
            out.write(obj +"\n");
        } catch (IOException e) {
            e.printStackTrace();
//        }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
