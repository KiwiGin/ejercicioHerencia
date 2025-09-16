fun main() {
    println("=== PRUEBA DE CUENTA DE AHORROS ===")

    val cuentaAhorros = CuentaAhorros(15000f, 3.0f)

    println("Estado inicial:")
    cuentaAhorros.imprimir()

    println("\n--- Realizando consignación de \$5,000 ---")
    cuentaAhorros.consignar(5000f)
    cuentaAhorros.imprimir()

    println("\n--- Realizando 5 retiros de \$2,000 cada uno ---")
    repeat(5) { i ->
        println("Retiro ${i + 1}:")
        cuentaAhorros.retirar(2000f)
        println("\tQueda: ${cuentaAhorros.saldoAtual}")
    }
    cuentaAhorros.imprimir()

    println("\n--- Generando extracto mensual ---")
    cuentaAhorros.extractoMensual()
    cuentaAhorros.imprimir()

    println("\n--- Intentando retirar \$8,000 (cuenta inactiva) ---")
    cuentaAhorros.retirar(8000f)
    cuentaAhorros.imprimir()

    println("\n\n=== PRUEBA DE CUENTA CORRIENTE ===")

    val cuentaCorriente = CuentaCorriente(8000f, 2.0f)

    println("Estado inicial:")
    cuentaCorriente.imprimir()

    println("\n--- Retirando \$10,000 (genera sobregiro) ---")
    cuentaCorriente.retirar(10000f)
    cuentaCorriente.imprimir()

    println("\n--- Consignando \$3,000 (reduce sobregiro) ---")
    cuentaCorriente.consignar(3000f)
    cuentaCorriente.imprimir()

    println("\n--- Consignando \$2,000 más ---")
    cuentaCorriente.consignar(2000f)
    cuentaCorriente.imprimir()

    println("\n--- Generando extracto mensual ---")
    cuentaCorriente.extractoMensual()
    cuentaCorriente.imprimir()
}
