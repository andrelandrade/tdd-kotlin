package br.com.alura.service

import br.com.alura.model.Funcionario
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.fail

import java.math.BigDecimal
import java.time.LocalDate
import kotlin.test.assertEquals


class BonusServiceTest {
    private val service = BonusService()

    @Test
    fun `bonus deveria ser zero para funcionario com salario muito alto`() {
        val service = BonusService()

        assertThrows(IllegalArgumentException::class.java) {
            service.calcularBonus(Funcionario("Teste", LocalDate.now(), BigDecimal("25000")))
        }

        /*try {
            service.calcularBonus(Funcionario("Teste", LocalDate.now(), BigDecimal("25000")))
            fail("não deu exception")
        } catch (e: IllegalArgumentException) {
            assertEquals("Funcionário com salário maior que 10K não pode receber bônus",
                e.message)
        }*/
    }

    @Test
    fun `bonus deveria ser 10Por cento do salario`() {
        val bonus = service.calcularBonus(Funcionario("Teste", LocalDate.now(), BigDecimal("2500")))
        assertEquals(BigDecimal("250.00"), bonus)
    }

    @Test
    fun `bonus 10000`() {
        val bonus = service.calcularBonus(Funcionario("Teste", LocalDate.now(), BigDecimal("10000")))
        assertEquals(BigDecimal("1000.00"), bonus)
    }
}