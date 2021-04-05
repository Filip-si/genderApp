package com.detect.genderApp.service;

import com.detect.genderApp.model.Token;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmSecond {
    FileService op = new FileService();
    public List<String> male = op.processInputFile("src\\main\\resources\\male.csv");
    public List<String> female = op.processInputFile("src\\main\\resources\\female.csv");

    public Token detectNameBasedAllTokens(String name){
        Token token = new Token();
        name = name.toLowerCase();
        String arr[] = name.split(" ");
        int malePoint = 0, femalePoint = 0, inconclusivePoint = 0;

        if(arr.length == 1){

            if(male.contains(arr[0])){
                token.setTokenName("MALE");
            }else if(female.contains(arr[0])){
                token.setTokenName("FEMALE");
            }else if(!male.contains(arr[0]) && !female.contains(arr[0])){
                token.setTokenName("INCONCLUSIVE");
            }

        }else {

            for (int count = 0; count < arr.length; count++) {
                if (male.contains(arr[count])) {
                    malePoint++;
                } else if (female.contains(arr[count])) {
                    femalePoint++;
                } else {
                    inconclusivePoint++;
                }
            }

            if(malePoint == femalePoint ||
                    (malePoint == inconclusivePoint && femalePoint == inconclusivePoint) ||
                    (femalePoint == inconclusivePoint && malePoint < femalePoint) ||
                    (malePoint == inconclusivePoint && femalePoint < malePoint)){
                token.setTokenName("INCONCLUSIVE");
            }else if(malePoint > femalePoint &&
                    malePoint > inconclusivePoint){
                token.setTokenName("MALE");
            }else if(femalePoint > malePoint &&
                    femalePoint > inconclusivePoint){
                token.setTokenName("FEMALE");
            }

        }
        return token;
    }
}
