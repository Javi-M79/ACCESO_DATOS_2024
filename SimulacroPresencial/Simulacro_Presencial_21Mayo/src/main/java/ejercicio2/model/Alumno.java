package ejercicio2.model;

/*2.	Crea una base de datos llamada examen con una tabla que sea alumno con los datos nombre, apellido, correo.
 Desde java, crea una función que permita guardar en dicha tabla un usuario con datos metidos desde consola*/


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//CLASE POJO

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "alumno")

public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_alumno;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;





    public Alumno(String nombre, String apellido, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

}
