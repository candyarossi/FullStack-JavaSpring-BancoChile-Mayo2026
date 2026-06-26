package com.javaSpring.examen.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioLogin {

    @NotBlank(message = "Por favor proporciona tu correo.")
    @Email(message = "Por favor ingresa un correo válido.")
    private String correo;

    @NotBlank(message = "Por favor proporciona tu contraseña.")
    @Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    private String password;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsuarioLogin [correo=" + correo + ", password=" + password + "]";
    }
}
