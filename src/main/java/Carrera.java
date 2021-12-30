public class Carrera {
    private int id;
    private String nombre;
    private int creditosTot;

    public Carrera(int id, String nombre, int creditosTot) {
        this.id = id;
        this.nombre = nombre;
        this.creditosTot = creditosTot;
    }

    public Carrera (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditosTot() {
        return creditosTot;
    }

    public void setCreditosTot(int creditosTot) {
        this.creditosTot = creditosTot;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", creditosTot=" + creditosTot +
                '}';
    }
}
