package com.example.rubn.vainiya;

/**
 * Created by Rubén on 13/02/2015.
 */
public class Contacto {

    String nombre;
    String tlf;
    String email;
    String contraseña;
    String sexo;

    public Contacto(String nombre, String tlf, String email, String contraseña, String sexo) {
        this.nombre = nombre;
        this.tlf=tlf;
        this.email = email;
        this.contraseña = contraseña;
        this.sexo = sexo;

    }

    public Contacto(String nombre, String tlf, String email, String sexo) {
        this.nombre = nombre;
        this.tlf=tlf;
        this.email = email;
        this.sexo = sexo;
    }

    public Contacto(String nombre, String tlf, String email) {
        this.nombre = nombre;
        this.tlf=tlf;
        this.email = email;

    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
