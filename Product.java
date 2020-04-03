import javax.swing.*;

public class Product {
    String[] attributes;
    String[] customers;
    String[] skus;
    double price;
    ImageIcon thumbnail;
    String description;
    String name;
    String packaging;
    String power;
    String[] related;


    public Product(String[] attributes, String[] customers, String[] skus, double price, ImageIcon thumbnail, String description, String name, String packaging, String power, String[] related) {
        this.attributes = attributes;
        this.customers = customers;
        this.skus = skus;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.name = name;
        this.packaging = packaging;
        this.power = power;
        this.related = related;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public String[] getCustomers() {
        return customers;
    }

    public void setCustomers(String[] customers) {
        this.attributes = customers;
    }

    public String[] getSkus() {
        return skus;
    }

    public void setSkus(String[] skus) {
        this.skus = skus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ImageIcon getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageIcon thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String[] getRelated() {
        return related;
    }

    public void setRelated(String[] related) {
        this.related = related;
    }
}
