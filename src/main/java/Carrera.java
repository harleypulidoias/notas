import java.util.ArrayList;
import java.util.Scanner;

public class Carrera {
    private int id;
    private String nombre;
    private int creditosTot;
    Scanner entrada = new Scanner(System.in);

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

    public Carrera buscarCarrera(ArrayList<Carrera> carrerasList){
        Carrera carreraEncontrada = null;
        int idCarrera;
        for (int i = 0; i < carrerasList.size(); i++) {
            System.out.println(carrerasList.get(i));
        }
        System.out.print("ingrese el id de la carrera: ");
        idCarrera = entrada.nextInt();

        for (int i = 0; i < carrerasList.size(); i++) {
            if (carrerasList.get(i).getId() == idCarrera){
                System.out.println("-------------------------------------------------");
                System.out.println("***** Carrera "+carrerasList.get(i).getNombre()+" asignada *****");
                System.out.println("-------------------------------------------------");
                System.out.println("");
                carreraEncontrada = carrerasList.get(i);
            }
        }
        return carreraEncontrada;
    }

    public Integer validarCreditos (ArrayList<Materia> materias){
        int sumaCreditos=0;

        for (int i = 0; i < materias.size(); i++) {
            sumaCreditos += materias.get(i).getCreditos();
        }

        return sumaCreditos;
    }
}
