import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Scanner entrada = new Scanner(System.in);
        double nota=0, promedio=0, sumaPorcentaje=0;
        int opcion;
        ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>();
        ArrayList<Notas> arrayNotas = new ArrayList<Notas>();
        ArrayList<Materia> arrayMaterias = new ArrayList<Materia>();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();

        Carrera carr = new Carrera();
        arrayCarreras = carr.creacionCarreras();


        Materia materia1 = new Materia(50, "Matematicas", 4, arrayNotas);

        arrayMaterias.add(materia1);


        do {
            System.out.println("Menu \n" +
                    "\n Administracion de usuarios:" +
                    "\n 1) Crear usuario" +
                    "\n 2) Modificar usuario" +
                    "\n 3) Eliminar usuario" +
                    "\n 4) Ver usuarios creados" +
                    "\n Administracion de materias:" +
                    "\n 5) Crear materia" +
                    "\n 6) Modificar materia" +
                    "\n 7) Eliminar materia" +
                    "\n Administracion de notas:" +
                    "\n 8) Agregar notas" +
                    "\n 9) Modificar notas" +
                    "\n 10) Eliminar notas" +
                    "\n 11) Salir");
            opcion = entrada.nextInt();


            switch (opcion){

            case 1:
                Usuario usuario = new Usuario();
                arrayUsuarios = usuario.agregarUsuario(arrayCarreras, arrayMaterias);
                break;
            case 2:
                break;
            case 3:
                break;

            case 4:
                System.out.println(arrayUsuarios.toString());
                break;

        }

        }while (opcion!=6);



    }





}
