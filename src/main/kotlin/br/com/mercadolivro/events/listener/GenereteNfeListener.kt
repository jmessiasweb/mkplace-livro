package br.com.mercadolivro.events.listener

import br.com.mercadolivro.events.PurchaseEvent
import br.com.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class GenereteNfeListener(
    private val purchaseService: PurchaseService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        val nfe = UUID.randomUUID().toString()
        val puchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)

        purchaseService.update(puchaseModel)


    }
}