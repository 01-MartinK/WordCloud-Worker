# WordCloud-Worker
### [Main Component Reference](https://github.com/01-MartinK/WordCloud-Core)

## Worker component
This is the worker component of the wordcloud exercise. This component receives the wordlist and the request from RabbitMQ and then parses the text, after parsing it sends the data to the predefined MySql Server.

## Dependencies
Main dependencies initialized by [spring Initialz](https://start.spring.io/):
* MySQL Driver
* H2
* JPA
* RabbitMQ

Extra dependencies:
* Gson
## Usage
The base Java version for this project is [Java19-Correto](https://github.com/corretto/corretto-19/releases).

git clone this repo `git clone https://github.com/01-MartinK/WordCloud-Worker`.
After that run these commands in it's main root.
```
gradlew build

gradlew bootRun
```

If there is a need for quick easy docker setup.
Check the core part of this exercise [WordCloud-Core](https://github.com/01-MartinK/WordCloud-Core)
