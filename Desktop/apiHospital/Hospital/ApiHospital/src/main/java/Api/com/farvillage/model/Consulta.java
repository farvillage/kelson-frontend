package Api.com.farvillage.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String horaDaConsulta;

    private String Descricao;

    @ManyToOne
    @JoinColumn(name = "doutor_id")
    Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    Paciente paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraDaConsulta() {
        return horaDaConsulta;
    }

    public void setHoraDaConsulta(String horaDaConsulta) {
        this.horaDaConsulta = horaDaConsulta;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
