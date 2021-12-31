import java.util.ArrayList;
import java.util.Scanner;

public class Materia {

    private int id;
    private String nombre;
    private int creditos;
    private ArrayList<Notas> notas;
    Scanner entrada = new Scanner(System.in);

    public Materia(int id, String nombre, int creditos, ArrayList<Notas> notas) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.notas = notas;
    }

    public Materia() {

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
            promedio = promedio/ notas.size();
            if(sumaPorcentaje <= 1 && promedio <= 5){
                validar=true;
            }
        }

        return validar;
    }

    public Materia buscarMateria(ArrayList<Materia> materiasList, Usuario usuario){
        Materia materia = new Materia();
        int idMateria;

        System.out.println("Seleccione la materia del usuario: " +usuario.getPrimerNombre() + " " +materiasList.size());
        for (int i = 0; i < materiasList.size(); i++) {
            System.out.println(materiasList.get(i).toString());
        }
        idMateria = entrada.nextInt();
        for (int j = 0; j < materiasList.size(); j++) {
            if (idMateria == materiasList.get(j).getId()) {
                materia = materiasList.get(j);
            }
        }

        return materia;
    }

    public ArrayList agregarMateria (int cantMaterias, ArrayList<Materia> materiasCreadas){
        ArrayList<Materia> materias = new ArrayList<>();
        int idMateria;

        for (int j = 0; j < cantMaterias ; j++) {
            System.out.println("Seleccione el id la materia "+(j+1));
            for (int k = 0; k < materiasCreadas.size(); k++) {
                System.out.println(materiasCreadas.get(k).toString());
            }
            idMateria = entrada.nextInt();
            for (int i = 0; i < materiasCreadas.size(); i++) {
                if (materiasCreadas.get(i).getId() == idMateria){
                    materias.add(materiasCreadas.get(i));
                }
            }
        }
        
        return materias;
    }
    
    public Materia agregarUnidadMat(ArrayList<Materia> materiasCreadas){
        Materia materia = new Materia();
        int idMateria;
        
        System.out.println("Seleccione el id la materia que desea agregar");
        for (int k = 0; k < materiasCreadas.size(); k++) {
            System.out.println(materiasCreadas.get(k).toString());
        }
        idMateria = entrada.nextInt();
        for (int j = 0; j < materiasCreadas.size(); j++) {
            if (materiasCreadas.get(j).getId() == idMateria){
                materia = materiasCreadas.get(j);
            }
        }        
        return materia;
    }
    
    public void eliminarMatArray(ArrayList<Materia> materias){
        int idMateria;
        System.out.println("Seleccione la materia que desea eliminar");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(materias.get(i).toString());
        }
        idMateria = entrada.nextInt();
        for (int i = 0; i < materias.size(); i++) {
            if (idMateria == materias.get(i).getId()){
                materias.remove(materias.get(i));
                System.out.println("Materia "+materias.get(i).toString()+ "eliminada correctamente");
            }
        }
    }
}
