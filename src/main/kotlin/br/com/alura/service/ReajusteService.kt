package br.com.alura.service

import br.com.alura.model.Desempenho
import br.com.alura.model.Funcionario
import java.math.BigDecimal
import java.math.RoundingMode

class ReajusteService {
    fun concederReajuste(funcionario: Funcionario, desempenho: Desempenho) {
        val percentual = desempenho.percentualReajuste()
        val reajuste = funcionario.getSalario().multiply(percentual).setScale(2, RoundingMode.HALF_UP)

        funcionario.reajustarSalario(reajuste)
    }
}
