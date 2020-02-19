package by.epam.training.zhak.victoria.task2.Parser;

import by.epam.training.zhak.victoria.task2.Entity.Component;
import by.epam.training.zhak.victoria.task2.Entity.TextComponent;
import by.epam.training.zhak.victoria.task2.Entity.Lexeme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.zhak.victoria.task2.Entity.ComponentType.*;

public class SentenceParser extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String SPLIT_ON_THE_LEXEME = "\\s(?=([\\w\\[]))";
    private static final String EXPRESSION_REGEXP = "(?<=\\[)[\\s\\d+*-/&]*(?=\\])";

    private Component getLexemes(List<String> allLexemes){
        Component component = new TextComponent(SENTENCE);
        for (String o : allLexemes) {
            component.addComponent(createLexeme(o));
        }
        return component;
    }

    private Component createLexeme(String lexeme) {
        Pattern paragraphPattern = Pattern.compile(EXPRESSION_REGEXP);
        Matcher matcher = paragraphPattern.matcher(lexeme);
        if (matcher.find()) {
            return new Lexeme(lexeme, EXPRESSION);
        } else{

            return new Lexeme(lexeme, WORD);
        }
    }

    @Override
    public Component parse(String inputData) {
        String[] allLexemes = inputData.split(SPLIT_ON_THE_LEXEME);
        List<String> listLexemes = Arrays.asList(allLexemes);
        LOGGER.info("Sentence was parsed on lexemes");
        return getLexemes(listLexemes);
    }
}
