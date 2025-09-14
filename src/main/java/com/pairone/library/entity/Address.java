package com.pairone.library.entity;

import jakarta.persistence.*;
// yapıldı
@Entity
@Table(name = "address")
public class Address {
    /*
     address_id int
 city varchar
 district varchar
 street varchar
 neighborhood varchar
 building varchar
 apartment_no
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "building")
    private String building;
    @Column(name = "apartment_no")
    private String apartment_no;

    public Address() {
    }

    public Address(int id, String street, String city, String district, String neighborhood, String building, String apartment_no) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.district = district;
        this.neighborhood = neighborhood;
        this.building = building;
        this.apartment_no = apartment_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getApartment_no() {
        return apartment_no;
    }

    public void setApartment_no(String apartment_no) {
        this.apartment_no = apartment_no;
    }


}
