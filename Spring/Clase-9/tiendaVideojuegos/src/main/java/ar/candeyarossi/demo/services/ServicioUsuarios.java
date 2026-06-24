package ar.candeyarossi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    // OPERACIONES LECTURA -> SELECT
    public List<Usuario> obtenerTodosLosUsuarios() {
        return (List<Usuario>) this.repositorioUsuarios.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        return this.repositorioUsuarios.findByEmail(email).orElse(null);
    }

    // OPERACION CREACION -> INSERT
    // OPERACION MODIFICACION -> UPDATE
    public Usuario crearModificarUsuario(Usuario usuario) {
        return this.repositorioUsuarios.save(usuario);
    }

    // OPERACION BORRADO -> DELETE
    public void eliminarUsuario(Long id) {
        this.repositorioUsuarios.deleteById(id);
    }

    public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
        if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
            validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "Las contraseñas no coinciden");
        }
        return validaciones;
    }
}
