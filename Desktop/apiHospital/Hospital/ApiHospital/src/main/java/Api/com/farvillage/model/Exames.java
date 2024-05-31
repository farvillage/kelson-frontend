package Api.com.farvillage.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Exames implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDeExame;

    @ManyToOne
    @JoinColumn(name = "Consulta_id")
    Consulta consulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeExame() {
        return tipoDeExame;
    }

    public void setTipoDeExame(String tipoDeExame) {
        this.tipoDeExame = tipoDeExame;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
