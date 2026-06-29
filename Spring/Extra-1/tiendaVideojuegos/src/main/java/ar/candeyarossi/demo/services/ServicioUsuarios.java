package ar.candeyarossi.demo.services;

import java.util.HashMap;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.UsuarioLogin;
import ar.candeyarossi.demo.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return (List<Usuario>) this.repositorioUsuarios.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        return this.repositorioUsuarios.findByEmail(email).orElse(null);
    }

    public Usuario crearUsuario(Usuario usuario) {
        String newPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(newPassword);
        return this.repositorioUsuarios.save(usuario);
    }

    public Usuario modificarUsuario(Usuario usuario) {
        return this.repositorioUsuarios.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        this.repositorioUsuarios.deleteById(id);
    }

    public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
        Usuario usuarioDB = this.obtenerUsuarioPorEmail(usuario.getEmail());
        if (usuarioDB != null) {
            validaciones.rejectValue("email", "emailExistente",
                    "El correo electrónico ingresado está siendo utilizado por otro usuario.");
        } else {
            if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
                validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "Las contraseñas no coinciden.");
            }
        }
        return validaciones;
    }

    public HashMap<String, Object> validarLogin(BindingResult validaciones, UsuarioLogin usuarioLogin) {
        HashMap<String, Object> resultado = new HashMap<>();
        Usuario usuarioDB = this.obtenerUsuarioPorEmail(usuarioLogin.getEmail());

        System.out.println(
                BCrypt.checkpw(
                        "Abcd1234",
                        "$2a$10$8S3.8PRovFY4O2QVqNU8yOM10sx5qVJSfCdsKfS5pHSWsrpxaFhSG"));

        System.out.println("Password ingresada: [" + usuarioLogin.getPassword() + "]");
        System.out.println("Email ingresado: [" + usuarioLogin.getEmail() + "]");

        if (usuarioDB == null) {
            validaciones.rejectValue("email", "emailInexistente",
                    "El correo electrónico ingresado no corresponde a un usuario registrado.");
        } else {
            if (!BCrypt.checkpw(usuarioLogin.getPassword(), usuarioDB.getPassword())) {
                validaciones.rejectValue("password", "passwordIncorrecta", "Contraseña incorrecta.");
            } else {
                resultado.put("usuario", usuarioDB);
            }
        }
        resultado.put("validaciones", validaciones);
        return resultado;
    }
}
