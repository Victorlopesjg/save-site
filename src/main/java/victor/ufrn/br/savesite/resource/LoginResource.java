package victor.ufrn.br.savesite.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import victor.ufrn.br.savesite.model.Login;
import victor.ufrn.br.savesite.repository.LoginRepository;
import victor.ufrn.br.savesite.rowmapper.LoginRowMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginResource {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;


    @PostMapping(value = "/logar", consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> logar(@Valid @RequestBody Login login) {
        if (login != null && login.getEmail() != null && login.getSenha() != null) {
            String sql = "SELECT id, nome, email FROM public.login as u WHERE u.email = ? AND u.senha = ?";

            Login result = (Login) jdbcTemplate.queryForObject(sql, new Object[]{login.getEmail(), login.getSenha()}, new LoginRowMapper());

            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor, enviei o e-mail e a senha");
        }
    }

    @PostMapping(consumes = "application/json", produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Login inserir(@Valid @RequestBody Login login) {
        return loginRepository.save(login);
    }


}
