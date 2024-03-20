package br.com.mercadolivro.extension

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.controller.request.PutBookRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.enums.CustomeStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomeStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previusValues: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previusValues.id,
        name = this.name,
        email = this.email,
        status = previusValues.status)
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