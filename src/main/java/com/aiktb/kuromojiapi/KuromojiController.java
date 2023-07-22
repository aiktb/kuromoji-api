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
    public List<KuromojiToken> tokenize(@RequestBody Text text) {
        return tokenizer.tokenize(text.text).stream().map(KuromojiToken::new).toList();
    }

    // Temporary measures: kuromoji.js has a typo, "from"->"form"
    record KuromojiToken(int word_position, String surface_form, String reading) {
        public KuromojiToken(Token token) {
            this(token.getPosition() + 1, token.getSurface(), token.getReading());
        }
    }
    record Text(String text) {}
}
