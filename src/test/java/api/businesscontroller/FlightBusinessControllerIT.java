package api.businesscontroller;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.entities.Flight;
import api.entities.Captain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightBusinessControllerIT {

    private FlightBusinessController flightBusinessController;
    private Flight flight;

    @BeforeEach
    void prepare() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        this.flightBusinessController = new FlightBusinessController();
        Captain captain = new Captain("nick", null);
        DaoFactory.getFactory().getCaptainDao().save(captain);
        this.flight = new Flight("uno");
        DaoFactory.getFactory().flightDao().save(this.flight);
    }

    @Test
    void testReadAverageWithoutPassenger() {
        assertTrue(Double.isNaN(this.flightBusinessController.readAverage(this.flight.getId())));
    }

    @Test
    void testReadAverage() {
        this.flightBusinessController.createPassenger(flight.getId(), 2);
        this.flightBusinessController.createPassenger(flight.getId(), 4);
        this.flightBusinessController.createPassenger(flight.getId(), 6);
        assertEquals(4.0, this.flightBusinessController.readAverage(flight.getId()), 10e-5);
    }

    @Test
    void testFindByAverageGreaterThanEqualWithoutPassenger() {
        assertTrue(this.flightBusinessController.findByAverageGreaterThanEqual(5.0).isEmpty());
    }

    @Test
    void testFindByAverageGreaterThanEqualEmptyList() {
        this.flightBusinessController.createPassenger(flight.getId(), 2);
        assertTrue(this.flightBusinessController.findByAverageGreaterThanEqual(5.0).isEmpty());
    }

    @Test
    void testFindByAverageGreaterThanEqual() {
        this.flightBusinessController.createPassenger(flight.getId(), 4);
        this.flightBusinessController.createPassenger(flight.getId(), 6);
        assertFalse(this.flightBusinessController.findByAverageGreaterThanEqual(5.0).isEmpty());
    }

}
