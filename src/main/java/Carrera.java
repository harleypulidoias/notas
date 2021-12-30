import java.util.ArrayList;

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

    public static ArrayList creacionCarreras(){
        ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>();
        Carrera car1 = new Carrera(111,"Ingenieria sistemas", 25);
        Carrera car2 = new Carrera(222,"Ingenieria financiera", 15);
        Carrera car3 = new Carrera(333,"Psicologia", 20);

        arrayCarreras.add(car1);
        arrayCarreras.add(car2);
        arrayCarreras.add(car3);

        return arrayCarreras;
    }

    public static Carrera buscarCarrera(int id){
        ArrayList<Carrera> carr = new ArrayList<Carrera>();
        carr = creacionCarreras();
        Carrera carreraEncontrada = null;

        for (int i = 0; i < carr.size(); i++) {
            if (carr.get(i).getId() == id){
                System.out.println("Carrera "+carr.get(i).getNombre()+" asignada");
                return carr.get(i);
            }
        }
        return carreraEncontrada;
    }
}
