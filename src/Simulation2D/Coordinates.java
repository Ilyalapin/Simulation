package Simulation2D;

import java.util.Objects;

public class Coordinates {
    public final Integer COORDINATE_Y;
    public final Integer COORDINATE_X;

    public Coordinates(Integer COORDINATE_Y, Integer COORDINATE_X) {
        this.COORDINATE_Y = COORDINATE_Y;
        this.COORDINATE_X = COORDINATE_X;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(COORDINATE_Y, that.COORDINATE_Y) && Objects.equals(COORDINATE_X, that.COORDINATE_X);
    }

    @Override
    public int hashCode() {
        return Objects.hash(COORDINATE_Y, COORDINATE_X);
    }

}
