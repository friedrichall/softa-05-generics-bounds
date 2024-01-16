package ohm.softa.a05.collections;

public abstract class PlantBedUtility {
    private PlantBedUtility(){

    }
    public static <T extends Plant> void repot( //T must be Plant or a subtype of Plant
            PlantBed<T> plantBedInput,
            PlantColor color,
            PlantBed<? super T> plantBedOutput){ //super stands for "über"... class must be supertype of a specific class
        SimpleList<T> plantsToBeRepotted = plantBedInput.getPlantsByColor(color);
        for (T p : plantsToBeRepotted){
            plantBedInput.remove(p);
            plantBedOutput.add(p);
        }
    }
}
