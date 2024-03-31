package br.com.mercadolivro.exception

class BadRequesteException(override val message: String, val errorCode: String): Exception() {


}