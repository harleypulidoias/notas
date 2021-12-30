import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Scanner entrada = new Scanner(System.in);
        double  promedio=0, sumaPorcentaje=0;
        int opcion;
        ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>();
        ArrayList<Notas> arrayNotas = new ArrayList<Notas>();
        ArrayList<Materia> arrayMaterias = new ArrayList<Materia>();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();

        Carrera carr = new Carrera();
        arrayCarreras = carr.creacionCarreras();

        Materia materia1 = new Materia(50, "Matematicas", 4, arrayNotas);
        Materia materia2 = new Materia(40, "Algebra", 4, arrayNotas);
        Materia materia3 = new Materia(30, "Calculo", 4, arrayNotas);

        arrayMaterias.add(materia1);
        arrayMaterias.add(materia2);
        arrayMaterias.add(materia3);

        Usuario usuario1 = new Usuario(123, "Pepito", " ", "Perez", arrayCarreras.get(1), arrayMaterias);
        arrayUsuarios.add(usuario1);


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
                arrayUsuarios.s
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println(arrayUsuarios.toString());
                break;

            case 8:
                Notas nota = new Notas();
                nota.agregarNota(arrayUsuarios);
                break;

        }

        }while (opcion!=6);



    }





}
