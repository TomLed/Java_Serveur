package fr.monsite.coursecm.controller

import fr.monsite.coursecm.domain.Program
import fr.monsite.coursecm.repository.ProgramRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import java.time.LocalDate
import java.time.LocalDateTime

@RestController
class ProgramController {
    @Autowired
    ProgramRepository programRepository

    @GetMapping('/programs')
    List<Program> programs() {
        LocalDate today = LocalDate.now()
        LocalDateTime from = today.atStartOfDay()
        LocalDateTime to = today.atStartOfDay().plusDays(1)

        programRepository.findByToGreaterThanAndFromLessThan(from, to)
    }
}