package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileManipulator {
    //имя файла с данными в properties
    //String request = "ellipse.base" - исходные данные
    //String request = "test.ellipse.base" - тестовые данные
    //String request = "registrars.base" - база всех регистраторов эллипсов с параметрами

    private static FileManipulator instance = new FileManipulator();

    private FileManipulator() {
    }

    public static FileManipulator getInstance() {
        return instance;
    }


    public List<String> extractEntriesFromFile(String request) throws DAOexception {
        String path = getFileAddress(request);

        EllipseDataValidator instance = EllipseDataValidator.getInstance();
        List<String> aLLEntries = new ArrayList<>();

        String entry;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((entry = bufferedReader.readLine()) != null) {
                if (instance.isValidFormat(entry)) {
                    aLLEntries.add(entry);
                }
            }
        } catch (NullPointerException | IOException | DAOexception e) {
            throw new DAOexception("FileManipulator: extractEntriesFromFile(): " + e.getMessage());
        }
        return aLLEntries;
    }

    private void cleanFile(String request) throws DAOexception {
        String path = getFileAddress(request);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("");
        } catch (IOException e) {
            throw new DAOexception("FileManipulator: cleanFile(): " + e.getMessage());
        }
    }

    public void addEntry(String request, String entry) throws DAOexception {
        String path = getFileAddress(request);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.write(entry + "\n");

        } catch (IOException e) {
            throw new DAOexception("FileManipulator: addEntry(): " + e.getMessage());
        }
    }

    public void deleteFromBase(String request, int id) throws DAOexception {
        EllipseParser instance = EllipseParser.getInstance();
        String path;
        List<String> base;

        int index = 0;

        try {
            path = getFileAddress(request);
            base = extractEntriesFromFile(path);

            for (int i = 0; i < base.size(); i++) {
                String entry = base.get(i);
                int idFromEntry = instance.parseId(entry);
                if (idFromEntry == id) {
                    index = i;
                }
            }
            base.remove(index);

            cleanFile(path);

            for (String s : base) {
                addEntry(path, s);
            }

        } catch (RuntimeException | DAOexception e) {
            throw new DAOexception("FileManipulator: deleteFromBase(): " + e.getMessage());
        }
    }


    private String getFileAddress(String request) throws DAOexception {
        Properties property = new Properties();
        String response;

        try (FileInputStream fis = new FileInputStream("src/main/resources/prop.properties")) {
            property.load(fis);

            response = property.getProperty(request);

        } catch (IOException e) {
            throw new DAOexception("FileManipulator: getFileAddress(): property file is not found. " + e.getMessage());
        }
        return response;
    }

}