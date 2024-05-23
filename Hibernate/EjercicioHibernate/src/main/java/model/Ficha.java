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
@Table (name ="fichas")


public class Ficha {
    @Id
    @Column
    private int id;
    @Column
    private int anyo;
    @Column
    private boolean pasada;

    @OneToOne
    private Coche coche;

    public Ficha(int anyo, boolean pasada) {
        this.anyo = anyo;
        this.pasada = pasada;
    }
}
