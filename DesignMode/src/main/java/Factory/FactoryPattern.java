package Factory;

//工厂模式
//同一类产品可以随时增加，而不用修改工厂代码

public class FactoryPattern {
    public static void main(String... args){
        ShapeFactory.getShape("circle").draw();
        ShapeFactory.getShape("square").draw();
        ShapeFactory.getShape("Triangle").draw();
    }
}
