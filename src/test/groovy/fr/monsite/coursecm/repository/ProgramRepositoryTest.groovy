package fr.monsite.coursecm.repository

import fr.monsite.coursecm.domain.Program
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

import java.time.LocalDate

@RunWith(SpringRunner)
@SpringBootTest
@ActiveProfiles('test')
class ProgramRepositoryTest {
    @Autowired
    ProgramRepository programRepository

    LocalDate today = LocalDate.now()

    @Before
    @After
    void clean() {
        // on vide la base avant et après chaque test
        programRepository.deleteAll()
    }

    @Test
    void save() {
        programRepository.save(parse('01:45|01:50|Météo'))

        assert programRepository.count() == 1
        assert programRepository.findAll()[0].name == 'Météo'
    }

    @Test
    void findByToGreaterThanAndFromLessThan() {
        programRepository.save(new Program(
                name: 'Météo',
                from: today.atTime(12, 40),
                to: today.atTime(12, 45))
        )
        programRepository.save(new Program(
                name: 'Le 1245',
                from: today.atTime(12, 45),
                to: today.atTime(13, 25))
        )

        List<Program> programs = programRepository.findByToGreaterThanAndFromLessThan(today.atTime(12, 40), today.atTime(13, 25))

        assert programs.size() == 2
        assert programs[0].name == 'Météo'
        assert programs[1].name == 'Le 1245'
    }
}

