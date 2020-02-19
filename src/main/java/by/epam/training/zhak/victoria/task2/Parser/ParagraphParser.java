package by.epam.training.zhak.victoria.task2.Parser;
import  by.epam.training.zhak.victoria.task2.Entity.Component;
import by.epam.training.zhak.victoria.task2.Entity.ComponentType;
import by.epam.training.zhak.victoria.task2.Entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ParagraphParser extends Parser {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String SPLIT_SENTENCES_REGEXP = "(?<=[.{1}!?\\t])\\s";
    private Parser successor;

    public ParagraphParser(Parser successor) {
        this.successor = successor;
    }

    @Override
    public Component parse(String paragraph) {
        List<String> sentences = getSentences(paragraph);
        Component component = new TextComponent(ComponentType.PARAGRAPH);
        for (String o : sentences) {
            Component sentence = successor.parse(o);
            component.addComponent(sentence);
        }
        LOGGER.info("Paragraph was parsed on sentences");
        return component;
    }

    private List<String> getSentences(String paragraph) {
        String[] sentencesArray = paragraph.split(SPLIT_SENTENCES_REGEXP);
        List<String> allSentences = Arrays.asList(sentencesArray);
        return allSentences;
    }
}