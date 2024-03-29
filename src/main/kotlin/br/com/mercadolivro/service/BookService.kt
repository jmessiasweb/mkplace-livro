package br.com.mercadolivro.service

import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)

    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()

    }

    fun delete(id: Int) {
        val book = findById(id)

        book.status = BookStatus.CANCELADO

        update(book)

    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(custmer: CustomerModel) {
        val books = bookRepository.findByCustomer(custmer)
        for (book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)

    }

}
