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
@Table(name = "fichas")

public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFicha")
    private long id;
    @Column
    private String anyo;
    @Column
    private boolean itv;

    @OneToOne(mappedBy = "ficha", cascade = CascadeType.ALL)
    @JoinColumn(name = "IdCoche", foreignKey = @ForeignKey(name = "IdCoche"))

    private Coche coche;

    public Ficha(String anyo, boolean itv, Coche coche) {
        this.anyo = anyo;
        this.itv = itv;
        this.coche = coche;
    }

    public Ficha(String anyo, boolean itv) {
        this.anyo = anyo;
        this.itv = itv;
    }
}
