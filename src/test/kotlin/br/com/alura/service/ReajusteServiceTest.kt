package br.com.alura.service

import br.com.alura.model.Desempenho
import br.com.alura.model.Funcionario
import org.junit.jupiter.api.*

import java.math.BigDecimal
import java.time.LocalDate
import kotlin.test.assertEquals

class ReajusteServiceTest {
    private val service: ReajusteService = ReajusteService()
    private val funcionario = Funcionario("Teste", LocalDate.now(), BigDecimal("1000.00"))

    @BeforeEach
    fun inicializar() {
        println("teste")
    }

    @AfterEach
    fun finalizar() {
        println("fim")
    }

    companion object {
        @BeforeAll
        @JvmStatic
        fun antesTodos() {
            println("antes de todos")
        }

        @AfterAll
        @JvmStatic
        fun depoisTodos() {
            println("dps de todos")
        }
    }

    @Test
    fun `reajuste Deveria Ser De Tres Porcento Quando Desempenho For A Desejar`() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR)
        assertEquals(BigDecimal("1030.00"), funcionario.getSalario())
    }

    @Test
    fun reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM)
        assertEquals(BigDecimal("1150.00"), funcionario.getSalario())
    }

    @Test
    fun reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO)
        assertEquals(BigDecimal("1200.00"), funcionario.getSalario())
    }

    @Test
    fun reajusteDeveriaSerDeQuarentaPorcentoQuandoDesempenhoForEspetacular() {

        service.concederReajuste(funcionario, Desempenho.ESPETACULAR)
        assertEquals(BigDecimal("1400.00"), funcionario.getSalario())
    }

    // JUnit 5 - Dynamic Tests
    @TestFactory
    fun testeReajusteDesempenho() =
        listOf(
            Desempenho.A_DESEJAR to "1030.00",
            Desempenho.BOM to "1150.00",
            Desempenho.OTIMO to "1200.00",
            Desempenho.ESPETACULAR to "1400.00"
        ).map { (desempenho, salario) ->
            DynamicTest.dynamicTest("Salário reajustado deve ser $salario quando desempenho for $desempenho") {
                val funcionario = Funcionario("Teste", LocalDate.now(), BigDecimal("1000.00"))

                service.concederReajuste(funcionario, desempenho)
                assertEquals(BigDecimal(salario), funcionario.getSalario())
            }
        }
}