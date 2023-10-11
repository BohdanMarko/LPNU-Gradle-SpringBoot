package com.textanalyzer.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.textanalyzer.root.model.TextAnalysisModel;

@Controller
public class TextAnalysisController {
    private final TextAnalysisModel analysisModel;

    public TextAnalysisController() {
        this.analysisModel = new TextAnalysisModel();
    }

    @GetMapping("/")
    public String index() {
        return "analyze";
    }

    @PostMapping("/analyze")
    public String analyzeText(@RequestParam("text") String text, Model model) {
        analysisModel.analyzeText(text);
        analysisModel.setInputText(text);
        model.addAttribute("wordCounts", analysisModel.getWordCounts());
        model.addAttribute("inputText", analysisModel.getInputText());
        return "analyze";
    }
}
