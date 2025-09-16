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
}
