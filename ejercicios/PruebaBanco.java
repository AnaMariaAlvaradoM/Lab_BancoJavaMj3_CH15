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
        // Titular laura = new Titular("Laura Pérez", "1032456789");
        // laura.setCelular("3104567890");
        // System.out.println(laura.getNombre() + " · " + laura.getCelular());

        // CuentaAhorros cuenta = new CuentaAhorros("001-458", laura);
        // cuenta.depositar(200000);
        // cuenta.retirar(50000);
        // System.out.println("Saldo: $" + cuenta.getSaldo());

        // Cdt cdt = new Cdt(1_000_000, 90, 0.09);
        // System.out.println("Intereses: $" + cdt.calcularIntereses());

        // System.out.println("Retiro en otro banco: $" + Tarifas.costoRetiro(false));

        // System.out.println(Cajero.retirar(cuenta, "abc", true));

        // laura
        Titular laura = new Titular("Laura Pérez", "1032456789");
        laura.setCelular("3104567890");

        // alejandra
        Titular alejandra = new Titular("Alejandra Fernández", "1023456789");
        alejandra.setCelular("3205678901");

        // vanesa
        Titular vanesa = new Titular("Vanesa Tabares", "1012345678");
        vanesa.setCelular("3006789012");


        // cuenta de laura
        CuentaAhorros cuenta = new CuentaAhorros("001-458", laura);
        cuenta.depositar(200000);
        cuenta.retirar(50000);

        // cuenta de alejandra
        CuentaAhorros cuentaAlejandra = new CuentaAhorros("002-458", alejandra);
        cuentaAlejandra.depositar(500000);
        cuentaAlejandra.retirar(120000);

        // cuenta de vanesa
        CuentaAhorros cuentaVanesa = new CuentaAhorros("003-458", vanesa);
        cuentaVanesa.depositar(350000);
        cuentaVanesa.retirar(75000);


        // impresion de titulares y cuentas
        System.out.println("\n===== INFORMACION DE CUENTAS =====");

        System.out.println("\nTitular: " + laura.getNombre());
        System.out.println("Celular: " + laura.getCelular());
        System.out.println("Cuenta: 001-458");
        System.out.println("Saldo: $" + cuenta.getSaldo());

        System.out.println("\nTitular: " + alejandra.getNombre());
        System.out.println("Celular: " + alejandra.getCelular());
        System.out.println("Cuenta: 002-458");
        System.out.println("Saldo: $" + cuentaAlejandra.getSaldo());

        System.out.println("\nTitular: " + vanesa.getNombre());
        System.out.println("Celular: " + vanesa.getCelular());
        System.out.println("Cuenta: 003-458");
        System.out.println("Saldo: $" + cuentaVanesa.getSaldo());


        // pruebas de CDT
        Cdt cdtLaura = new Cdt(1_000_000, 90, 0.09);
        Cdt cdtAlejandra = new Cdt(2_000_000, 180, 0.10);
        Cdt cdtVanesa = new Cdt(500_000, 30, 0.08);

        System.out.println("\n----- Intereses CDT -----");
        System.out.println("Laura: $" + cdtLaura.calcularIntereses());
        System.out.println("Alejandra: $" + cdtAlejandra.calcularIntereses());
        System.out.println("Vanesa: $" + cdtVanesa.calcularIntereses());


        // pruebas de tarifas y cajero
        System.out.println("\n----- Pruebas de tarifas y cajero -----");
        System.out.println("Retiro en otro banco realizado por Alejandra: $" + Tarifas.costoRetiro(false));

        System.out.println("\nRetiro Laura: " + Cajero.retirar(cuenta, "12000", true));
        System.out.println("Retiro Alejandra: " + Cajero.retirar(cuentaAlejandra, "50000", false));
        System.out.println("Retiro Vanesa: " + Cajero.retirar(cuentaVanesa, "25000", true));

        System.out.println("\nCuentas abiertas: " + CuentaAhorros.getCuentasAbiertas());
    }
}
