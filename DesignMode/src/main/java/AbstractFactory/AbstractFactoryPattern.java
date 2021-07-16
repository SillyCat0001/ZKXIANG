package AbstractFactory;
import Utils.Color.Color;
import Utils.Shape.Shape;

//抽象工厂模式：工厂的工厂
//这里的例子是一个图形程序，一个图形有两种元素组成：形状和颜色。
//形状由形状工厂创建，颜色由颜色工厂创建
//图形工厂则由一个形状工厂和一个颜色工厂组成。

class Graph{
    private Shape shape;
    private Color color;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(){
        System.out.println("==========");
        shape.draw();
        color.fill();
        System.out.println("==========");
    }
}


public class AbstractFactoryPattern {

    private static final AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
    private static final AbstractFactory colorFactory = FactoryProducer.getFactory("Color");

    public  static void createGraph(String shape, String color){
        Graph graph = new Graph();
        graph.setShape(shapeFactory.getShape(shape));
        graph.setColor(colorFactory.getColor(color));
        graph.paint();
    }

    public static void main(String... args){
        createGraph("circle", "red");
        createGraph("square", "blue");
        createGraph("triangle", "yellow");
    }
}
