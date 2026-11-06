// Ejercicio 03 - Métodos que devuelven y sobrecarga - Cdt
public class Cdt {

    public static final long MONTO_MINIMO = 500_000;
    public static final int DIAS_MINIMOS = 30;
    public static final int DIAS_MAXIMOS = 540;

    private long monto;
    private int dias;
    private double tasaAnual;

    public Cdt(long monto, int dias, double tasaAnual) {
        if (monto < MONTO_MINIMO) {
            throw new IllegalArgumentException("El monto mínimo es $" + MONTO_MINIMO);
        }
        validarDias(dias);
        if (tasaAnual <= 0 || tasaAnual > 0.2) {
            throw new IllegalArgumentException("La tasa anual debe estar entre 0 y 0.2");
        }
        this.monto = monto;
        this.dias = dias;
        this.tasaAnual = tasaAnual;
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
        return Math.round(monto * tasaAnual * dias / 360);
    }

    public long calcularIntereses(int otrosDias) {
        validarDias(otrosDias);
        return Math.round(monto * tasaAnual * otrosDias / 360);
    }

    public long calcularTotalAlVencimiento() {
        return monto + calcularIntereses();
    }

    private void validarDias(int dias) {
        if (dias < DIAS_MINIMOS || dias > DIAS_MAXIMOS) {
            throw new IllegalArgumentException(
                    "Los días deben estar entre " + DIAS_MINIMOS + " y " + DIAS_MAXIMOS);
        }
    }
}
