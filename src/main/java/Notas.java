import org.intellij.lang.annotations.JdkConstants;

import java.util.ArrayList;
import java.util.Scanner;

public class Notas {

    private double valor;
    private double porcentaje;
    Scanner entrada = new Scanner(System.in);

    public Notas() {

    }

    public Notas(double valor, double porcentaje) {
        this.valor = valor;
        this.porcentaje = porcentaje;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "valor=" + valor +
                ", porcentaje=" + porcentaje +
                '}';
    }

    public void agregarNota(ArrayList<Usuario> usuariosCreados) {
        int idusuario, idCarrera, idMateria;
        ArrayList<Notas> notasList = new ArrayList<>();
        ArrayList<Materia> materiasList = new ArrayList<>();
        Notas nota = new Notas();
        Usuario usuario = new Usuario();
        Materia materia = new Materia();

        usuario = usuario.buscarUsuario(usuariosCreados);
        materiasList = usuario.getMateria();
        materia = materia.buscarMateria(materiasList, usuario);
        notasList = nota.insertarNotas(materia);

        if (materia.validarNotas2(notasList)) {
            materia.setNotas(notasList);
            System.out.println("Las notas han sido agregadas correctamente");
        } else {
            System.out.println("Verifique nuevamente los valores ingresados de las notas");
        }

    }

    public  ArrayList insertarNotas (Materia materia) {
        int idusuario, idCarrera, idMateria;
        int cantidadNotas;
        double valor=0d;
        double porcentaje=0d;
        ArrayList<Notas> notasList = new ArrayList<>();

        System.out.println("Cuantas notas desea ingresar a la materia:" + materia.getNombre());
        cantidadNotas = entrada.nextInt();
        for (int i = 0; i < cantidadNotas; i++) {
            do {
                System.out.println("Ingrese un valor válido de la nota: " +(i+1));
                valor = entrada.nextDouble();
            }while (valor > 5 || valor == 0);
            System.out.println("Ingrese el porcentaje de la nota: " +(i+1));
            porcentaje = (double) entrada.nextDouble();
            notasList.add(new Notas(valor, porcentaje));

        }
        return notasList;

    }

    public void modificarNota(ArrayList<Usuario> usuariosList){
        Notas nota = new Notas();
        ArrayList<Materia> materiasList = new ArrayList<>();
        Usuario usuario = new Usuario();
        Materia materia = new Materia();

        usuario = usuario.buscarUsuario(usuariosList);
        materiasList = usuario.getMateria();
        materia = materia.buscarMateria(materiasList, usuario);
        nota = nota.buscarNotas(materia.getNotas());
        System.out.println("Ingrese el nuevo valor de la nota");
        nota.setValor(entrada.nextDouble());
        System.out.println("Ingrese el nuevo porcentaje de la nota");
        nota.setPorcentaje(entrada.nextDouble());
    }


    public Notas buscarNotas(ArrayList<Notas> notas){
        Notas nota = new Notas();
        int idNota;

        System.out.println("Seleccione la nota que va a modificar");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(i +"."+ notas.get(i).toString());
        }
        idNota = entrada.nextInt();
        for (int j = 0; j < notas.size(); j++) {
            if (idNota == (j+1)){
                nota = notas.get(j);
            }
        }
        return nota;
    }

    public void eliminarNota(ArrayList<Usuario> usuariosCreados){
        int idusuario, idMateria;
        double idNota;
        ArrayList<Notas> notasList = new ArrayList<>();
        ArrayList<Materia> materiasList = new ArrayList<>();
        Notas nota = new Notas();
        Usuario usuario1 = new Usuario();
        Materia materia = new Materia();

        System.out.println("Listado de usuarios:");
        for (int m = 0; m < usuariosCreados.size(); m++) {
            System.out.println(usuariosCreados.get(m).getId() + "-" + usuariosCreados.get(m).getPrimerNombre());
        }

        System.out.println("Seleccione el id del usuario:");
        idusuario = entrada.nextInt();
        for (int i = 0; i < usuariosCreados.size(); i++)
            if (idusuario == usuariosCreados.get(i).getId()) {
                usuario1 = usuariosCreados.get(i);
            }

        materiasList= usuario1.getMateria();

        System.out.println("Listado de materias asignadas al usuario seleccionado:");
        for (int u = 0; u < materiasList.size(); u++) {
            System.out.println(materiasList.get(u).getId() + "-" + materiasList.get(u).getNombre() + "-" + materiasList.get(u).getNotas());
        }

        System.out.println("Seleccione el id de la materia:");
        idMateria = entrada.nextInt();

        for (int j = 0; j <materiasList.size(); j++) {
            if (idMateria == materiasList.get(j).getId()){
                materia = materiasList.get(j);
                break;
            } else {
               materia=null;
            }
        }

        if (materia!=null){
            notasList = materia.getNotas();

            System.out.println("Las notas ingresadas actualmente son:");
            for (int k = 0; k < notasList.size(); k++) {
                System.out.println((k+1) + ".  Valor:" + notasList.get(k).getValor() + " -  Porcentaje:" + notasList.get(k).getPorcentaje());
            }

            System.out.println("Seleccione la nota a eliminar:");
            idNota = entrada.nextDouble();
            for (int l = 0; l < notasList.size(); l++) {
                if (idNota == (l+1) ){
                    notasList.remove(l);
                }
            }

            System.out.println("Las notas ingresadas actualmente son:");
            for (int k = 0; k < notasList.size(); k++) {
                System.out.println(notasList.get(k).getValor());
            }
        } else {
            System.out.println("La materia seleccionada no cuenta con notas asignadas");
        }


    }

}




