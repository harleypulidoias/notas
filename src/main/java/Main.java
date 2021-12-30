import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Scanner entrada = new Scanner(System.in);
        double nota=0, promedio=0, sumaPorcentaje=0;
        int opcion;

        ArrayList<Notas> arrayNotas = new ArrayList<Notas>();
        ArrayList<Materia> arrayMaterias = new ArrayList<Materia>();
        Carrera carrera = new Carrera(111,"Ingenieria", 20);
        Materia materia1 = new Materia(50, "Matematicas", 4, arrayNotas);

        arrayMaterias.add(materia1);
        Usuario usuario1 = new Usuario(11,"Pedro","alberto","olarte",carrera,arrayMaterias);


        System.out.println("Usuario: "+usuario1.toString());

        /*do {
            System.out.println("Menu \n" +
                    "\n Administracion de usuarios:" +
                    "\n 1) Crear usuario" +
                    "\n 2) Modificar usuario" +
                    "\n 3) Eliminar usuario" +
                    "\n Administracion de materias:" +
                    "\n 4) Crear materia" +
                    "\n 5) Modificar materia" +
                    "\n 6) Eliminar materia" +
                    "\n Administracion de notas:" +
                    "\n 7) Agregar notas" +
                    "\n 8) Modificar notas" +
                    "\n 9) Eliminar notas" +
                    "\n 10) Salir");
            opcion = entrada.nextInt();


            switch (opcion){

            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

        }

        }while (opcion!=6);

        */
        //System.out.println("Materia: "+materia1.toString());


    }

}
