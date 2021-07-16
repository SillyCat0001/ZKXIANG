package Factory;

import Utils.Shape.Circle;
import Utils.Shape.Shape;
import Utils.Shape.Square;
import Utils.Shape.Triangle;


//工厂模式
public class ShapeFactory{

    public static Shape getShape(String type){
        if(type.equalsIgnoreCase("circle"))
            return new Circle();
        if(type.equalsIgnoreCase("square"))
            return new Square();
        if(type.equalsIgnoreCase("Triangle"))
            return new Triangle();
        return null;
    }

}