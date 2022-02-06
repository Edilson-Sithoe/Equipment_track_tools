package projecto.jhpiego.equipment_track_tools.model;

public class Equipment_inventory {
    private int id;
    private int department_id;
    private int equipment_id;
    private String typeEquipment;
    private String inventory_number;
    private String make;
    private String model;
    private String serial_number;
    private String equipment_condition;
    private String year_install;
    private String main_contract;
    private String data_last_main;
    private String comments;

//    public Equipment_inventory(String department, String typeEquipment, String inventory_number, String make, String model, String serial_number, String equipment_condition, String year_install, String main_contract, String data_last_main, String comments) {
//        this.department = department;
//        this.typeEquipment = typeEquipment;
//        this.inventory_number = inventory_number;
//        this.make = make;
//        this.model = model;
//        this.serial_number = serial_number;
//        this.equipment_condition = equipment_condition;
//        this.year_install = year_install;
//        this.main_contract = main_contract;
//        this.data_last_main = data_last_main;
//        this.comments = comments;
//    }

    public Equipment_inventory() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getTypeEquipment() {
        return typeEquipment;
    }

    public void setTypeEquipment(String typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public String getInventory_number() {
        return inventory_number;
    }

    public void setInventory_number(String inventory_number) {
        this.inventory_number = inventory_number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getEquipment_condition() {
        return equipment_condition;
    }

    public void setEquipment_condition(String equipment_condition) {
        this.equipment_condition = equipment_condition;
    }

    public String getYear_install() {
        return year_install;
    }

    public void setYear_install(String year_install) {
        this.year_install = year_install;
    }

    public String getMain_contract() {
        return main_contract;
    }

    public void setMain_contract(String main_contract) {
        this.main_contract = main_contract;
    }

    public String getData_last_main() {
        return data_last_main;
    }

    public void setData_last_main(String data_last_main) {
        this.data_last_main = data_last_main;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Equipment_inventory{" +
                "id=" + id +
                ", department_id=" + department_id +
                ", equipment_id=" + equipment_id +
                ", typeEquipment='" + typeEquipment + '\'' +
                ", inventory_number='" + inventory_number + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", serial_number='" + serial_number + '\'' +
                ", equipment_condition='" + equipment_condition + '\'' +
                ", year_install='" + year_install + '\'' +
                ", main_contract='" + main_contract + '\'' +
                ", data_last_main='" + data_last_main + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
