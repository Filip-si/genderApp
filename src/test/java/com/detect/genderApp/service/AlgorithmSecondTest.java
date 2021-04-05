package com.detect.genderApp.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlgorithmSecondTest {

    @Test
    void shouldGive_Male(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("adam artur alan ania ola xyz yzx").getTokenName();

        //then
        assertThat(output).isEqualTo("MALE");
    }

    @Test
    void shouldGiveSingle_Male(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("adam").getTokenName();

        //then
        assertThat(output).isEqualTo("MALE");
    }

    @Test
    void shouldGive_Female(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("adam artur aga ania ola xyz yzx").getTokenName();

        //then
        assertThat(output).isEqualTo("FEMALE");
    }

    @Test
    void shouldGiveSingle_Female(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("ania").getTokenName();

        //then
        assertThat(output).isEqualTo("FEMALE");
    }

    @Test
    void shouldGive_Inconclusive(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("adam artur aga ania xzy xyz yzx").getTokenName();

        //then
        assertThat(output).isEqualTo("INCONCLUSIVE");
    }

    @Test
    void shouldGiveSingle_Inconclusive(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("unknown").getTokenName();

        //then
        assertThat(output).isEqualTo("INCONCLUSIVE");
    }

    @Test
    void shouldGiveLowerAndUpperCase_Male(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("AndrzEJ").getTokenName();

        //then
        assertThat(output).isEqualTo("MALE");
    }

    @Test
    void shouldGiveEmpty_Male(){
        //given
        AlgorithmSecond a = new AlgorithmSecond();
        a.female = List.of("ania","ola","aga","ala");
        a.male = List.of("adam","artur","alan","andrzej");

        //when
        String output = a.detectNameBasedAllTokens("AndrzEJ").getTokenName();

        //then
        assertThat(output).isEqualTo("MALE");
    }


}

