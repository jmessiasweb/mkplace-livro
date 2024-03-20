package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.extension.toCustomerModel
import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    private val customerService: CustomerService
) {


    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
       return customerService.findById(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val custmerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(custmerSaved))

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
       customerService.delete(id)
    }

}