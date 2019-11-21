package fr.monsite.coursecm.repository

import fr.monsite.coursecm.domain.Program
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

import java.time.LocalDateTime

interface ProgramRepository extends MongoRepository<Program, String> {
    @Query(sort = "{ from : 1 }")
    List<Program> findByToGreaterThanAndFromLessThan(LocalDateTime from, LocalDateTime to)
}