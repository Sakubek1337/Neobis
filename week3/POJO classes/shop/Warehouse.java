package shop;

public class Warehouse {

    private int id;
    private String address;
    private int manager_id;

    public Warehouse() {
    }

    public Warehouse(int id, String address, Employee employee) {
        this.id = id;
        this.address = address;
        this.manager_id = employee.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(Employee employee) {
        this.manager_id = employee.getId();
    }
}
