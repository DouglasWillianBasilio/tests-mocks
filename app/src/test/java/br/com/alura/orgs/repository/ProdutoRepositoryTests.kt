package br.com.alura.orgs.repository

import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.database.repository.ProdutoRepository
import io.mockk.mockk
import org.junit.Assert.*

import org.junit.Test

class ProdutoRepositoryTests {

    @Test
    fun salva() {
        val context = mockk<>()
        ProdutoRepository(AppDatabase.instancia())
    }
}