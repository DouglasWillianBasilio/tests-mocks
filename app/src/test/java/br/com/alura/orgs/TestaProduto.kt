package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.Usuario
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.math.BigDecimal

class TestaProduto {

    @Test
    fun deveRetornarVerdadeiroQuandoOValorForValido() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Prata",
            valor = BigDecimal("6.99")
        )

        val valorEhValido = produtoValido.valorEhValido
        assertTrue(valorEhValido)
    }

    @Test
    fun deveRetornarFalsoQuandoOValorForMaiorQueCem() {
        val produtoInvalido = Produto(
            nome = "uva",
            descricao = "boa",
            valor = BigDecimal("310.00")
        )

        val valorEhValido = produtoInvalido.valorEhValido

        assertFalse(valorEhValido)
    }

    @Test
    fun retornaFalsoSeOEmailDoUsuarioEstiverErrado() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuario.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioInvalido.ehValido()

        assertFalse(resultado)
    }

    @Test
    fun retornaFalsoSeASenhaDoUsuarioEstiverComMenosDe6Caracteres() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuario.com",
            senha = "fraca"
        )

        val resultado = usuarioInvalido.ehValido()

        assertFalse(resultado)
    }

    @Test
    fun deveRetornarFalsoQuandoOValorForMenorOuIgualAZero() {
        val produtoComValorIgualAZero = Produto(
            nome = "banana",
            descricao = "boa",
            valor = BigDecimal("0")
        )
        val produtoComValorMenorQueZero = Produto(
            nome = "Maca",
            descricao = "boa",
            valor = BigDecimal("-10.99")
        )

        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorEhValido
        val valorMenorQueZeroEhValido = produtoComValorMenorQueZero.valorEhValido
        assertFalse(valorMenorQueZeroEhValido)
        assertFalse(valorIgualAZeroEhValido)
    }
}