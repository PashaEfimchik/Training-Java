package by.epam.efimchik.multithreading.entity;

import java.util.Objects;

public class Ferry {
    private float platformLoadCapacity;
    private float platformArea;

    public Ferry(float platformLoadCapacity, float platformArea) {
        this.platformLoadCapacity = platformLoadCapacity;
        this.platformArea = platformArea;
    }

    public float getPlatformLoadCapacity() {
        return platformLoadCapacity;
    }

    public void setPlatformLoadCapacity(float platformLoadCapacity) {
        this.platformLoadCapacity = platformLoadCapacity;
    }

    public float getPlatformArea() {
        return platformArea;
    }

    public void setPlatformArea(float platformArea) {
        this.platformArea = platformArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        return Float.compare(ferry.platformLoadCapacity, platformLoadCapacity) == 0 &&
                Float.compare(ferry.platformArea, platformArea) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(platformLoadCapacity, platformArea);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Ferry{");
        stringBuilder.append("platform Load Capacity=").append(platformLoadCapacity);
        stringBuilder.append(", platform Area=").append(platformArea);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
