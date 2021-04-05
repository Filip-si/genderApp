package com.detect.genderApp.controller;

import com.detect.genderApp.service.FileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/name")
public class NameController {


    @GetMapping(value = "/males")
    @ResponseBody
    public List<String> getMaleList(){
        FileService fs = new FileService();
        List<String> males = fs.processInputFile("src\\main\\resources\\male.csv");
        return males;
    }

    @GetMapping(value = "/females")
    @ResponseBody
    public List<String> getFemaleList(){
        FileService fs = new FileService();
        List<String> females = fs.processInputFile("src\\main\\resources\\female.csv");
        return females;
    }

}
