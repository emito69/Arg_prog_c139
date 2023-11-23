package ap.modelos;

import lombok.Data;

import javax.persistence.*;

@Data   // Getters y Setters
@Entity
@Table(name="infoContacto")
public class InfoContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(mappedBy="infoContacto")
    private Persona persona;
}
