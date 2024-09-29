package md.electro.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.electro.service.CsvService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsvServiceImpl implements CsvService {


    @Override
    public void importFile() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("/home/eughen/Downloads/Archive_data_for_period_2024-09-28_033100_-_2024-09-29_031601.csv"))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
