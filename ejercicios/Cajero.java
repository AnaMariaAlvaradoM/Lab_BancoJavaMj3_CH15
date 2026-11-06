// ============================================================
// Ejercicio 05 · Integrador con try/catch · Cajero
// ============================================================
// En el cajero, el cliente escribe el monto como texto. El cajero
// nunca se puede "caer": si algo sale mal, muestra un mensaje.
// Usa Titular (01), CuentaAhorros (02) y Tarifas (04).
//
// Construye la clase Cajero con dos métodos public static:
//
//   public static long leerMonto(String texto)
//       · Convierte el texto con Long.parseLong(texto).
//       · Si el texto no es un número, Long.parseLong lanza
//         NumberFormatException: atrápala y lanza en su lugar
//         IllegalArgumentException con el mensaje exacto
//         "El monto debe ser un número entero: " + texto
//       · Si el número es 0 o negativo → IllegalArgumentException.
//       · Si todo está bien, devuelve el número.
//
//   public static String retirar(CuentaAhorros cuenta, String textoMonto, boolean cajeroPropio)
//       · Lee el monto con leerMonto.
//       · Calcula el costo con Tarifas.costoRetiro(cajeroPropio).
//       · Retira de la cuenta el monto MÁS el costo.
//       · Si salió bien, devuelve:
//           "Retiro exitoso. Nuevo saldo: $" + el saldo nuevo
//       · Si cualquier paso lanza IllegalArgumentException, la
//         atrapa y devuelve:
//           "Retiro rechazado: " + el mensaje de la excepción
//       · Este método NUNCA lanza excepciones.
//
// Ejemplos (cuenta con $200000):
//   Cajero.leerMonto("50000")                 → 50000
//   Cajero.retirar(cuenta, "50000", true)     → "Retiro exitoso. Nuevo saldo: $150000"
//   Cajero.retirar(cuenta, "50000", false)    → "Retiro exitoso. Nuevo saldo: $143000"
//   Cajero.retirar(cuenta, "abc", true)
//       → "Retiro rechazado: El monto debe ser un número entero: abc"
//
// Pista: e.getMessage() devuelve el mensaje de la excepción atrapada.
// ============================================================

public class Cajero {

    // Tu código aquí
    public static long leerMonto(String texto) {
        try {
            long monto = Long.parseLong(texto);

            // Validación de número menor o igual a cero
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser un número positivo.");
            }

            return monto;

        } catch (NumberFormatException e) {
            // Transformamos la excepción del sistema en una de tipo de argumento ilegal con el mensaje exigido
            throw new IllegalArgumentException("El monto debe ser un número entero: " + texto);
        }
    }


    public static String retirar(CuentaAhorros cuenta, String textoMonto, boolean cajeroPropio) {
        try {
            // 1. Intentamos leer y procesar el monto del texto
            long montoARetirar = leerMonto(textoMonto);

            // 2. Calculamos el costo transaccional con la clase Tarifas
            long costoTransaccion = Tarifas.costoRetiro(cajeroPropio);

            // 3. El cobro total a la cuenta incluye el monto solicitado MÁS el costo del servicio
            long totalDebito = montoARetirar + costoTransaccion;

            // 4. Ejecutamos el débito en la cuenta (puede lanzar IllegalArgumentException por saldo insuficiente)
            cuenta.retirar(totalDebito);

            // Si llega aquí es porque la transacción fue exitosa
            return "Retiro exitoso. Nuevo saldo: $" + cuenta.getSaldo();

        } catch (IllegalArgumentException e) {
            // Atrapamos cualquier error de validación o saldo y devolvemos la respuesta controlada sin romper la app
            return "Retiro rechazado: " + e.getMessage();
        }
    }

}
