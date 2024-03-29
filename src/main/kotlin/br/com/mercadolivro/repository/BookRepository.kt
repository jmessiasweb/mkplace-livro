package br.com.mercadolivro.repository

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository : JpaRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus,pageable: Pageable): Page<BookModel>

    fun findByCustomer(custmer: CustomerModel): List<BookModel>

//    fun findAll(pageable: Pageable): Page<BookModel>

}