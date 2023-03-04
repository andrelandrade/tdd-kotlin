package br.com.alura.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

class Funcionario(private val nome: String,
                  private val dataAdmissao: LocalDate,
                  private var salario: BigDecimal) {

    fun getNome() = nome

    fun getDataAdmissao() = dataAdmissao

    fun getSalario() = salario

    fun reajustarSalario(reajuste: BigDecimal) {
        this.salario = this.salario.add(reajuste)
        arredondarSalario()
    }

    private fun arredondarSalario() {
        this.salario = this.salario.setScale(2, RoundingMode.HALF_UP)
    }
}