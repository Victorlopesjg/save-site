package victor.ufrn.br.savesite.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import victor.ufrn.br.savesite.model.Site;
import victor.ufrn.br.savesite.repository.SiteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/site")
public class SiteResource {

    @Autowired
    private SiteRepository siteRepository;

    @GetMapping(produces = {"application/json"})
    public List<Site> listarSites() {
        return siteRepository.findAll();
    }

    @GetMapping("/{idSite}")
    public Site listaPorId(@PathVariable Long idSite) {
        return siteRepository.findById(idSite).get();
    }

    @PostMapping(consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Site inserir(@Valid @RequestBody Site site) {
        return siteRepository.save(site);
    }

}
