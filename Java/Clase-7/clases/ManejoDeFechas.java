package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ManejoDeFechas {
    static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    default LocalDate formatoFecha(String fecha) {
        LocalDate fechaFormateada = LocalDate.parse(fecha, formato);
        return fechaFormateada;
    }
}
