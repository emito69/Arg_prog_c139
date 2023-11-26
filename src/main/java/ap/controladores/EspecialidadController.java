package ap.controladores;

import ap.modelos.Aplicacion;
import ap.modelos.Especialidad;
import ap.modelos.SistemaOperativo;
import ap.repositorios.EspecialidadRepository;

public class EspecialidadController {

    private EspecialidadRepository sr;

    public EspecialidadRepository getSr() {
        return sr;
    }

    public void setSr(EspecialidadRepository sr) {
        this.sr = sr;
    }

    public EspecialidadController() {

        this.sr = new EspecialidadRepository();
    }

    public void agregarEspecialidad(Aplicacion aplicacion, SistemaOperativo sistemaOperativo) {

        Especialidad especialidad = new Especialidad();

        especialidad.setSistemaoperativo(sistemaOperativo);
        especialidad.setAplicacion(aplicacion);

        sr.getEm().getTransaction().begin();
        sr.insertar(especialidad);
        sr.getEm().getTransaction().commit();

        System.out.println("Especialidad agregada con éxito.\n");
    }

    public void actualizarEspecialidad(Especialidad especialidad) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(especialidad);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarEspecialidades() {
        System.out.println("Especialidades: ");
        sr.buscarEspecialidades().forEach(
                especialidad -> System.out.println(especialidad));
        System.out.println();
    }

    public Especialidad buscarEspecialidadId(int nroEspecialidad) {
        Especialidad especialidad = sr.buscarUnId(nroEspecialidad);
        System.out.println(especialidad);
        return especialidad;
    }


}
