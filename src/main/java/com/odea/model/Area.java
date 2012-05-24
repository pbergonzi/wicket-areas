package com.odea.model;

public class Area {
    private long id;
    private String alias;
    private String nombre;
    private String pais;

    public Area() {}

    public Area(long id, String alias, String nombre, String pais) {
        this.id = id;
        this.alias = alias;
        this.nombre = nombre;
        this.pais = pais;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
