package shop;

public class Brand {

    private int id;
    private String name;
    private int country_id;

    public Brand() {
    }

    public Brand(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country_id = country.getId();
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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country) {
        this.country_id = country.getId();
    }
}
