package br.com.mercadolivro.model

import br.com.mercadolivro.enums.CustomeStatus
import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? =  null,
    @Column
    var name: String,
    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomeStatus
)