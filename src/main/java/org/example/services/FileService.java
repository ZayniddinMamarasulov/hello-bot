package org.example.services;

import java.util.List;

public interface FileService {

    void writeFile(String text);

    List<String> readFile();
}
