package com.br.testedisys.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CARGO")
public class Cargo  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cargo_id;


    @NotNull(message = "Nome do cargo não pode ser nulo")
    @NotEmpty(message = "Nome do cargo não pode estar vazio")
    @Column(length = 50, nullable = false)
    private String cargo_name;

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getCargo_name() {
        return cargo_name;
    }

    public void setCargo_name(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return cargo_id == cargo.cargo_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo_id);
    }
}