class CuentaAhorros(saldo: Float, tasaAnual: Float) : Cuenta(saldo, tasaAnual) {

    private var activa: Boolean = saldo >= 10000f

    private fun verificarEstado() {
        activa = saldo >= 10000f
    }

    override fun consignar(cantidad: Float) {
        if (activa) {
            super.consignar(cantidad)
            verificarEstado()
        } else {
            println("La cuenta está inactiva, no se puede consignar")
        }
    }

    override fun retirar(cantidad: Float) {
        if (activa) {
            super.retirar(cantidad)
            verificarEstado()
        } else {
            println("La cuenta está inactiva, no se puede retirar")
        }
    }

    override fun extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000f
        }
        super.extractoMensual()
        verificarEstado()
    }

    override fun imprimir() {
        println("Cuenta de Ahorros:")
        println("Saldo: \$${saldo}")
        println("Comisión mensual: \$${comisionMensual}")
        println("Número de transacciones: ${numeroConsignaciones + numeroRetiros}")
        println("Estado de la cuenta: ${if (activa) "Activa" else "Inactiva"}")
    }
}