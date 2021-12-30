import java.util.ArrayList;

public class Usuario {

    private int id;
    private String primerNombre;
    private String segunNombre;
    private String apellidos;
    Carrera carrera;
    ArrayList<Materia> materia;

    public Usuario(int id, String primerNombre, String segunNombre, String apellidos, Carrera carrera, ArrayList<Materia> materia) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segunNombre = segunNombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.materia = materia;
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
}
