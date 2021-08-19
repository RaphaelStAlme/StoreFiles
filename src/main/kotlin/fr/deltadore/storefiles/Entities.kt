package fr.deltadore.storefiles

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class File(
    var title: String,
    var path: String,
    @Id
    @GeneratedValue
    var id: Long? = null
)