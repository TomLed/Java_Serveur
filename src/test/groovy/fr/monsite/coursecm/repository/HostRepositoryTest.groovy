package fr.monsite.coursecm.repository

import fr.monsite.coursecm.domain.Host
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner)
@SpringBootTest
@ActiveProfiles('test')
class HostRepositoryTest {
    Host parse(String input) {
        def tokens = input.tokenize('|')

        new Host(firstname: tokens[0], lastname: tokens[1])
    }


    @Autowired
    HostRepository hostRepository

    @Before
    @After
    void clean() {
        hostRepository.deleteAll()
    }

    @Test
    void save(){
        hostRepository.save(parse('Xavier|De Moulins'))

        assert hostRepository.count() == 1
        assert hostRepository.findAll()[0].firstname == 'Xavier'
    }

    @Test
    void findById(){
        hostRepository.save(new Host(firstname: "Kareen", lastname: "Guiock"))
        Host host = hostRepository.findById("5dd79691e1654056336c2c7e").orElse({ new ChangeSetPersister.NotFoundException() })

        assert host.firstname == "Kareen"
        assert host.lastname =="Guiock"

    }



}