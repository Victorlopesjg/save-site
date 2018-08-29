package victor.ufrn.br.savesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.ufrn.br.savesite.model.Login;
import victor.ufrn.br.savesite.model.Site;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
