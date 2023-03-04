package br.com.alura.tdd

import org.testng.Assert
import org.testng.annotations.Test


class CalculadoraTest {

    @Test
    fun deveriaSomarDoisNumerosPositivos() {
        val calc = Calculadora()
        val soma = calc.somar(3, 7)

        Assert.assertEquals(10, soma)
    }
}