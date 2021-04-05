package com.detect.genderApp.service;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AlgorithmFirstTest {
    @Test
    void shouldGive_FirstName(){
        //given
        AlgorithmFirst a = new AlgorithmFirst();
        a.female = List.of("ania","ola");
        a.male = List.of("adam","olek");

        //when
        String output = a.detectNameByAlgorithmFirst("adam ania olek").getTokenName();

        //then
        assertThat(output).isEqualTo("MALE");
    }

    @Test
    void shouldGive_DifferentFirstName(){
        //given
        AlgorithmFirst a = new AlgorithmFirst();
        a.female = List.of("ania","ola");
        a.male = List.of("adam","olek");
        //when
        String output = a.detectNameByAlgorithmFirst("agnieszka").getTokenName();
        //then
        assertThat(output).isEqualTo("GIVEN NAME NOT FOUND");
    }

    @Test
    void shouldGive_LowerCaseFirstName(){
        //given
        AlgorithmFirst a = new AlgorithmFirst();
        a.female = List.of("ania","ola");
        a.male = List.of("adam","olek");
        //when
        String output = a.detectNameByAlgorithmFirst("ANIA").getTokenName();
        //then
        assertThat(output).isEqualTo("FEMALE");
    }

    @Test
    void shouldGive_EmptyFirstName(){
        //given
        AlgorithmFirst a = new AlgorithmFirst();
        a.female = List.of("ania","ola");
        a.male = List.of("adam","olek");
        //when
        String output = a.detectNameByAlgorithmFirst("").getTokenName();
        //then
        assertThat(output).isEqualTo("GIVEN NAME NOT FOUND");
    }




}



