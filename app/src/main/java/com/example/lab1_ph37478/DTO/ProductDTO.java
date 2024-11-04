package com.example.lab1_ph37478.DTO;

public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int idCat;

    public ProductDTO(int id, String name, double price, int idCat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idCat = idCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
}