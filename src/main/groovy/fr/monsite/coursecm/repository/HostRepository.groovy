package fr.monsite.coursecm.repository

import fr.monsite.coursecm.domain.Host
import org.springframework.data.mongodb.repository.MongoRepository


interface HostRepository extends MongoRepository<Host, String> {
    // les méthodes findById et findAll sont déjà disponibles
}