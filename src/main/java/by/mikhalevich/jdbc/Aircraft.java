package by.mikhalevich.jdbc;

import java.util.Objects;

public class Aircraft {
    private String code;
    private String model;
    private Integer range;

    public Aircraft() {
    }

    public Aircraft(String code, String model, Integer range) {
        this.code = code;
        this.model = model;
        this.range = range;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(code, aircraft.code) &&
                Objects.equals(model, aircraft.model) &&
                Objects.equals(range, aircraft.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, model, range);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "code='" + code + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}
