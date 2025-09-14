package com.pairone.library.dto.address;


import jakarta.validation.constraints.NotBlank;

public class AddressDto {
    private int id;
    @NotBlank
    private String street;
    private String city;
    private String district;
    private String neighborhood;
    private String building;
    private String apartmentNo;

    // Default constructor
    public AddressDto() {
    }

    // Constructor with all fields (for updates)
    public AddressDto(int id, String street, String city, String district,
                      String neighborhood, String building, String apartmentNo) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.district = district;
        this.neighborhood = neighborhood;
        this.building = building;
        this.apartmentNo = apartmentNo;
    }

    // Constructor without id (for creates)
    public AddressDto(String street, String city, String district,
                      String neighborhood, String building, String apartmentNo) {
        this.street = street;
        this.city = city;
        this.district = district;
        this.neighborhood = neighborhood;
        this.building = building;
        this.apartmentNo = apartmentNo;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }
}