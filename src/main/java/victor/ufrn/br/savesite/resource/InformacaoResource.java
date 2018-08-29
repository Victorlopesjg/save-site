package victor.ufrn.br.savesite.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import victor.ufrn.br.savesite.model.Informacao;
import victor.ufrn.br.savesite.model.Site;
import victor.ufrn.br.savesite.repository.InformacaoRepository;
import victor.ufrn.br.savesite.repository.SiteRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/informacao")
@CrossOrigin
public class InformacaoResource {

    @Autowired
    private InformacaoRepository informacaoRepository;

    @GetMapping(produces = {"application/json"})
    public List<Informacao> listarSites() {
        return informacaoRepository.findAll();
    }

    @GetMapping("/{idSite}")
    public Informacao listaPorId(@PathVariable Long idInfo) {
        return informacaoRepository.findById(idInfo).get();
    }

    @PostMapping(consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Informacao inserir(@Valid @RequestBody Informacao informacao) {
        return informacaoRepository.save(informacao);
    }

    @PutMapping(consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public Informacao atualizar(@Valid @RequestBody Informacao informacao) {
        return informacaoRepository.save(informacao);
    }

    @DeleteMapping("/{idSite}")
    @ResponseStatus(code = HttpStatus.OK)
    public void atualizar(@PathVariable Long idSite) {
        informacaoRepository.deleteById(idSite);
    }

}
