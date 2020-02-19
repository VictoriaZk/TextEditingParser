package by.epam.training.zhak.victoria.task2.Entity;

import java.util.List;

public interface Component {
    boolean addComponent(Component component);
    Component getComponent(int index);
    int getComponentSize();
    ComponentType getComponentType();
    List<Component> getChildrenComponent();
}
