package com.br.testedisys.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int funcionario_id;

    @NotNull(message = "Nome do funcionário não pode ser nulo")
    @NotEmpty(message = "Nome do funcionário não pode estar vazio")
    @Column(length = 50, nullable = false)
    private String funcionario_name;

    @NotNull(message = "Data de nascimento do funcionário não pode ser nulo")
    @NotEmpty(message = "Data de nascimento não pode estar vazio")
    @Column(nullable = false)
    private LocalDate funcionario_birthday;

    @NotNull(message = "Documento do funcionário não pode ser nulo")
    @NotEmpty(message = "Documento do funcionário não pode estar vazio")
    @Column(length = 50, nullable = false)
    private String funcionario_document;

    @NotNull(message = "Cargo do Funcinário não pode ser nulo")
    @ManyToOne(optional = false)
    @JoinColumn(name = "CARGO_ID")
    private Cargo cargo;

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public String getFuncionario_name() {
        return funcionario_name;
    }

    public void setFuncionario_name(String funcionario_name) {
        this.funcionario_name = funcionario_name;
    }

    public LocalDate getFuncionario_birthday() {
        return funcionario_birthday;
    }

    public void setFuncionario_birthday(LocalDate funcionario_birthday) {
        this.funcionario_birthday = funcionario_birthday;
    }

    public String getFuncionario_document() {
        return funcionario_document;
    }

    public void setFuncionario_document(String funcionario_document) {
        this.funcionario_document = funcionario_document;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Transient
    public int getAge(){
        return Period.between( getFuncionario_birthday(), LocalDate.now()).getDays();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return funcionario_id == that.funcionario_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcionario_id);
    }
}
