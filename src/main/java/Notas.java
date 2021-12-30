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
        ArrayList<Usuario> usuariosList = new ArrayList<>();
        ArrayList<Materia> materiasList = new ArrayList<>();
        Notas nota = new Notas();
        Usuario usuario = new Usuario();
        Materia materia = new Materia();


        System.out.println("Seleccione el id del usuario");
        for (int i = 0; i < usuariosCreados.size(); i++) {
            System.out.println(usuariosCreados.get(i).toString());
        }
        idusuario = entrada.nextInt();
        for (int j = 0; j < usuariosCreados.size(); j++) {
            if (idusuario == usuariosCreados.get(j).getId()) {
                usuario = usuariosCreados.get(j);
            }
        }

        materiasList = usuario.getMateria();
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
        double valor;
        double porcentaje;
        ArrayList<Notas> notasList = new ArrayList<>();

        System.out.println("Cuantas notas desea ingresar a la materia:" + materia.getNombre());
        cantidadNotas = entrada.nextInt();
        for (int i = 0; i < cantidadNotas; i++) {
            System.out.println("Ingrese el valor de la nota: " +(i+1));
            valor = entrada.nextDouble();
            System.out.println("Ingrese el porcentaje de la nota: " +(i+1));
            porcentaje = entrada.nextDouble();
            //Notas nota = new Notas(valor, porcentaje);
            notasList.add(new Notas(valor, porcentaje));

        }
        return notasList;

    }

}




