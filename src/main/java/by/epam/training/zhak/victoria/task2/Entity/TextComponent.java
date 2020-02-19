package by.epam.training.zhak.victoria.task2.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComponent implements Component {

    private List<Component> components = new ArrayList<>();
    private ComponentType type;

    public TextComponent(ComponentType type) {
        this.type = type;
    }

    @Override
    public boolean addComponent(Component component) {
        return components.add(component);
    }

    @Override
    public Component getComponent(int index) {
        return components.get(index);
    }

    @Override
    public int getComponentSize() {
        return components.size();
    }

    @Override
    public ComponentType getComponentType() {
        return type;
    }

    @Override
    public List<Component> getChildrenComponent() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComponent that = (TextComponent) o;
        return components.equals(that.components) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        int hashCode = type.hashCode();
        for(Component component : components){
            hashCode += component.hashCode() * 31;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return "TextComponent{" +
                "components=" + components +
                ", type=" + type +
                '}';
    }
}
