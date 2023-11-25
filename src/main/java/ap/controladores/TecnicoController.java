package ap.controladores;

import ap.app.Util;
import ap.modelos.Aplicacion;
import ap.modelos.Cliente;
import ap.modelos.Especialidad;
import ap.modelos.Tecnico;
import ap.repositorios.TecnicoRepository;

import javax.persistence.Column;
import java.sql.ClientInfoStatus;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TecnicoController {
    private TecnicoRepository tr;

    public TecnicoRepository getTr() {
        return tr;
    }

    public void setTr(TecnicoRepository tr) {
        this.tr = tr;
    }

    public TecnicoController() {
        this.tr = new TecnicoRepository();
    }

    public void agregarTecnico(Scanner scanner, List<Especialidad> especialidades) {

        System.out.print("Ingrese el nombre del tecnico: ");
        String nombreTecnico = scanner.next();

        System.out.print("Ingrese el apellido del tecnico: ");
        String apellidoTectnico = scanner.next();

        Util util = new Util();
        System.out.print("Ingrese el fecha nacimiento del Tecnico (dd/MM/yyyy): ");
        String fechaString = scanner.next();
        //Timestamp fechaNacCliente = Timestamp.valueOf(fechaString + " 00:00:00.1");
        Date fechaNacCliente = util.getSQLDate(fechaString);


        System.out.print("Ingrese el email : ");
        String mail = scanner.next();

        System.out.print("Ingrese el telefono fijo: ");
        String telefono = scanner.next();

        System.out.print("Ingrese número de celular: ");
        String celular = scanner.next();

        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.next();

        System.out.print("Ingrese el id de la  especialidad: ");
         int especialidad = scanner.nextInt();


        Tecnico tecnico = new Tecnico();

        tecnico.setNombre(nombreTecnico);
        tecnico.setApellido(apellidoTectnico);
        tecnico.setFechaNacim(fechaNacCliente);
        tecnico.setEmail(mail);
        tecnico.setTelefono(telefono);
        tecnico.setCelular(celular);
        tecnico.setDireccion(direccion);

        ArrayList<Especialidad> especialidads = new ArrayList<>();
        for (Especialidad especialidade : especialidades) {
            if (especialidade.getId() == especialidad) {
                especialidads.add(especialidade);
            }
        }


        tecnico.setEspecialidades(especialidads);




        tr.getEm().getTransaction().begin();
        tr.insertar(tecnico);
        tr.getEm().getTransaction().commit();

        System.out.println("Tecnico agregado con éxito.\n");
    }

   public void mostrarTecnicos() {
        System.out.println("Tecnicos: ");
        tr.buscarTecnicos().forEach(
                tecnico -> System.out.println(tecnico));
        System.out.println();
    }

    public Tecnico buscarTecnicoId(int id) {
        Tecnico tecnico = tr.buscarUnId(id);
        System.out.println(tecnico);
        return tecnico;
    }

}