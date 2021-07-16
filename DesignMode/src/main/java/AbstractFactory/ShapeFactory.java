package AbstractFactory;

import Utils.Color.Color;
import Utils.Shape.Circle;
import Utils.Shape.Shape;
import Utils.Shape.Square;
import Utils.Shape.Triangle;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String type) {
        if(type.equalsIgnoreCase("circle"))
            return new Circle();
        if(type.equalsIgnoreCase("square"))
            return new Square();
        if(type.equalsIgnoreCase("Triangle"))
            return new Triangle();
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
