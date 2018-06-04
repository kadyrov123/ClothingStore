package com.clothingstore.demo.Model;

public class Product {
    private int id;
    private String name;
    private String description;
    private int amount;
    private String status;
    private String season;
    private String type;
    private String kind;
    private String foto;
    private String f1;
    private String f2;
    private String f3;
    private String f4;
    private String f5;

    public Product(int id, String name, int amount, String status, String season, String type, String kind , String foto) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.status = status;
        this.season = season;
        this.type = type;
        this.kind = kind;
        String f="images/"+foto;
        this.foto = f;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = "images/"+f1;
    }

    public Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", season='" + season + '\'' +
                ", type='" + type + '\'' +
                ", kind='" + kind + '\'' +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFoto() {
        return foto;
    }


    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = "images/"+f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = "images/"+f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 ="images/"+ f4;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 ="images/"+f5;
    }

    public void setFoto(String foto) {
        String f = "images/"+foto;
        this.foto=f;
    }
}
