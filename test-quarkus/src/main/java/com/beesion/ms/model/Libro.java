package com.beesion.ms.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Libro extends PanacheEntity {
    public String titulo;
    public String autor;
    public int anioPublicacion;
    public String genero;
}
