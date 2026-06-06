package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManejoDeFechas {
    public static LocalDate formatoFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFormateada = LocalDate.parse(fecha, formato);
        return fechaFormateada;
    }
}
