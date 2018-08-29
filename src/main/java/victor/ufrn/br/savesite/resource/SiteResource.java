package victor.ufrn.br.savesite.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import victor.ufrn.br.savesite.model.Site;
import victor.ufrn.br.savesite.repository.SiteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

@RestController
public class SiteResource {

    @Autowired
    private SiteRepository siteRepository;

    @RequestMapping("/sites")
    @GetMapping(produces={"application/json"})
    public List<Site> listarSites(@RequestParam(required = false, defaultValue = "nome") String sort){
        return siteRepository.findAll(new Sort(Direction.ASC,sort));
    }

}
