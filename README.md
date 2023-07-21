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
    "word_position": 0,
    "surface_from": "寿司",
    "reading": "スシ"
  }
]
```