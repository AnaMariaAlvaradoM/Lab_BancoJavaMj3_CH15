// Ejercicio 04 - Métodos static y constantes - Tarifas
public class Tarifas {

    public static final long COSTO_RETIRO_OTRO_BANCO = 7_000;
    public static final long COSTO_RETIRO_ADICIONAL = 2_000;
    public static final int RETIROS_GRATIS_AL_MES = 3;
    public static final long CUOTA_MANEJO = 12_900;
    public static final long SALDO_SIN_CUOTA = 1_000_000;

    public static long costoRetiro(boolean cajeroPropio, int numeroDeRetiro) {
        if (numeroDeRetiro < 1) {
            throw new IllegalArgumentException("El número de retiro debe ser 1 o mayor");
        }
        if (!cajeroPropio) {
            return COSTO_RETIRO_OTRO_BANCO;
        }
        if (numeroDeRetiro <= RETIROS_GRATIS_AL_MES) {
            return 0;
        }
        return COSTO_RETIRO_ADICIONAL;
    }

    public static long costoRetiro(boolean cajeroPropio) {
        return costoRetiro(cajeroPropio, 1);
    }

    public static long cuotaManejo(long saldoPromedio) {
        if (saldoPromedio < 0) {
            throw new IllegalArgumentException("El saldo promedio no puede ser negativo");
        }
        if (saldoPromedio >= SALDO_SIN_CUOTA) {
            return 0;
        }
        return CUOTA_MANEJO;
    }
}
