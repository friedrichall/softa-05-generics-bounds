package ohm.softa.a05.collections;

public class PlantBed<T extends Plant> {
    private SimpleList<T> plants = new SimpleListImpl<T>();

    public void add(T plant){
        this.plants.add(plant);
    }
    public int size(){
        return this.plants.size();
    }
    public SimpleList<T> getPlantsByColor(PlantColor color){
        SimpleList<T> foundPlants = new SimpleListImpl<>();
        for (T plant: plants) {
            foundPlants = this.plants.filter(new SimpleFilter<T>() {
                @Override
                public boolean include(T item) {
                    return item.getColor().equals(color);
                }
            });
        }
        return foundPlants;
    }

    public void remove(PlantColor color){
        SimpleList<T> remainingPlants = new SimpleListImpl<>();

        for(T plant: plants){
            if(!plant.getColor().equals(color)){
                remainingPlants.add(plant);
            }
        }
        plants = remainingPlants;
    }
}
