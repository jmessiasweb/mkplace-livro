package br.com.mercadolivro.extension

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.controller.request.PutBookRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.controller.response.BookResponse
import br.com.mercadolivro.controller.response.CustomerResponse
import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.enums.CustomerStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO,
        password = this.password
    )
}

fun PutCustomerRequest.toCustomerModel(previusValues: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previusValues.id,
        name = this.name,
        email = this.email,
        status = previusValues.status,
        password = previusValues.password
    )
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer

    )

}

fun PutBookRequest.toBookModel(previusValues: BookModel): BookModel {
    return BookModel(
        id = previusValues.id,
        name = this.name ?: previusValues.name,
        price = this.price ?: previusValues.price,
        status = previusValues.status,
        customer = previusValues.customer
    )

}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status

    )

}

