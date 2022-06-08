package shop;

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private int salary_in_usd;
    private int country_id;

    public Employee() {
    }

    public Employee(int id, String first_name, String last_name, String date_of_birth,
                    int salary_in_usd, Country country) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.salary_in_usd = salary_in_usd;
        this.country_id = country.getId();
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country) {
        this.country_id = country.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getSalary_in_usd() {
        return salary_in_usd;
    }

    public void setSalary_in_usd(int salary_in_usd) {
        this.salary_in_usd = salary_in_usd;
    }
}
