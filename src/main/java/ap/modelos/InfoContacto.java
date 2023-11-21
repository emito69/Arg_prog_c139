package ap.modelos;

import lombok.Data;

import javax.persistence.*;

@Data   // Getters y Setters
@Entity
@Table(name="infoContacto")
public class InfoContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;

    @Column(name = "celular", nullable = false, length = 45)
    private String celular;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @OneToOne(mappedBy="infoContacto")
    private Persona persona;
}
