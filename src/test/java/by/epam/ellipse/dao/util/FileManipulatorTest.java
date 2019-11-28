package by.epam.ellipse.dao.util;

import by.epam.ellipse.dao.exception.DAOexception;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class FileManipulatorTest {
    private static FileManipulator instance;
    private static String request;
    private static List<String> expected;

    @Before
    public void setUp() {
        instance = FileManipulator.getInstance();

        expected = new ArrayList<>();
        expected.add("-1.0 -2.0 5.0 6.0");
        expected.add("10.0 0.0 10.0 0.0");
        expected.add("-10.0 -10.0 10.0 10.0");
        expected.add("10.0 5.0 15.0 10.0");
    }

    @After
    public void shutDown() {
        instance = null;
        expected = null;
    }

    @Test
    public void extractEntriesFromFile() {
        request = "test.ellipse.base";
        List<String> actual;
        try {
            actual = instance.extractEntriesFromFile(request);
            Assert.assertEquals(expected, actual);
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void extractEntriesFromFile_INWALID_REQUEST() {
        request = "test1.ellipse.base";
        try {
            instance.extractEntriesFromFile(request);
            Assert.fail("Expected DAOexception.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void extractEntriesFromFile_EMPTY_REQUEST() {
        request = "";
        try {
            instance.extractEntriesFromFile(request);
            Assert.fail("Expected DAOexception.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void extractEntriesFromFile_NULL() {
        try {
            instance.extractEntriesFromFile(null);
            Assert.fail("Expected DAOexception.");
        } catch (DAOexception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}