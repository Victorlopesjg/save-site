package victor.ufrn.br.savesite.resource;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victor.ufrn.br.savesite.model.Login;
import victor.ufrn.br.savesite.repository.LoginRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginResource {

    @Autowired
    private LoginRepository loginRepository;

    @PersistenceContext
    private EntityManager em;

    @PostMapping(consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> logar(@Valid @RequestBody Login login) {
        if (login != null && login.getEmail() != null && login.getSenha() != null) {
            Query query = (Query) em.createQuery("select * from Login where email = " + login.getEmail() + " AND senha = " + login.getSenha());
            return new ResponseEntity<>((Login) query.getSingleResult(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor, enviei o e-mail e a senha");
        }
    }


}
