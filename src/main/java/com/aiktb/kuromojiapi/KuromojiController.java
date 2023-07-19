package com.aiktb.kuromojiapi;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tokenizer")
public class KuromojiController {
    private final Tokenizer tokenizer;

    public KuromojiController() {
        this.tokenizer = new Tokenizer();
    }

    @PostMapping("/")
    public List<Token> getUser(@RequestParam(value = "text") String text) {
        return tokenizer.tokenize(text);
    }

}
