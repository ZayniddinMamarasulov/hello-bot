package org.example.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {

    File file;

    public FileServiceImpl(File file) {
        this.file = file;
    }

    @Override
    public void writeFile(String text) {

        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(text + "\n");
            fileWriter.close();
            System.out.println("SUCCESS");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<String> readFile() {
        List<String> stringList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                stringList.add(s);
            }
        } catch (Exception e) {

        }

        return stringList;
    }
}
