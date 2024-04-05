package br.com.mercadolivro.events.listener

import br.com.mercadolivro.events.PurchaseEvent
import br.com.mercadolivro.service.BookService
import br.com.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
       bookService.puchase(purchaseEvent.purchaseModel.books)


    }
}