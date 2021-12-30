import java.util.ArrayList;

public class Materia {

    private int id;
    private String nombre;
    private int creditos;
    private ArrayList<Notas> notas;

    public Materia(int id, String nombre, int creditos, ArrayList<Notas> notas) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.notas = notas;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ArrayList<Notas> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                ", notas=" + notas +
                '}';
    }

    public boolean validarNotas2(ArrayList<Notas> notas){
        boolean validar = false;
        double sumaPorcentaje=0, promedio=0;

        for (int i = 0; i < notas.size(); i++) {
            sumaPorcentaje += notas.get(i).getPorcentaje();
            promedio += notas.get(i).getValor();
        }

        return validar;
    }
}
