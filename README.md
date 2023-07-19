# Kuromoji-API

Kuromoji RESTful API endpoint service.

## API

```yaml
title: Kuromoji API
baseUri: https://api.aiktb.com/tokenizer
/:
  post:
    text: string
```

## Example

### Input

```bash
POST https://api.aiktb.com/tokenizer/?text=寿司
```

### Output

```JSON
[
  {
    "surface": "寿司",
    "position": 0,
    "baseForm": "寿司",
    "conjugationType": "*",
    "conjugationForm": "*",
    "partOfSpeechLevel1": "名詞",
    "partOfSpeechLevel2": "一般",
    "partOfSpeechLevel4": "*",
    "partOfSpeechLevel3": "*",
    "reading": "スシ",
    "pronunciation": "スシ",
    "known": true,
    "user": false,
    "allFeatures": "名詞,一般,*,*,*,*,寿司,スシ,スシ",
    "allFeaturesArray": [
      "名詞",
      "一般",
      "*",
      "*",
      "*",
      "*",
      "寿司",
      "スシ",
      "スシ"
    ]
  }
]
```