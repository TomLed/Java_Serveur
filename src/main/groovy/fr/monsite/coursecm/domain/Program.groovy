package fr.monsite.coursecm.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDateTime

@Document(collection = "program")
class Program {
    @Id
    String id

    String name
    LocalDateTime from, to

    List<String> hosts = []
}
