package model.entity;

import model.utils.Vector2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoctorTest {
    Vector2D position;;
    int bombs;
    int teleports;
    int rewinds;
    Doctor doctor;

    @BeforeEach
    public void init() {
        position = new Vector2D(2,2);
        bombs = 1;
        teleports = 3;
        rewinds = 3;
        doctor = new Doctor(position, bombs, teleports, rewinds);
    }

    @Test
    public void moveDoctorToProperPlaceTest() {
        //given
        Vector2D prevPosition = doctor.getPosition();
        Vector2D newPosition = new Vector2D(3,3);

        //when
        doctor.move(newPosition);

        //then
        assertEquals(newPosition, doctor.getPosition());
        assertEquals(prevPosition, doctor.getPrevPosition());
    }

    @Test
    public void oneTeleportTest(){
        //given
        Vector2D prevPosition = doctor.getPosition();
        Vector2D teleportedPosition = new Vector2D(5,5);

        //when
        doctor.teleport(teleportedPosition);

        //then
        assertEquals(teleportedPosition, doctor.getPosition());
        assertEquals(2, doctor.getTeleports().get());
        assertEquals(prevPosition, doctor.getPrevPosition());
    }

    @Test
    public void twoTeleportTest(){
        //given
        Vector2D teleportedPositionOne = new Vector2D(5,5);
        Vector2D teleportedPositionTwo = new Vector2D(1,2);

        //when
        doctor.teleport(teleportedPositionOne);
        doctor.teleport(teleportedPositionTwo);

        //then
        assertEquals(teleportedPositionTwo, doctor.getPosition());
        assertEquals(1, doctor.getTeleports().get());
        assertEquals(teleportedPositionOne, doctor.getPrevPosition());
    }

    @Test
    public void threeTeleportTest(){
        //given
        Vector2D teleportedPositionOne = new Vector2D(5,5);
        Vector2D teleportedPositionTwo = new Vector2D(1,2);
        Vector2D teleportedPositionThree = new Vector2D(3,6);

        //when
        doctor.teleport(teleportedPositionOne);
        doctor.teleport(teleportedPositionTwo);
        doctor.teleport(teleportedPositionThree);

        //then
        assertEquals(teleportedPositionThree, doctor.getPosition());
        assertEquals(0, doctor.getTeleports().get());
        assertEquals(teleportedPositionTwo, doctor.getPrevPosition());
    }

    @Test
    public void fourTeleportTest(){
        //given
        Vector2D teleportedPositionOne = new Vector2D(5,5);
        Vector2D teleportedPositionTwo = new Vector2D(1,2);
        Vector2D teleportedPositionThree = new Vector2D(3,6);
        Vector2D teleportedPositionFour = new Vector2D(2,3);

        //when
        doctor.teleport(teleportedPositionOne);
        doctor.teleport(teleportedPositionTwo);
        doctor.teleport(teleportedPositionThree);
        doctor.teleport(teleportedPositionFour);

        //then
        assertEquals(teleportedPositionThree, doctor.getPosition());
        assertEquals(0, doctor.getTeleports().get());
        assertEquals(teleportedPositionTwo, doctor.getPrevPosition());
    }

    @Test
    public void useOneBombTest() {
        //given

        //when
        doctor.useBomb();

        //then
        assertEquals(0, doctor.getBombs().get());
    }

    @Test
    public void useTwoBombTest() {
        //given

        //when
        doctor.useBomb();
        doctor.useBomb();

        //then
        assertEquals(0, doctor.getBombs().get());
    }

    @Test
    public void useRewindTest() {
        //given //when //then
        assertEquals(3, doctor.getRewinds().get());
        for(int i = 0; i<5; i++) {
            doctor.useRewind();
        }
        assertEquals(0, doctor.getRewinds().get());
        doctor.useRewind();
        assertEquals(0, doctor.getRewinds().get());
    }
}
