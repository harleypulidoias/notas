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
            System.out.println("Ingrese el valor de la nota: " +(i+1));
            valor = entrada.nextDouble();
            System.out.println("Ingrese el porcentaje de la nota: " +(i+1));
            porcentaje = (double) entrada.nextDouble();
            //Notas nota = new Notas(valor, porcentaje);
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

}




