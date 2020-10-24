package com.study.jpa.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class DirectorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String directorId;

    public DirectorDTO(Long id, String name, String directorId) {
        this.id = id;
        this.name = name;
        this.directorId = directorId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorId() {
        return this.directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DirectorDTO)) {
            return false;
        }
        DirectorDTO directorDTO = (DirectorDTO) o;
        return Objects.equals(id, directorDTO.id) && Objects.equals(name, directorDTO.name)
                && Objects.equals(directorId, directorDTO.directorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, directorId);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", directorId='" + getDirectorId() + "'"
                + "}";
    }

}
