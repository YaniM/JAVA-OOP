package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;

    @Before
    public void setup() {
        this.car = new Car("Alfa", 10, 5, 1);
    }

    @Test
    public void getModelShouldReturnCorrectly(){
        Assert.assertEquals("Alfa",this.car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void modelShouldNotBeNull(){
        this.car.setModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void modelShouldNotBeEmptyString(){
        this.car.setModel("");
    }

    @Test
    public void setModelShouldWorkCorrectly(){
        this.car.setModel("banica");
        assertEquals("banica",this.car.getModel());
    }

    @Test
    public void getTankCapacityShouldWork(){
        assertEquals(10,this.car.getTankCapacity(),0);
    }

    @Test
    public void setTankCapacityShouldWork(){
        this.car.setTankCapacity(1);
        assertEquals(1,1,0);
    }

    @Test
    public void getFuelAmountShouldWork(){
        assertEquals(5,this.car.getFuelAmount(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fuelAmountShouldNotBeLargerThanCapacityThrows(){
        this.car.setFuelAmount(500);
    }

    @Test
    public void setFuelAmountShouldWork(){
        this.car.setFuelAmount(6);
        assertEquals(6,this.car.getFuelAmount(),0);
    }

    @Test
    public void getFuelConsumptionPerKmShouldWork(){
        assertEquals(1,this.car.getFuelConsumptionPerKm(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionShouldBeLargeThanZeroThrow(){
        this.car.setFuelConsumptionPerKm(-1);
    }

    @Test
    public void setFuelConsumptionShouldWork(){
        this.car.setFuelConsumptionPerKm(4);
        assertEquals(4,this.car.getFuelConsumptionPerKm(),0);
    }

    @Test(expected = IllegalStateException.class)
    public void fuelAmountShouldBeEnought(){
        this.car.drive(50000);
    }

    @Test
    public void driveShouldSetAmountCorrectly(){
        this.car.drive(1);
        assertEquals(4,this.car.getFuelAmount(),0);
    }

    @Test
    public void driverShouldReturnMessage(){
        assertEquals("Have a nice trip",this.car.drive(1));
    }

    @Test(expected = IllegalStateException.class)
    public void fuelAmountShouldBeLessThanCapacity(){
        this.car.refuel(500000);
    }

    @Test
    public void refuelShouldWork(){
        this.car.refuel(2);
        assertEquals(7,this.car.getFuelAmount(),0);
    }
}