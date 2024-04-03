package br.com.mercadolivro.service

import br.com.mercadolivro.model.PurchaseModel
import br.com.mercadolivro.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {

    }
}
