package br.com.alura.model

import java.math.BigDecimal
import java.math.RoundingMode

enum class Desempenho {
    A_DESEJAR {
        override fun percentualReajuste(): BigDecimal {
            return BigDecimal("0.03")
        }
    },
    BOM {
        override fun percentualReajuste(): BigDecimal {
            return BigDecimal("0.15")
        }
    },
    OTIMO {
        override fun percentualReajuste(): BigDecimal {
            return BigDecimal("0.20")
        }
    },
    ESPETACULAR {
        override fun percentualReajuste(): BigDecimal {
            return BigDecimal("0.40")
        }
    };

    abstract fun percentualReajuste(): BigDecimal
}
