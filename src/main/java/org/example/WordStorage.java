package org.example;

import java.util.Arrays;
import java.util.List;

public class WordStorage {
    private List<String> words;
    private List<String> questions;

    public WordStorage(){
        this.words = Arrays.asList(
                "человек",
                "страна",
                "ребенок",
                "земля",
                "гагарин",
                "программист",
                "президент",
                "джуниор",
                "питон",
                "виселица"
        );
        this.questions = Arrays.asList(
                "Самое развитое существо на планете земля",
                "Территория, имеющая политические, физико-географические, культурные или исторические границы",
                "Маленький человек",
                "Как называется наша планета",
                "Фамилия первого человека полетевшего в космос",
                "Человек который разрабатывает программы",
                "Самый главный человек в государстве",
                "Как называется начальная позиция программиста",
                "Язык программирования который называется как змея",
                "Как называется эта игра"
        );
    }

    public List<String> getWords(){
        return this.words;
    }

    public List<String> getQuestions(){
        return this.questions;
    }
}
