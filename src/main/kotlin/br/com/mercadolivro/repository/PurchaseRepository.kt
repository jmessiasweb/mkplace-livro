package br.com.mercadolivro.repository

import br.com.mercadolivro.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository: CrudRepository<PurchaseModel, Int> {

}
