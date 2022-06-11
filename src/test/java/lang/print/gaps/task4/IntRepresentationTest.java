package lang.print.gaps.task4;

import base.BaseIOTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class IntRepresentationTest extends BaseIOTest {

    @Test
    void mainPrintToConsoleExpected() throws IOException {
        Path path = Paths.get("src/main/java/lang/print/gaps/task4/IntRepresentation.java");
        List<String> strings = Files.readAllLines(path);
        List<String> charC = strings.stream().filter(line -> line.contains("99")).collect(Collectors.toList());
        List<String> charH = strings.stream().filter(line -> line.contains("104")).collect(Collectors.toList());
        List<String> charA = strings.stream().filter(line -> line.contains("97")).collect(Collectors.toList());
        List<String> charR = strings.stream().filter(line -> line.contains("114")).collect(Collectors.toList());

        assertEquals(1, charC.size());
        assertEquals(1, charH.size());
        assertEquals(1, charA.size());
        assertEquals(1, charR.size());
    }
}