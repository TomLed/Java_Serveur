package fr.monsite.coursecm.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "host")
class Host {
    @Id
    String id

    String firstname

    String lastname
}