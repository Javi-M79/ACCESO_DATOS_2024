package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "coches")

public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String marca;
    @Column
    private String modelo;


    @OneToOne(mappedBy = "ficha")
    private Ficha ficha;

    public Coche(String marca, String modelo, Ficha ficha) {
        this.marca = marca;
        this.modelo = modelo;
        this.ficha = ficha;
    }
}
