package main.java.ocp;

import java.util.Objects;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Contracts {}

class Lion {

    private int idNumber;
    private int age;
    private String name;

    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lion)) return false;
        Lion lion = (Lion) o;
        return Objects.equals(idNumber, lion.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Lion lion = (Lion) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(idNumber, lion.idNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(idNumber)
                .toHashCode();
    }
    */

    /* intellij
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lion lion = (Lion) o;

        return idNumber == lion.idNumber;

    }

    @Override
    public int hashCode() {
        return idNumber;
    }
    */
}
