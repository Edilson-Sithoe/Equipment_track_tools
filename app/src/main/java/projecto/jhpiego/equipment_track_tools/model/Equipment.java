package projecto.jhpiego.equipment_track_tools.model;

public class Equipment {
    private int id;
    private String nome_equipment;

    public Equipment(int id, String nome_equipment) {
        this.id = id;
        this.nome_equipment = nome_equipment;
    }

    public Equipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_equipment() {
        return nome_equipment;
    }

    public void setNome_equipment(String nome_equipment) {
        this.nome_equipment = nome_equipment;
    }
}
