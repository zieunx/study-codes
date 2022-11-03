package com.test.java.javatest.immutable.step3;

public class Address {
    private String county;
    private String state;
    private String city;
    private String zipCode;

    public Address(final String county, final String state, final String city, final String zipCode) {
        this.county = county;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public void update(final String county, final String state, final String city, final String zipCode) {
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
