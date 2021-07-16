package AbstractFactory;

import Utils.Color.Color;
import Utils.Shape.Shape;


//抽象工厂模式：工厂的工厂
//不仅可以方便的增加同类产品，还可以增加不同种类的产品。
//这里的例子是一个图形程序，一个图形有两种元素组成：形状和颜色。
//形状由形状工厂创建，颜色由颜色工厂创建
//图形工厂则由一个形状工厂和一个颜色工厂组成。

public abstract class AbstractFactory {
    abstract public Shape getShape(String shape);
    abstract public Color getColor(String color);
}
