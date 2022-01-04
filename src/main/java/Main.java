import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Scanner entrada = new Scanner(System.in);
        double  promedio=0, sumaPorcentaje=0;
        int opcion;
        Notas nota = new Notas();
        Usuario usuario = new Usuario();
        ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>();
        ArrayList<Notas> arrayNotas = new ArrayList<Notas>();
        ArrayList<Materia> arrayMaterias = new ArrayList<Materia>();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();
        ArrayList<Usuario> arrayUsuariosCreados = new ArrayList<>();
        ArrayList<Materia> materiasUsuario = new ArrayList<>();

        Carrera carr = new Carrera();
        Materia materia = new Materia();
        arrayCarreras = carr.creacionCarreras();

        Materia materia1 = new Materia(50, "Matematicas", 6, arrayNotas);
        Materia materia2 = new Materia(40, "Algebra", 10, arrayNotas);
        Materia materia3 = new Materia(30, "Calculo", 5, arrayNotas);
        Materia materia4 = new Materia(20, "Fisica", 10, arrayNotas);

        arrayMaterias.add(materia1);
        arrayMaterias.add(materia2);
        arrayMaterias.add(materia3);
        arrayMaterias.add(materia4);

        materiasUsuario = arrayMaterias;

        Usuario usuario1 = new Usuario(123, "Pepito", " ", "Perez", arrayCarreras.get(1), materiasUsuario);
        arrayUsuarios.add(usuario1);


        do {
            System.out.printf("");
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
                arrayUsuarios = usuario.agregarUsuario(arrayUsuarios, arrayCarreras, materiasUsuario);
                break;
            case 2:
                usuario.modificarUsuario(arrayUsuarios, materiasUsuario);
                break;
            case 3:
                break;
            case 4:
                usuario.listarUsuarios(arrayUsuarios);
                break;
            case 5:
                arrayMaterias = materia.crearMateria(arrayMaterias);
                break;
            case 8:
                nota.agregarNota(arrayUsuarios);
                break;

            case 9:
                nota.modificarNota(arrayUsuarios);
                break;
        }

        }while (opcion!=11);



    }

}
