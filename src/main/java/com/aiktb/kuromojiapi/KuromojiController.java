package com.aiktb.kuromojiapi;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KuromojiController {
    private final Tokenizer tokenizer;

    public KuromojiController() {
        this.tokenizer = new Tokenizer();
    }

    @PostMapping("/tokenizer")
    public List<List<KuromojiToken>> tokenize(@RequestBody RequestBodyData textArray) {
        return textArray.arrayData().stream().map(tokenizer::tokenize).map(tokenList -> tokenList.stream().map(KuromojiToken::new).toList()).toList();
    }

    record KuromojiToken(int word_position, String surface_from, String reading) {
        public KuromojiToken(Token token) {
            this(token.getPosition() + 1, token.getSurface(), token.getReading());
        }
    }

    record RequestBodyData(List<String> arrayData) {
    }
}
