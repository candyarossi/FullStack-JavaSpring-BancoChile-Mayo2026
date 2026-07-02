package ar.candeyarossi.demo.models;

import java.time.LocalDate;

public class VideojuegoUsuario {
    
    private Videojuego videojuego;
    private Usuario usuario;
    
    public VideojuegoUsuario(Object[] fila) {
        this.videojuego = new Videojuego((String) fila[3], (String) fila[1], (String) fila[4], LocalDate.parse(String.valueOf(fila[2])), (Double) fila[6]);
        this.videojuego.setId((Long) fila[0]);
        this.videojuego.setPrecio((Double) fila[5]);
        this.usuario = new Usuario((String) fila[12], (String) fila[9], (String) fila[11], (String) fila[13]);
        this.usuario.setId((Long) fila[8]);
        this.usuario.setCoins((Double) fila[10]);
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "VideojuegoUsuario [videojuego=" + videojuego + ", usuario=" + usuario + "]";
    }
}
