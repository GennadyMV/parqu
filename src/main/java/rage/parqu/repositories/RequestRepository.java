package rage.parqu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rage.parqu.domain.DbRequest;

public interface RequestRepository extends JpaRepository<DbRequest, Long>{

}
