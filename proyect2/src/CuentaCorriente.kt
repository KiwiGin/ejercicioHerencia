class CuentaCorriente(saldo: Float, tasaAnual: Float) : Cuenta(saldo, tasaAnual) {
    private var sobregiro: Float = 0f

    override fun retirar(cantidad: Float) {
        if (cantidad <= saldo) {
            super.retirar(cantidad)
        } else {
            sobregiro += (cantidad - saldo)
            saldo = 0f
            numeroRetiros++
        }
    }

    override fun consignar(cantidad: Float) {
        var cantidadRestante = cantidad

        if (sobregiro > 0) {
            if (cantidadRestante >= sobregiro) {
                cantidadRestante -= sobregiro
                sobregiro = 0f
                saldo += cantidadRestante
            } else {
                sobregiro -= cantidadRestante
            }
        } else {
            super.consignar(cantidadRestante)
            return
        }
        numeroConsignaciones++
    }

    override fun extractoMensual() {
        super.extractoMensual()
    }

    override fun imprimir() {
        println("Cuenta Corriente:")
        println("Saldo: \$${saldo}")
        println("Comisión mensual: \$${comisionMensual}")
        println("Número de transacciones: ${numeroConsignaciones + numeroRetiros}")
        println("Sobregiro: \$${sobregiro}")
    }
}