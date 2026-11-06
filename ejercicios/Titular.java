// Ejercicio 01 - Clase, constructor y setter - Titular
public class Titular {

    private String nombre;
    private String documento;
    private String celular;

    public Titular(String nombre, String documento) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento no puede estar vacío");
        }
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if (celular == null || celular.length() != 10 || !celular.startsWith("3")) {
            throw new IllegalArgumentException("Celular inválido: " + celular);
        }
        this.celular = celular;
    }
}
