package lang.print.gaps.task4;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SettingTypesTest {

    @Test
    void mainTestContainsCorrectTypes() throws IOException {
        Path path = Paths.get("src/main/java/lang/print/gaps/task4/SettingTypes.java");
        List<String> strings = Files.readAllLines(path);
        List<String> correctTypesCount = strings.stream()
                .filter(this::containsAnyButInt)
                .collect(Collectors.toList());

        List<String> bytePresent = strings.stream().filter(line -> line.contains("byte")).collect(Collectors.toList());
        List<String> shortPresent = strings.stream().filter(line -> line.contains("short")).collect(Collectors.toList());

        assertEquals(7, correctTypesCount.size());
        assertEquals(1, bytePresent.size());
        assertEquals(1, shortPresent.size());
    }

    private boolean containsAnyButInt(String line) {
        return !line.contains("int") &&
                (
                        line.contains("boolean") || line.contains("long")
                                || line.contains("char") || line.contains("float")
                                || line.contains("double") || line.contains("byte")
                                || line.contains("short")
                );
    }
}