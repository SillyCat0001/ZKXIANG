package Decorator;

import Utils.Shape.Circle;
import Utils.Shape.Shape;

//想让shape的draw多做点别的事，但又不想修改shape类
//要想实现这个首先你要新建一个类，并且采用组合的方法将shape对象作为一个新类的成员变量
//并且新类也要与shape一样有相同的行为，那么就需要implement shape接口，那么这就是一个装饰器的原型
//通过继承这个装饰器原型，那就自己就可以随便定义怎么装饰shape对象


public class Demo {
    public static void main(String... args){
        Shape circle = new Circle();
        ShapeDecorator redCircle =  new RedShapeDecorator(circle);
        redCircle.draw();
    }
}
