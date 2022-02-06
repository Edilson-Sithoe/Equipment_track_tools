package projecto.jhpiego.equipment_track_tools.model;

public class Department {
    private int id;
    private String nome_department;
    private String obs;

    public Department(int id, String nome_department, String obs) {
        this.id = id;
        this.nome_department = nome_department;
        this.obs = obs;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_department() {
        return nome_department;
    }

    public void setNome_department(String nome_department) {
        this.nome_department = nome_department;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
