package Decorator;

import Utils.Shape.Shape;

public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape shape){
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedColor(shape);
    }

    private void setRedColor(Shape shape){
        System.out.println("color: red");
    }
}
