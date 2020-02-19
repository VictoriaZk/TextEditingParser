package by.epam.training.zhak.victoria.task2.Parser;

import by.epam.training.zhak.victoria.task2.Entity.Component;

public abstract class Parser {
    private Parser successor;

    abstract Component parse(String text);

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
