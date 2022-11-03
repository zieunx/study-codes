package com.test.java.javatest.immutable.step4;

public class Address {
    private final String county;
    private final String state;
    private final String city;
    private final String zipCode;

    public Address(final String county, final String state, final String city, final String zipCode) {
        this.county = county;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", county, state, city, zipCode);
    }
}
