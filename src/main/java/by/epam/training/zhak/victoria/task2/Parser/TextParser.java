package by.epam.training.zhak.victoria.task2.Parser;

import by.epam.training.zhak.victoria.task2.Entity.Component;
import by.epam.training.zhak.victoria.task2.Entity.ComponentType;
import by.epam.training.zhak.victoria.task2.Entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class TextParser extends Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SPLIT_ON_PARAGRAPHS_REGEXP = "\\t|\\s{4}";
    private Parser successor;

    public TextParser(Parser successor){
        this.successor = successor;
    }


    @Override
    public Component parse(String text) {

        String[] arrOfParagraphs = text.split(SPLIT_ON_PARAGRAPHS_REGEXP);
        List<String> listParagraphs = Arrays.asList(arrOfParagraphs);
        TextComponent textComponent = new TextComponent(ComponentType.TEXT);
        listParagraphs.stream().forEach( o-> {
            Component paragraph = successor.parse(o);
            textComponent.addComponent(paragraph);
        });
        LOGGER.info("Text parsed to paragraphs");
        return textComponent;
    }
}
