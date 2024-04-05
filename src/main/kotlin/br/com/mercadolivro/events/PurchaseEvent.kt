package br.com.mercadolivro.events

import br.com.mercadolivro.model.PurchaseModel
import org.springframework.context.ApplicationEvent


class PurchaseEvent (
    soucer: Any,
    val purchaseModel: PurchaseModel
): ApplicationEvent(soucer)