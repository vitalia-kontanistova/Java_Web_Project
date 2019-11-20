package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileInfoExtractor {
    private static FileInfoExtractor instance = new FileInfoExtractor();

    private FileInfoExtractor() {
    }

    public static FileInfoExtractor getInstance() {
        return instance;
    }

    public List<String> extractEntriesFromFile(String request) throws DAOexception {
        //имя файла с данными в файле properties
        //String request = "ellipse.base" - исходные данные
        //String request = " test.ellipse.base" - тестовые данные

        EllipseDataValidator instance = EllipseDataValidator.getInstance();
        List<String> aLLEntries = new ArrayList<>();

        String entry;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileAddress(request)))) {
            while ((entry = bufferedReader.readLine()) != null) { //сделать более топорно input/outputStream - может пригодиться на собеседовании
                if (instance.isValidFormat(entry)) {
                    aLLEntries.add(entry);
                }
            }
        } catch (IOException | DAOexception e) {
            throw new DAOexception("FileInfoExtractor: extractEntriesFromFile(): " + e.getMessage());
        }
        return aLLEntries;
    }

    private String getFileAddress(String request) throws DAOexception {
        Properties property = new Properties();
        String response;

        try (FileInputStream fis = new FileInputStream("src/main/resources/prop.properties")) {
            property.load(fis);

            response = property.getProperty(request);

        } catch (IOException e) {
            throw new DAOexception("FileInfoExtractor: getFileAddress(): property file is not found. " + e.getMessage());
        }
        return response;
    }

}