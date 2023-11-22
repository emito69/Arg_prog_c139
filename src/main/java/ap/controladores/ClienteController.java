package ap.controladores;

import ap.app.Util;
import ap.modelos.Cliente;
import ap.repositorios.ClienteRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ClienteController {

    private ClienteRepository cr;

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


        cr.getEm().getTransaction().begin();
        cr.insertar(cliente);
        cr.getEm().getTransaction().commit();

        System.out.println("Cliente agregado con éxito.\n");
    }

    public void mostrarClientes() {
        System.out.println("Clientes: ");
        cr.buscarClientes().forEach(
                cliente -> System.out.println(cliente));
        System.out.println();
    }

    public Cliente buscarClienteId(int nroCliente) {
        Cliente cliente = cr.buscarUnId(nroCliente);
        System.out.println(cliente);
        return cliente;
    }

}
