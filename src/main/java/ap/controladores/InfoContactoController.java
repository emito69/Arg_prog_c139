package ap.controladores;

import ap.app.Util;
import ap.modelos.Cliente;
import ap.modelos.InfoContacto;
import ap.repositorios.InfoContactoRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InfoContactoController {

    private InfoContactoRepository cr;

    public InfoContactoRepository getIr() {
        return cr;
    }

    public void setIr(InfoContactoRepository cr) {
        this.cr = cr;
    }

    public InfoContactoController() {
        this.cr = new InfoContactoRepository();
    }

    public void agregarInfoContacto(InfoContacto infoContacto) {

        cr.getEm().getTransaction().begin();
        cr.insertar(infoContacto);
        cr.getEm().getTransaction().commit();
    }

}
