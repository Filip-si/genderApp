package com.detect.genderApp.service;

import com.detect.genderApp.model.Token;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmFirst {
    FileService op = new FileService();
    public List<String> male = op.processInputFile("src\\main\\resources\\male.csv");
    public List<String> female = op.processInputFile("src\\main\\resources\\female.csv");

    public Token detectNameByAlgorithmFirst(String name){
        Token token = new Token();
        name = name.toLowerCase();
        String arr[] = name.split(" ");
        if(!female.contains(arr[0]) || !male.contains(arr[0]) || name.isEmpty()){
            token.setTokenName("GIVEN NAME NOT FOUND");
        }
        if(female.contains(arr[0])){
            token.setTokenName("FEMALE");
        }else if(male.contains(arr[0])){
            token.setTokenName("MALE");
        }
        return token;
    }


}
