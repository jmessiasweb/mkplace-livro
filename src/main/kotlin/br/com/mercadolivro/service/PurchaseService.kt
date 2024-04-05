package br.com.mercadolivro.service

import br.com.mercadolivro.events.PurchaseEvent
import br.com.mercadolivro.model.PurchaseModel
import br.com.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(puchaseModel: PurchaseModel) {
         purchaseRepository.save(puchaseModel)
    }
}
