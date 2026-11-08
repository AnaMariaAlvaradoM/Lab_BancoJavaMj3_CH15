// ============================================================
// Ejercicio 03 · Métodos que devuelven y sobrecarga · Cdt
// ============================================================
// Un CDT (certificado de depósito a término) guarda un monto
// durante unos días y paga intereses al final.
// Regla de Banco Cordillera: interés simple con año de 360 días.
//
//     intereses = monto × tasaAnual × días / 360   (redondeado)
//
// Construye la clase Cdt:
//   - Tres constantes public static final:
//       MONTO_MINIMO = 500_000 (long)
//       DIAS_MINIMOS = 30      (int)
//       DIAS_MAXIMOS = 540     (int)
//   - Tres campos privados: monto (long), dias (int) y tasaAnual (double).
//   - Un constructor público Cdt(long monto, int dias, double tasaAnual).
//       · monto menor que MONTO_MINIMO           → IllegalArgumentException
//       · dias fuera de 30 a 540 (límites válidos) → IllegalArgumentException
//       · tasaAnual 0 o menos, o mayor que 0.2   → IllegalArgumentException
//   - Getters: getMonto(), getDias() y getTasaAnual(). Sin setters.
//   - public long calcularIntereses()  → con los días del CDT.
//   - public long calcularIntereses(int otrosDias) → simula otro plazo
//     sin cambiar el CDT. Los otrosDias siguen la misma regla de 30 a 540.
//   - public long calcularTotalAlVencimiento() → monto + intereses.
//   - Un método private void validarDias(int dias) con la regla de los
//     días. Úsalo en el constructor y en calcularIntereses(int), para
//     no escribir el mismo if dos veces.
//
// Ejemplos:
//   Cdt cdt = new Cdt(1_000_000, 90, 0.09);
//   cdt.calcularIntereses()            → 22500
//   cdt.calcularTotalAlVencimiento()   → 1022500
//   cdt.calcularIntereses(180)         → 45000  (y getDias() sigue en 90)
//   new Cdt(499_999, 90, 0.09)         → IllegalArgumentException
//
// Pista: Math.round(...) redondea un double y devuelve un long.
// ============================================================

public class Cdt {

    // Tu código aquí
    public static final long MONTO_MINIMO = 500_000;
    public static final int DIAS_MINIMOS = 30;
    public static final int DIAS_MAXIMOS = 540;

    private long monto;
    private int dias;
    private double tasaAnual;

    // constructor
    public Cdt(long monto, int dias, double tasaAnual) {
        if (monto < MONTO_MINIMO) {
            throw new IllegalArgumentException("Monto menor al minimo");
        }
        validarDias(dias);

        if (tasaAnual <= 0 || tasaAnual > 0.2) {
            throw new IllegalArgumentException("debe ser mayor que 0 y menor 0 igual 0.2 la tasa anual");
        } else {
            this.monto = monto;
            this.dias = dias;
            this.tasaAnual = tasaAnual;
        }
    }

    public long getMonto() {
        return monto;
    }

    public int getDias() {
        return dias;
    }

    public double getTasaAnual() {
        return tasaAnual;
    }

    public long calcularIntereses() {
        double intereses = monto * tasaAnual * dias / 360;
        return (long) intereses;
    }

    public long calcularIntereses(int otrosDias) {
        validarDias(otrosDias);
        double interese = monto * tasaAnual * otrosDias / 360;
        return (long) interese;
    }

    public long calcularTotalAlVencimiento() {
        return monto + calcularIntereses();
    }

    private void validarDias(int dias) {
        if (dias < DIAS_MINIMOS || dias > DIAS_MAXIMOS) {
            throw new IllegalArgumentException("los dias deben estar entre 30 y 540");
        }
    }

}
