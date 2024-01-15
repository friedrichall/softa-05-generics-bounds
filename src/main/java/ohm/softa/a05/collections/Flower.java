package ohm.softa.a05.collections;


public class Flower extends Plant{
    PlantColor color;
    @Override
    public PlantColor getColor() {
        return color;
    }
    public Flower(double height, PlantColor color) {
        if(!color.equals(PlantColor.GREEN)){
            this.color = color;
        }
        super.height = height;
    }
}
