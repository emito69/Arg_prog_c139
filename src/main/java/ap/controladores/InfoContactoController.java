package ap.controladores;

import ap.modelos.InfoContacto;
import ap.repositorios.InfoContactoRepository;

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
