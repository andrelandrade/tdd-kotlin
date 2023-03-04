package br.com.alura.service

import br.com.alura.model.Funcionario
import java.math.BigDecimal
import java.math.RoundingMode

class BonusService {

    fun calcularBonus(funcionario: Funcionario): BigDecimal {
        var valor = funcionario.getSalario().multiply(BigDecimal("0.1"))

        if (valor.compareTo(BigDecimal("1000")) > 0) {
           throw IllegalArgumentException("Funcionário com salário maior que 10K não pode receber bônus")
        }

        return valor.setScale(2, RoundingMode.HALF_UP)
    }
}