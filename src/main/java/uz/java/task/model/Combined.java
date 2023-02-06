package uz.java.task.model;

import java.util.StringJoiner;

public class Combined {
    private Integer integer;
    private String string;

    public Combined(Integer integer, String string) {
        this.integer = integer;
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return new StringJoiner("=", "[", "]")
                .add(integer.toString())
                .add(string)
                .toString();
    }
}
