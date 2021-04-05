package com.detect.genderApp.controller;

import com.detect.genderApp.service.AlgorithmFirst;
import com.detect.genderApp.service.AlgorithmSecond;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {

    @PostMapping("/first/{givenName}")
    public String algorithmFirst(@PathVariable("givenName") String givenName){
        AlgorithmFirst algorithmFirst = new AlgorithmFirst();
        String gender = algorithmFirst.detectNameByAlgorithmFirst(givenName).getTokenName();
        return gender;
    }

    @PostMapping("/second/{givenName}")
    public String algorithmSecond(@PathVariable("givenName") String givenName){
        AlgorithmSecond algorithmSecond = new AlgorithmSecond();
        String gender = algorithmSecond.detectNameBasedAllTokens(givenName).getTokenName();
        return gender;
    }
}
