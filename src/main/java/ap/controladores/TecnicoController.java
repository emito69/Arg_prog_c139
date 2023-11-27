package ap.controladores;

import ap.app.Util;
import ap.modelos.Tecnico;
import ap.repositorios.TecnicoRepository;

import java.sql.Date;
import java.util.Scanner;

public class TecnicoController {

    private TecnicoRepository cr;
    //private InfoContactoRepository ir;
    //private InfoContactoController ic;


    public TecnicoRepository getCr() {
        return cr;
    }

    public void setCr(TecnicoRepository cr) {
        this.cr = cr;
    }

    public TecnicoController() {

        this.cr = new TecnicoRepository();
    }

    public void agregarTecnico(Scanner scanner) {
        System.out.print("Ingrese el nombre del Tecnico: ");
        String nombreTecnico = scanner.next();

        System.out.print("Ingrese el apellido del Tecnico: ");
        String apellidoTecnico = scanner.next();

        Util util = new Util();

        System.out.print("Ingrese el fecha nacimiento del Tecnico (dd/MM/yyyy): ");
        String fechaString= scanner.next();
        //Timestamp fechaNacCliente = Timestamp.valueOf(fechaString + " 00:00:00.1");
        Date fechaNacTecnico =  util.getSQLDate(fechaString);

        Tecnico tecnico = new Tecnico();

        tecnico.setNombre(nombreTecnico);
        tecnico.setApellido(apellidoTecnico);
        tecnico.setFechaNacim(fechaNacTecnico);

        /* EMILIMINE CLASE infoContacto
        System.out.print("Ingrese dirección del cliente: ");
        String direCliente = scanner.next();
        System.out.print("Ingrese el email del cliente: ");
        String emailCliente = scanner.next();
        System.out.print("Ingrese el teléfono del cliente: ");
        String teleCliente = scanner.next();
        System.out.print("Ingrese el celular del cliente: ");
        String celularCliente = scanner.next();

        InfoContacto infoContacto = new InfoContacto();

        infoContacto.setCelular(celularCliente);
        infoContacto.setTelefono(teleCliente);
        infoContacto.setDireccion(direCliente);
        infoContacto.setEmail(emailCliente);

        ic.getIr().setEm(cr.getEm());
        ic.agregarInfoContacto(infoContacto);
        cliente.setInfoContacto(infoContacto);
        */

        cr.getEm().getTransaction().begin();
        cr.insertar(tecnico);
        cr.getEm().getTransaction().commit();

        System.out.println("Técnico agregado con éxito.\n");
    }

    public void agregarTecnicoConDatos(String nombreTecnico, String apellidoTecnico, String fechaNacTecnicoS) {

        Util util = new Util();

        Date fechaNacTecnico =  util.getSQLDate(fechaNacTecnicoS);

        Tecnico tecnico = new Tecnico();

        tecnico.setNombre(nombreTecnico);
        tecnico.setApellido(apellidoTecnico);
        tecnico.setFechaNacim(fechaNacTecnico);

        cr.getEm().getTransaction().begin();
        cr.insertar(tecnico);
        cr.getEm().getTransaction().commit();

        System.out.println("Técnico agregado con éxito.\n");
    }

    public void actualizarTecnico(Tecnico tecnico) {
        cr.getEm().getTransaction().begin();
        cr.actualizar(tecnico);
        cr.getEm().getTransaction().commit();
    }

    public void mostrarTecnicos() {
        System.out.println("Tecnicos: ");
        cr.buscarTecnicos().forEach(
                tecnico -> System.out.println(tecnico));
        System.out.println();
    }

    public Tecnico buscarTecnicoId(int nroTecnico) {
        Tecnico tecnico = cr.buscarUnId(nroTecnico);
        //System.out.println(tecnico);
        return tecnico;
    }

}
