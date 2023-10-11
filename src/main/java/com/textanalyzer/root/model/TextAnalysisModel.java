package com.textanalyzer.root.model;

import java.util.*;
import java.util.stream.Collectors;

public class TextAnalysisModel {
    private Map<String, Long> wordCounts;
    private String inputText;

    public Map<String, Long> getWordCounts() {
        return wordCounts;
    }

    public void analyzeText(String text) {
        String[] words = text.split("\\W+");
        this.wordCounts = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }
}
