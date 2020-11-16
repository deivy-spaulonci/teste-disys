package com.testedisys.model;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Audited
@AuditTable(value="departamento_aud")
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int departamento_id;

    @NotNull(message = "Departamento não pode ser nulo")
    @NotEmpty(message = "Nome do Departamento não pode estar vazio")
    @Column(length = 50, nullable = false)
    private String departamento_name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="FUNCIONARIO_DEPARTAMENTO",
            joinColumns=@JoinColumn(name="departamento_id"),
            inverseJoinColumns=@JoinColumn(name="funcionario_id"))
    private Collection<Funcionario> funcionarios;

    public int getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }

    public String getDepartamento_name() {
        return departamento_name;
    }

    public void setDepartamento_name(String departamento_name) {
        this.departamento_name = departamento_name;
    }

    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return departamento_id == that.departamento_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamento_id);
    }
}
