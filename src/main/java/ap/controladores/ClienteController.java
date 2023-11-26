package ap.controladores;

import ap.app.Util;
import ap.modelos.Cliente;
import ap.repositorios.ClienteRepository;

import java.sql.Date;
import java.util.Scanner;

public class ClienteController {

    private ClienteRepository cr;
    //private InfoContactoRepository ir;
    //private InfoContactoController ic;


    public ClienteRepository getCr() {
        return cr;
    }

    public void setCr(ClienteRepository cr) {
        this.cr = cr;
    }

    public ClienteController() {

        this.cr = new ClienteRepository();
    }

    public void agregarCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.next();

        System.out.print("Ingrese el apellido del cliente: ");
        String apellidoCliente = scanner.next();

        System.out.print("Ingrese el cuit del cliente: ");
        String cuitCliente = scanner.next();

        System.out.print("Ingrese la razon social del cliente: ");
        String razonSocialtCliente = scanner.next();

        Util util = new Util();

        System.out.print("Ingrese el fecha nacimiento del cliente (dd/MM/yyyy): ");
        String fechaString= scanner.next();
        //Timestamp fechaNacCliente = Timestamp.valueOf(fechaString + " 00:00:00.1");
        Date fechaNacCliente =  util.getSQLDate(fechaString);

        Cliente cliente = new Cliente();

        cliente.setNombre(nombreCliente);
        cliente.setApellido(apellidoCliente);
        cliente.setCuit(cuitCliente);
        cliente.setRazon_social(razonSocialtCliente);
        cliente.setFechaNacim(fechaNacCliente);

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
        cr.insertar(cliente);
        cr.getEm().getTransaction().commit();

        System.out.println("Cliente agregado con éxito.\n");
    }

    public void actualizarCliente(Cliente cliente) {
        cr.getEm().getTransaction().begin();
        cr.actualizar(cliente);
        cr.getEm().getTransaction().commit();
    }

    public void mostrarClientes() {
        System.out.println("Clientes: ");
        cr.buscarClientes().forEach(
                cliente -> System.out.println(cliente));
        System.out.println();
    }

    public Cliente buscarClienteId(int nroCliente) {
        Cliente cliente = cr.buscarUnId(nroCliente);
        //System.out.println(cliente);
        return cliente;
    }

}
