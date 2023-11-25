package ap.controladores;

import ap.modelos.SistemaOperativo;
import ap.repositorios.SistemaOperativoRespository;

public class SistemaOperativoController {

    private SistemaOperativoRespository sr;

    public SistemaOperativoRespository getSr() {
        return sr;
    }

    public void setSr(SistemaOperativoRespository sr) {
        this.sr = sr;
    }

    public SistemaOperativoController() {

        this.sr = new SistemaOperativoRespository();
    }

    public void agregarSistemaOperativo(String denominacion) {

        SistemaOperativo sistemaOperativo = new SistemaOperativo();

        sistemaOperativo.setDenominacion(denominacion);

        sr.getEm().getTransaction().begin();
        sr.insertar(sistemaOperativo);
        sr.getEm().getTransaction().commit();
    }

    public void actualizarSistemaOperativo(SistemaOperativo sistemaOperativo) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(sistemaOperativo);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarSistemasOperativos() {
        System.out.println("Sistemas Operativos: ");
        sr.buscarSistemasOperativos().forEach(
                sistemaOperativo -> System.out.println(sistemaOperativo));
        System.out.println();
    }

    public SistemaOperativo buscarSistemaOperativoId(int nroSistemaOperativo) {
        SistemaOperativo sistemaOperativo = sr.buscarUnId(nroSistemaOperativo);
        System.out.println(sistemaOperativo);
        return sistemaOperativo;
    }

}
