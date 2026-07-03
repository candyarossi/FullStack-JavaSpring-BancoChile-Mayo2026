package ar.candeyarossi.demo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class ServicioImagenes {

    private static final String ruta = "C:/Users/cyaro/Desktop/FullStack-JavaSpring-BancoChile-Mayo2026/Spring/Extra-2/tiendaVideojuegos/src/main/resources/static";

    public static String uploadFile(MultipartFile imagen) throws Exception {
        if (imagen.isEmpty()) {
            throw new Exception("El archivo de imagen no se ha cargado correctamente.");
        }

        try {
            File directorio = new File(ruta + "/images/");
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
            String nombreImagen = imagen.getOriginalFilename();
            Path path = Paths.get(ruta + "/images/" + nombreImagen);
            imagen.transferTo(path.toFile());
            return "/images/" + nombreImagen;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean deleteFile(String imagen) {
        File directorio = new File(ruta + imagen);
        if (directorio.exists()) {
            directorio.delete();
            return true;
        }
        return false;
    }
}
