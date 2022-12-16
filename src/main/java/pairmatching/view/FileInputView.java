package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputView {

    private static final String FILE_READING_EXCEPTION_MESSAGE = "[ERROR] 파일을 읽는데 오류가 발생했습니다.";

    public List<String> readLinesFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        try {
            return readLines(bufferedReader);
        } catch (IOException e) {
        } finally {
            bufferedReader.close();
        }
        throw new IllegalArgumentException(FILE_READING_EXCEPTION_MESSAGE);
    }

    private List<String> readLines(BufferedReader crewReader) throws IOException {
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = crewReader.readLine();
            if (line == null || line.equals("")) {
                break;
            }
            lines.add(line);
        }
        return lines;
    }
}
