import org.jetbrains.annotations.NotNull;

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

    public double validarNotas2(ArrayList<Notas> notas){
        boolean validar = false;
        double sumaPorcentaje=0, promedio=0;
        double resultado=0;

        for (int i = 0; i < notas.size(); i++) {
            sumaPorcentaje += notas.get(i).getPorcentaje();
            promedio += notas.get(i).getValor();
            promedio = promedio/ notas.size();
            if(sumaPorcentaje <= 100 && sumaPorcentaje > 0 && promedio <= 5){
                resultado=sumaPorcentaje;
            }
        }

        return resultado;
    }

    public Materia buscarMateria(ArrayList<Materia> materiasCreadas, Usuario usuario){
        Materia materia = new Materia();
        ArrayList<Materia> materiasDispo = new ArrayList<>();
        int idMateria;

        System.out.println("Seleccione la materia del usuario: " +usuario.getPrimerNombre());
        for (int i = 0; i < materiasCreadas.size(); i++) {
            if (materiasCreadas == usuario.getMateria()){
                System.out.println(materiasCreadas.get(i).toString());
            }else {
                if (!usuario.getMateria().contains(materiasCreadas.get(i))){
                    System.out.println(materiasCreadas.get(i).toString());
                }
            }
        }
        System.out.println("ingrese el id de la materia: ");
        idMateria = entrada.nextInt();
        for (int j = 0; j < materiasCreadas.size(); j++) {
            if (idMateria == materiasCreadas.get(j).getId()) {
                materia = materiasCreadas.get(j);
                break;
            }else {
                materia = null;
            }
        }

        return materia;
    }

    public ArrayList agregarMateria (int cantMaterias, ArrayList<Materia> materiasCreadas, Integer cantCreditos){
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<Materia> materiasTemp = new ArrayList<>();
        ArrayList<Integer> escogidas = new ArrayList<>();
        Carrera carrera = new Carrera();
        int idMateria, sumaCreditos=0;


        for (int j = 0; j < cantMaterias ; j++) {
            System.out.println("Seleccione el id la materia "+(j+1));
            System.out.println("-----------------------------------");
            System.out.println("Tiene "+(cantCreditos-sumaCreditos)+" creditos disponibles");
            System.out.println("---------------------------------------");
            for (int k = 0; k < materiasCreadas.size(); k++) {
                if (!escogidas.contains(materiasCreadas.get(k).getId())){
                    System.out.println(materiasCreadas.get(k).toString());
                }
            }
            System.out.println("------------------------------------------");
            System.out.println("''tener en cuenta la cantidad de creditos---''");
            System.out.print("ingrese solo id de la materia: ");
            idMateria = entrada.nextInt();
            escogidas.add(idMateria);
            for (int i = 0; i < materiasCreadas.size(); i++) {

                if (materiasCreadas.get(i).getId() == idMateria){
                    materiasTemp.add(materiasCreadas.get(i));
                    sumaCreditos = carrera.validarCreditos(materiasTemp);
                    if (sumaCreditos <= cantCreditos){
                        materias.add(materiasCreadas.get(i));
                        System.out.println("-----------------------------------------------------");
                        System.out.println("***** Materia "+materiasCreadas.get(i).getNombre()+" agregada correctamente ***** \n");
                        System.out.println("-----------------------------------------------------");
                    }else {
                        System.out.println("No se pudo agregar la materia");
                    }

                }
            }
        }
        
        return materias;
    }
    
    public Materia eliminarMatArray(ArrayList<Materia> materias){
        Materia materia = new Materia();
        int idMateria;

        System.out.println("Seleccione la materia que desea eliminar");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(materias.get(i).toString());
        }
        idMateria = entrada.nextInt();
        for (int j = 0; j < materias.size(); j++) {
            if (idMateria == materias.get(j).getId()){
                System.out.println("-----------------------------------------------------");
                System.out.println("***** Materia "+materias.get(j).toString()+ " eliminada correctamente *****");
                System.out.println("-----------------------------------------------------");
                materia = materias.get(j);
            }
        }

        return materia;
    }

    public ArrayList crearMateria(ArrayList<Materia> materias){
        Materia materia = new Materia();
        ArrayList<Notas> notas = new ArrayList<>();
        int idMateria, i=0;
        boolean validar=false;

        do{
            System.out.println("Ingrese un id v??lido para la Materia");
            idMateria = entrada.nextInt();
            for (int j = 0; j < materias.size(); j++) {
                if (idMateria == materias.get(j).getId()) {
                    i = 0;
                    break;
                }else {
                    i = 1;
                    materia.setId(idMateria);
                }
            }
        }while (i!=1);
        materia.setId(idMateria);
        System.out.println("Ingrese el nombre de la materia");
        materia.setNombre(entrada.next());
        System.out.println("Ingrese los cr??ditos de la materia");
        materia.setCreditos(entrada.nextInt());
        materia.setNotas(notas);
        materias.add(materia);
        System.out.println("_____________________________________");
        System.out.println("***** Materia creada correctamente *****");
        System.out.println("---------------------------------------");
        return materias;
    }


        public ArrayList eliminarMateria(ArrayList<Materia> materias) {
        Materia materia = new Materia();
        int materiaEliminar;

        System.out.println("Seleccione el ID de la materia que desea eliminar: ");
            System.out.println("");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(materias.get(i));
        }
            System.out.println("ingrese el id de la materia a eliminar.");
        materiaEliminar = entrada.nextInt();
        for (int j = 0; j < materias.size(); j++) {
            if (materiaEliminar == materias.get(j).getId()) {
                materia = materias.get(j);
            }
        }
        if (materia != null) {
            materias.remove(materia);
            System.out.println("---------------------------------------------------");
            System.out.println("***** La materia " + materiaEliminar + " Ha sido eliminada *****");
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("No se encontro la materia solicitada");
        }
        return materias;
    }

    public void modificarMateria (ArrayList<Materia> materiasCreadas) {
        int idMateria;
        Materia materia = new Materia();
        System.out.println("Listado de materias:");
        for (int i = 0; i < materiasCreadas.size() ; i++) {
            System.out.println(materiasCreadas.get(i).getId()  + "-" +  materiasCreadas.get(i).getNombre());
        }

        System.out.println("Seleccione el ID de la materia a modificar:");
        idMateria = entrada.nextInt();
        for (int j = 0; j <materiasCreadas.size(); j++) {
                if (idMateria == materiasCreadas.get(j).getId()){
                    materia = materiasCreadas.get(j);
                    break;
                } else {
                    materia=null;
                }
            }
        if (materia!=null){
            if (!(materia.getNotas().size() > 0)){
                System.out.println("Ingrese el nuevo nombre de la materia:");
                materia.setNombre(entrada.next());
                System.out.println("Ingrese los nuevos creditos de la materia:");
                materia.setCreditos(entrada.nextInt());
                System.out.println("-----------------------------------------------------");
                System.out.println("***** La materia se ha modificado correctamente *****");
                System.out.println("-----------------------------------------------------");
            } else {
                System.out.println("Se debe eliminar las notas asignadas a la materia antes de realizar alguna modificaci??n");
            }
        } else {
            System.out.println("La materia seleccionada no se encontro");
        }
    }
}
