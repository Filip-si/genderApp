package com.detect.genderApp.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService{

    public List<String> processInputFile(String inputFilePath) {
        List<String> inputList = new ArrayList<>();

        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = null;
            try {
                inputFS = new FileInputStream(inputF);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }

}
