import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private int id;
    private String primerNombre;
    private String segunNombre;
    private String apellidos;
    Carrera carrera;
    ArrayList<Materia> materia;
    Scanner entrada = new Scanner(System.in);

    public Usuario(int id, String primerNombre, String segunNombre, String apellidos, Carrera carrera, ArrayList<Materia> materia) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segunNombre = segunNombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.materia = materia;
    }

    public Usuario(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegunNombre() {
        return segunNombre;
    }

    public void setSegunNombre(String segunNombre) {
        this.segunNombre = segunNombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public ArrayList<Materia> getMateria() {
        return materia;
    }

    public void setMateria(ArrayList<Materia> materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", segunNombre='" + segunNombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", carrera=" + carrera +
                ", materia=" + materia +
                '}';
    }

    public void listarUsuarios(ArrayList<Usuario> usuarios){

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).toString());
        }

    }

    public ArrayList agregarUsuario(ArrayList<Usuario> usuariosList, ArrayList<Carrera> carrerasList, ArrayList<Materia> materiasCreadas){
        int idCarrera, cantMaterias, idMateria;
        ArrayList<Materia> materiasList = new ArrayList<>();
        Usuario usuario = new Usuario();
        Carrera carrera = new Carrera();
        Materia materia = new Materia();
        System.out.println("Ingrese el id del usuario");
        usuario.setId(entrada.nextInt());
        System.out.println("Ingrese el primer nombre del usuario");
        usuario.setPrimerNombre(entrada.next());
        System.out.println("Ingrese el segundo nombre del usuario");
        usuario.setSegunNombre(entrada.next());
        System.out.println("Ingrese el apellido del usuario");
        usuario.setApellidos(entrada.next());
        System.out.println("Seleccione el id de la carrera");
        carrera = carrera.buscarCarrera(carrerasList);
        usuario.setCarrera(carrera);
        do {
            System.out.println("Cuantas materias desea matricular?");
            System.out.println("Sólo hay "+materiasCreadas.size()+" materias disponibles");
            cantMaterias = entrada.nextInt();
        }while (cantMaterias>materiasCreadas.size());
        materiasList = materia.agregarMateria(cantMaterias, materiasCreadas, carrera.getCreditosTot());
        if (materiasList.size() == cantMaterias){
            usuario.setMateria(materiasList);
            usuariosList.add(usuario);
            System.out.println("Usuario creado correctamente");
        }else {
            System.out.println("Error al crear el usuario:");
            System.out.println("La cantidad de creditos de las materias superan el permitido por la Carrera "+carrera.getCreditosTot());
        }

        return usuariosList;
    }

    public Usuario buscarUsuario(ArrayList<Usuario> usuariosList){
        Usuario usuario = new Usuario();
        int idusuario;

        System.out.println("Seleccione el id del usuario");
        for (int i = 0; i < usuariosList.size(); i++) {
            System.out.println(usuariosList.get(i).toString());
        }
        idusuario = entrada.nextInt();
        for (int j = 0; j < usuariosList.size(); j++) {
            if (idusuario == usuariosList.get(j).getId()) {
                usuario = usuariosList.get(j);
            }
        }

        return usuario;
    }


    public void modificarUsuario(ArrayList<Usuario> usuariosList, ArrayList<Materia> materiasCreadas){
        Usuario usuario = new Usuario();
        Carrera carrera = new Carrera();
        Materia materia = new Materia();
        ArrayList<Carrera> carrerasList = new ArrayList<>();
        ArrayList<Materia> materiasList = new ArrayList<>();
        carrerasList = carrera.creacionCarreras();
        int opcion, opcion2;

        usuario = usuario.buscarUsuario(usuariosList);
        do {
            System.out.println("Cuál dato desea modificar del usuario :"+usuario.getPrimerNombre()+" \n" +
                    "\n 1) Primer nombre" +
                    "\n 2) Segundo nombre" +
                    "\n 3) Apellido" +
                    "\n 4) Carrera" +
                    "\n 5) Materias" +
                    "\n 7) Volver al menu principal");
            opcion = entrada.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("Ingrese el NUEVO Primer Nombre del usuario "+usuario.getPrimerNombre());
                    usuario.setPrimerNombre(entrada.next());
                    break;
                case 2:
                    System.out.println("Ingrese el NUEVO Segundo Nombre del usuario "+usuario.getPrimerNombre());
                    usuario.setSegunNombre(entrada.next());
                    break;
                case 3:
                    System.out.println("Ingrese el NUEVO Apellido del usuario "+usuario.getPrimerNombre());
                    usuario.setApellidos(entrada.next());
                    break;
                case 4:
                    System.out.println("Seleccione la nueva carrera Apellido del usuario "+usuario.getPrimerNombre());
                    carrera = carrera.buscarCarrera(carrerasList);
                    usuario.setCarrera(carrera);
                    break;
                case 5:
                    do {
                        System.out.println("1. Agregar materia \n"+
                                            "2. Eliminar materia \n"+
                                            "3. Salir");
                        opcion2 = entrada.nextInt();
                        switch (opcion2){
                            case 1:
                                materia = materia.agregarUnidadMat(materiasCreadas);
                                materiasList = usuario.getMateria();
                                materiasList.add(materia);
                                break;
                            case 2:
                                materia.eliminarMatArray(usuario.getMateria());
                                break;
                        }
                    }while (opcion2!=3);

                    break;
            }

        }while (opcion!=7);

    }
}
