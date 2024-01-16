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
        // filter interface is functional: has only one method: include().
        // lambda overrites include() and "sets" a functionality
        // that value is then passed to filter(), which iterates through the SimpleList plants.
        return plants.filter(p -> p.getColor().equals(color));
    }

    public SimpleList<T> getPlants(){
        return plants.map(p -> p);
    }

    public void remove(T p){
        plants = plants.filter(o -> !o.equals(p));
    }
}
