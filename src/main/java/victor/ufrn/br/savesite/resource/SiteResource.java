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
    public List<Site> listarSites(@RequestParam(required = false, defaultValue = "nome") String sort) {
        return siteRepository.findAll(new Sort(Direction.ASC, sort));
    }

    @PostMapping(consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Site inserir(@Valid @RequestBody Site site) {
        return siteRepository.save(site);
    }

}
