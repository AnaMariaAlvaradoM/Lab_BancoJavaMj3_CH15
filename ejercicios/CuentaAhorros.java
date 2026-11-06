// Ejercicio 02 - Métodos que cambian el estado - CuentaAhorros
public class CuentaAhorros {

    private static int cuentasAbiertas = 0;

    private String numero;
    private Titular titular;
    private long saldo;

    public CuentaAhorros(String numero, Titular titular) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }
        if (titular == null) {
            throw new IllegalArgumentException("La cuenta necesita un titular");
        }
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        cuentasAbiertas++;
    }

    public String getNumero() {
        return numero;
    }

    public Titular getTitular() {
        return titular;
    }

    public long getSaldo() {
        return saldo;
    }

    public static int getCuentasAbiertas() {
        return cuentasAbiertas;
    }

    public void depositar(long valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor a depositar debe ser mayor que 0");
        }
        saldo += valor;
    }

    public void retirar(long valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor a retirar debe ser mayor que 0");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente. Saldo: $" + saldo + ", retiro: $" + valor);
        }
        saldo -= valor;
    }
}
