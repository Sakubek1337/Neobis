package shop;

public class Phone {

    private int id;
    private int brand_id;
    private String model;
    private int country_made_in_id;
    private int year_made;
    private int warehouse_id;
    private int price_in_usd;

    public Phone() {
    }

    public Phone(int id, Brand brand, String model, Country country,
                 int year_made, Warehouse warehouse, int price_in_usd) {
        this.id = id;
        this.brand_id = brand.getId();
        this.model = model;
        this.country_made_in_id = country.getId();
        this.year_made = year_made;
        this.warehouse_id = warehouse.getId();
        this.price_in_usd = price_in_usd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Brand brand) {
        this.brand_id = brand.getId();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCountry_made_in_id() {
        return country_made_in_id;
    }

    public void setCountry_made_in_id(Country country) {
        this.country_made_in_id = country.getId();
    }

    public int getYear_made() {
        return year_made;
    }

    public void setYear_made(int year_made) {
        this.year_made = year_made;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Warehouse warehouse) {
        this.warehouse_id = warehouse.getId();
    }

    public int getPrice_in_usd() {
        return price_in_usd;
    }

    public void setPrice_in_usd(int price_in_usd) {
        this.price_in_usd = price_in_usd;
    }
}
