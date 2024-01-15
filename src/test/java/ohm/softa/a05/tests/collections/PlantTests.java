package ohm.softa.a05.tests.collections;

import ohm.softa.a05.collections.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantTests {
    private final Logger logger = LogManager.getLogger();
    private final PlantBed<Flower> plantBed = new PlantBed<>();
    private final List<Plant> flowerList = new ArrayList<>();

    @BeforeEach
    void setup(){
        Flower orangeFlower = new Flower(2.34, PlantColor.ORANGE);
        Flower redFlower = new Flower(1.23, PlantColor.RED);
        Flower greenFlower = new Flower(5.25, PlantColor.GREEN);

        flowerList.add(orangeFlower);
        flowerList.add(redFlower);
        flowerList.add(greenFlower);

        plantBed.add(orangeFlower);
        plantBed.add(redFlower);
        plantBed.add(redFlower);
    }
    @Test
    void flowerColorTests(){
        assertEquals(PlantColor.RED, flowerList.get(0).getColor());
        assertEquals(null, flowerList.get(1).getColor());
        assertEquals(2.34, flowerList.get(2).getHeight());
    }

    @Test
    void plantBedTests() {
        assertEquals(1, this.plantBed.getPlantsByColor(PlantColor.ORANGE).size());
    }
}
