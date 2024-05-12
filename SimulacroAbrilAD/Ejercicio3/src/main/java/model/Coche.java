package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Entity

@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String cilindrada;
    @Column
    private String caballos;
    //Relacion
    @OneToOne(mappedBy = "coche")

    private Ficha ficha;


    public Coche(String marca, String modelo, String cilindrada, String caballos) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.caballos = caballos;

    }

    public Coche(String marca, String modelo, String cilindrada, String caballos, Ficha ficha) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.caballos = caballos;
        this.ficha = ficha;
    }

    public Coche(String marca, String modelo, String cilindrada, String caballos, int idFicha) {

        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.caballos = caballos;
        this.ficha.setId(idFicha);

    }
}
