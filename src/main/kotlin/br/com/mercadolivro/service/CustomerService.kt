package br.com.mercadolivro.service

import br.com.mercadolivro.enums.CustomeStatus
import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val bookService: BookService
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }



    fun create(customer: CustomerModel) {
        customerRepository.save(customer)

    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()

    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        customerRepository.save(customer)

    }

    fun delete(id: Int) {
        val custmer = findById(id)
        bookService.deleteByCustomer(custmer)

        custmer.status = CustomeStatus.INATIVO

        customerRepository.save(custmer)

    }
}

