// ============================================================
// Ejercicio 04 · Métodos static y constantes · Tarifas
// ============================================================
// Las tarifas del banco son las mismas para todos los clientes:
// no dependen de ninguna cuenta. Por eso esta clase solo tiene
// constantes y métodos static (no se crean objetos Tarifas).
//
// Construye la clase Tarifas:
//   - Cinco constantes public static final:
//       COSTO_RETIRO_OTRO_BANCO = 7_000      (long)
//       COSTO_RETIRO_ADICIONAL  = 2_000      (long)
//       RETIROS_GRATIS_AL_MES   = 3          (int)
//       CUOTA_MANEJO            = 12_900     (long)
//       SALDO_SIN_CUOTA         = 1_000_000  (long)
//   - public static long costoRetiro(boolean cajeroPropio, int numeroDeRetiro)
//       · numeroDeRetiro menor que 1 → IllegalArgumentException
//       · en cajero de otro banco: siempre COSTO_RETIRO_OTRO_BANCO
//       · en cajero propio: los primeros 3 retiros del mes cuestan 0;
//         del 4.º en adelante, COSTO_RETIRO_ADICIONAL
//   - public static long costoRetiro(boolean cajeroPropio)
//       · el costo de un primer retiro del mes. Reutiliza el anterior.
//   - public static long cuotaManejo(long saldoPromedio)
//       · saldo negativo → IllegalArgumentException
//       · saldo de SALDO_SIN_CUOTA o más → 0
//       · si no → CUOTA_MANEJO
//
// Ejemplos:
//   Tarifas.costoRetiro(true)          → 0
//   Tarifas.costoRetiro(false)         → 7000
//   Tarifas.costoRetiro(true, 3)       → 0
//   Tarifas.costoRetiro(true, 4)       → 2000
//   Tarifas.cuotaManejo(999_999)       → 12900
//   Tarifas.cuotaManejo(1_000_000)     → 0
//
// Pista: escribe las constantes en los métodos, nunca los números sueltos.
// ============================================================

public class Tarifas {

    //Construir las 5 tarifas

    public static final long COSTO_RETIRO_OTRO_BANCO = 7_000;
    public static final long COSTO_RETIRO_ADICIONAL = 2_000;
    public static final int RETIROS_GRATIS_AL_MES = 3;
    public static final long CUOTA_MANEJO = 12_900;
    public static final long SALDO_SIN_CUOTA = 1_000_000;

    // crear condiciones de retiro infeior a 1, Cajero de otro banco, Cajero propio

    public static long costoRetiro(boolean cajeroPropio, int numeroDeRetiro) {
        if (numeroDeRetiro < 1) {
            throw new IllegalArgumentException("El número de retiro debe ser 1 o más");
        }
        if (!cajeroPropio) {
            return COSTO_RETIRO_OTRO_BANCO;
        }
        if (numeroDeRetiro <= RETIROS_GRATIS_AL_MES) {
            return 0;
        }
        return COSTO_RETIRO_ADICIONAL;
    }

    //Llamar a la anterior e ingresar costo del primer retiro del mes

    public static long costoRetiro(boolean cajeroPropio) {
        return costoRetiro(cajeroPropio, 1);
    }

    // Saldo promedio

    public static long cuotaManejo(long saldoPromedio) {
        if (saldoPromedio < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        if (saldoPromedio >= SALDO_SIN_CUOTA) {
            return 0;
        }
        return CUOTA_MANEJO;
    }

}
