package by.epam.training.zhak.victoria.task2.Entity;

import java.util.List;

public class Lexeme implements Component {
    private String data;
    ComponentType type;

    public Lexeme(String data, ComponentType type) {
        this.data = data;
        this.type = type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean addComponent(Component component) {
        return false;
    }

    @Override
    public Component getComponent(int index) {
        return null;
    }

    @Override
    public int getComponentSize() {
        return 0;
    }

    @Override
    public ComponentType getComponentType() {
        return null;
    }

    @Override
    public List<Component> getChildrenComponent() {
        return null;
    }
}
