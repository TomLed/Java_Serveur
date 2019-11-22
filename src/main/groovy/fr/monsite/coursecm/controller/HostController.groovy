package fr.monsite.coursecm.controller

import fr.monsite.coursecm.domain.Host
import fr.monsite.coursecm.repository.HostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HostController {

    @Autowired
    HostRepository hostRepository

    @GetMapping('/hosts')
    List<Host> hosts() {
        hostRepository.findAll()
    }

    @GetMapping('/hosts/{id}')
    Host hostsid(@PathVariable String id){
        hostRepository.findById(id).orElseThrow({ new ChangeSetPersister.NotFoundException() })
    }

}
