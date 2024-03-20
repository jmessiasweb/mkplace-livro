package br.com.mercadolivro.repository

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus): List<BookModel>

    fun findByCustomer(custmer: CustomerModel): List<BookModel>

}