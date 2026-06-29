package ar.candeyarossi.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UsuarioLogin {

    @NotBlank(message = "El correo es requerido.")
    @Email(message = "Por favor proporciona un correo válido.")
    private String email;

    @NotBlank(message = "Por favor proporciona una contraseña.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña necesita incluir al menos una letra mayúscula, una letra minúscula, un número y debe contener al menos 8 caracteres.")
    private String password;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsuarioLogin [email=" + email + ", password=" + password + "]";
    }
}
