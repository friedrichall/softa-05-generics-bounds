package ohm.softa.a05.tests.collections;

import ohm.softa.a05.collections.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlantTests {
    private final Logger logger = LogManager.getLogger();
    private final PlantBed<Flower> plantBedFlower = new PlantBed<>();
    private final PlantBed<Plant> plantBedPlant = new PlantBed<>();
    private final PlantBed<Shrub> plantBedShrub = new PlantBed<>();
    private final List<Plant> flowerList = new ArrayList<>();

    @BeforeEach
    void setup(){
        Flower orangeFlower = new Flower(2.34, PlantColor.ORANGE);
        Flower redFlower = new Flower(1.23, PlantColor.RED);
        Flower yellowFlower = new Flower(2.48, PlantColor.YELLOW);
        Flower greenFlower = new Flower(5.25, PlantColor.GREEN);

        flowerList.add(orangeFlower);
        flowerList.add(redFlower);
        flowerList.add(greenFlower);

        plantBedFlower.add(orangeFlower);
        plantBedFlower.add(yellowFlower);
        plantBedFlower.add(redFlower);

        plantBedPlant.add(orangeFlower);
        plantBedPlant.add(redFlower);
        plantBedPlant.add(redFlower);
        plantBedPlant.add(new Plant() {
            @Override
            public PlantColor getColor() {
                return PlantColor.YELLOW;
            }
        });
        plantBedPlant.add(new Shrub());

        plantBedShrub.add(new Shrub());
        plantBedShrub.add(new Shrub());
    }
    @Test
    void flowerColorTests(){
        assertEquals(PlantColor.RED, flowerList.get(0).getColor());
        assertEquals(null, flowerList.get(1).getColor());
        assertEquals(2.34, flowerList.get(2).getHeight());
    }

    @Test
    void plantBedTests() {
        assertEquals(1, this.plantBedFlower.getPlantsByColor(PlantColor.ORANGE).size());
    }

    @Test
    void plantBedUtilityTest(){
        PlantBedUtility.repot(plantBedShrub, PlantColor.YELLOW, plantBedPlant);
        assertEquals(0, plantBedFlower.getPlantsByColor(PlantColor.YELLOW).size());
    }
}
