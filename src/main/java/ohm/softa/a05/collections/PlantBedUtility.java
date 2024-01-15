package ohm.softa.a05.collections;

public abstract class PlantBedUtility {
    private PlantBedUtility(){

    }
    public static <T> void repot(
            PlantBed<?> plantBedFrom,
            PlantColor color,
            PlantBed<?> plantBedTo){
        SimpleList<?> plantsToBeRepotted = plantBedFrom.getPlantsByColor(color);
        plantBedFrom.remove(color);
    }
}
