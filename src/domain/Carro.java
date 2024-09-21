package domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "carro_seq", allocationSize = 1)
    private Long id;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "MARCA_ID", nullable = false)
    private Marca marca;

    @ManyToMany
    @JoinTable(
            name = "TB_CARRO_ACESSORIO",
            joinColumns = @JoinColumn(name = "CARRO_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACESSORIO_ID")
    )
    private List<Acessorio> acessorios;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}

