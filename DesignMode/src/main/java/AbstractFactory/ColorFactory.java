package AbstractFactory;

import Utils.Color.Bule;
import Utils.Color.Color;
import Utils.Color.Red;
import Utils.Color.Yellow;
import Utils.Shape.Shape;

public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String type) {
        if (type.equalsIgnoreCase("red"))
            return new Red();
        if (type.equalsIgnoreCase("blue"))
            return new Bule();
        if (type.equalsIgnoreCase("yellow"))
            return new Yellow();
        return null;
    }
}
