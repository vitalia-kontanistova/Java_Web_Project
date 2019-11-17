package by.epam.ellipse.service.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileManipulator {
    private static final FileManipulator instance = new FileManipulator();
    private FileManipulator() {
    }
    public static FileManipulator getInstance() {
        return instance;
    }

    public String getFileAddress(String request) throws IOException {
        Properties property = new Properties();
        FileInputStream fis = null;
        String response;

        try {
            fis = new FileInputStream("src/main/resources/prop.properties");
            property.load(fis);

            response = property.getProperty(request);

        } catch (IOException e) {
            throw new IOException("FileManipulator: getFileAddress(): property file is not found" + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new IOException("FileManipulator: getFileAddress(): close thread problem; " + e.getMessage());
            }
        }
        return response;
    }

    public List<String> extractAllEntries(String path) throws IOException {
        List<String> base = new ArrayList<>();
        String entry;

        BufferedReader bufferedReader = null;
        FileReader fileReader;

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            while ((entry = bufferedReader.readLine()) != null) {
                base.add(entry);
            }

        } catch (IOException e) {
            throw new IOException("FileManipulator: extractAllEntries(): " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                throw new IOException("FileManipulator: extractAllEntries(): thread close problem; " + e.getMessage());
            }
        }
        return base;
    }
}
