// Ejercicio 05 - Integrador con try/catch - Cajero
public class Cajero {

    public static long leerMonto(String texto) {
        long monto;
        try {
            monto = Long.parseLong(texto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El monto debe ser un número entero: " + texto);
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        return monto;
    }

    public static String retirar(CuentaAhorros cuenta, String textoMonto, boolean cajeroPropio) {
        try {
            long monto = leerMonto(textoMonto);
            long costo = Tarifas.costoRetiro(cajeroPropio);
            cuenta.retirar(monto + costo);
            return "Retiro exitoso. Nuevo saldo: $" + cuenta.getSaldo();
        } catch (IllegalArgumentException e) {
            return "Retiro rechazado: " + e.getMessage();
        }
    }
}
