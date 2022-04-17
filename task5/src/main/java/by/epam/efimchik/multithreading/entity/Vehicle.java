package by.epam.efimchik.multithreading.entity;

import java.util.Objects;

public class Vehicle {
    private long id;
    private VehicleType vehicleType;
    private float weight;
    private float square;
    private State state;

    public Vehicle(long id, VehicleType vehicleType, float weight, float square, State state) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.weight = weight;
        this.square = square;
        this.state = state;
    }

    public Vehicle(long id, VehicleType vehicleType, float weight, float square) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.weight = weight;
        this.square = square;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id && Float.compare(vehicle.weight, weight) == 0 && Float.compare(vehicle.square, square) == 0 && vehicleType == vehicle.vehicleType && state == vehicle.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicleType, weight, square, state);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Vehicle{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", vehicleType=").append(vehicleType);
        stringBuilder.append(", weight=").append(weight);
        stringBuilder.append(", square=").append(square);
        stringBuilder.append(", state=").append(state);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
