import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private int id;
    private String primerNombre;
    private String segunNombre;
    private String apellidos;
    Carrera carrera;
    ArrayList<Materia> materia;
    Scanner entrada = new Scanner(System.in);

    public Usuario(int id, String primerNombre, String segunNombre, String apellidos, Carrera carrera, ArrayList<Materia> materia) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segunNombre = segunNombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.materia = materia;
    }

    public Usuario(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegunNombre() {
        return segunNombre;
    }

    public void setSegunNombre(String segunNombre) {
        this.segunNombre = segunNombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public ArrayList<Materia> getMateria() {
        return materia;
    }

    public void setMateria(ArrayList<Materia> materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", segunNombre='" + segunNombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", carrera=" + carrera +
                ", materia=" + materia +
                '}';
    }

    public ArrayList agregarUsuario(ArrayList<Carrera> carrerasList, ArrayList<Materia> materiasCreadas){
        int idCarrera, cantMaterias, idMateria;
        ArrayList<Usuario> usuariosList = new ArrayList<>();
        ArrayList<Materia> materiasList = new ArrayList<>();
        Usuario usuario = new Usuario();
        Carrera carrera = new Carrera();
        System.out.println("Ingrese el id del usuario");
        usuario.setId(entrada.nextInt());
        System.out.println("Ingrese el primer nombre del usuario");
        usuario.setPrimerNombre(entrada.next());
        System.out.println("Ingrese el segundo nombre del usuario");
        usuario.setSegunNombre(entrada.next());
        System.out.println("Ingrese el apellido del usuario");
        usuario.setApellidos(entrada.next());
        System.out.println("Seleccione el id de la carrera");
        for (int i = 0; i < carrerasList.size(); i++) {
            System.out.println(carrerasList.get(i));
        }
        idCarrera = entrada.nextInt();
        carrera = Carrera.buscarCarrera(idCarrera);
        usuario.setCarrera(carrera);
        do {
            System.out.println("Cuantas materias desea matricular?");
            System.out.println("Hay ("+materiasCreadas.size()+") materias creadas");
            cantMaterias = entrada.nextInt();
        }while (cantMaterias>materiasCreadas.size());
        for (int j = 0; j < cantMaterias ; j++) {
            System.out.println("Seleccione el id la materia "+(j+1));
            for (int k = 0; k < materiasCreadas.size(); k++) {
                System.out.println(materiasCreadas.get(k).toString());
            }
            idMateria = entrada.nextInt();
            if (materiasCreadas.get(j).getId() == idMateria){
                materiasList.add(materiasCreadas.get(j));
            }
        }
        usuario.setMateria(materiasList);
        usuariosList.add(usuario);
        return usuariosList;
    }
}
