package model.utils;

import model.WorldMap;
import model.entity.Dalek;
import model.entity.Doctor;
import mainApp.MainApp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MapGenerationHelperTest {

    @Test
    public void creatingDoctorTest() {
        //given
        int mapWidth = 10;
        int mapHeight = 10;
        WorldMap worldMap = new WorldMap(mapWidth, mapHeight);

        //when
        Doctor generatedDoctor = MapGenerationHelper.randomPlaceDoctor(worldMap);

        //then
        assertEquals(2, generatedDoctor.getBombs().get());
        assertEquals(3, generatedDoctor.getTeleports().get());
        assertTrue(generatedDoctor.getPosition().getX() < MainApp.WIDTH);
        assertTrue(generatedDoctor.getPosition().getY() < MainApp.HEIGHT);
        assertTrue(worldMap.getPositionsOfAlive().containsValue(generatedDoctor));
    }

    @Test
    public void creatingDaleksTest() {
        //given
        int mapWidth = 10;
        int mapHeight = 10;
        WorldMap worldMap = new WorldMap(mapWidth, mapHeight);
        int numberOfDaleksToCreate = 10;

        //when
        List<Dalek> generatedDaleks = MapGenerationHelper.randomPlaceDaleks(worldMap, numberOfDaleksToCreate);

        //then
        assertEquals(numberOfDaleksToCreate, generatedDaleks.size());
        assertEquals(numberOfDaleksToCreate, worldMap.getPositionsOfAlive().size());
    }
}