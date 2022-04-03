package by.epam.efimchik.Information_handling.reader;

import by.epam.efimchik.Information_handling.exception.CompositeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public String readFile(String path) throws CompositeException {
        StringBuilder text = new StringBuilder();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            bufferedReader.lines().forEach(s -> text.append(s).append("\n"));
        } catch (IOException e) {
            throw new CompositeException("Error during reading file!", e);
        } catch (NullPointerException e){
            throw new CompositeException("File is empty!", e);
        }
        return text.toString();
    }
}
