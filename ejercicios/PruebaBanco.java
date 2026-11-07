// ============================================================
// Tu zona de pruebas (NO se califica)
// ============================================================
// Aquí puedes crear objetos y ver qué hacen tus clases antes de
// correr npm test. Quita las // de las líneas que quieras probar
// y ejecuta con el ▶ verde junto al main.
// Si una clase todavía no está lista, deja sus líneas comentadas.
// ============================================================

public class PruebaBanco {

    public static void main(String[] args) {

        Titular laura = new Titular("Laura Pérez", "1032456789");
        System.out.println("Celular inicial: " + laura.getCelular());
        laura.setCelular("3104567890");
        System.out.println(laura.getNombre() + " · " + laura.getCelular());
        
        
        System.out.println("Retiro en otro banco: $" + Tarifas.costoRetiro(false));
        System.out.println("Retiro 1 en cajero propio: $" + Tarifas.costoRetiro(true));
        System.out.println("Retiro 3 en cajero propio: $" + Tarifas.costoRetiro(true, 3));
        System.out.println("Retiro 4 en cajero propio: $" + Tarifas.costoRetiro(true, 4));
        System.out.println("Cuota con 999999: $" + Tarifas.cuotaManejo(999_999));
        System.out.println("Cuota con 1000000: $" + Tarifas.cuotaManejo(1_000_000));


        CuentaAhorros cuenta = new CuentaAhorros("001-458", laura);
        cuenta.depositar(200000);
        cuenta.retirar(50000);
        System.out.println("Saldo: $" + cuenta.getSaldo());


        Cdt cdt = new Cdt(1_000_000, 90, 0.09);
        System.out.println("Intereses: $" + cdt.calcularIntereses());


        System.out.println("Retiro en otro banco: $" + Tarifas.costoRetiro(false));

        System.out.println(Cajero.retirar(cuenta, "abc", true));
    }
}
