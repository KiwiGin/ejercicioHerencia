open class Cuenta(protected var saldo: Float, protected val tasaAnual: Float) {
    protected var numeroConsignaciones: Int = 0
    protected var numeroRetiros: Int = 0
    protected var comisionMensual: Float = 0f
    val saldoAtual: Float get() = saldo

    open fun consignar(cantidad: Float) {
        saldo += cantidad
        numeroConsignaciones++
    }

    open fun retirar(cantidad: Float) {
        if (cantidad <= saldo) {
            saldo -= cantidad
            numeroRetiros++
        } else {
            println("Fondos insuficientes")
        }
    }

    fun calcularInteresMensual() {
        val interesMensual = saldo * (tasaAnual / 12) / 100
        saldo += interesMensual
    }

    open fun extractoMensual() {
        saldo -= comisionMensual
        calcularInteresMensual()
    }

    open fun imprimir() {
        println("Saldo: \$${saldo}")
        println("Comisión mensual: \$${comisionMensual}")
        println("Número de transacciones: ${numeroConsignaciones + numeroRetiros}")
    }
}