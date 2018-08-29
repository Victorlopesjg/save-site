package victor.ufrn.br.savesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.ufrn.br.savesite.model.Informacao;
import victor.ufrn.br.savesite.model.Login;

public interface InformacaoRepository extends JpaRepository<Informacao, Long> {

}
