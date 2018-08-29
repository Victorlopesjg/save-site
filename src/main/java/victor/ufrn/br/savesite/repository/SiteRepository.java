package victor.ufrn.br.savesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.ufrn.br.savesite.model.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {

}
