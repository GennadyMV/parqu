package rage.parqu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rage.parqu.domain.DbAnswer;

public interface AnswerRepository extends JpaRepository<DbAnswer, Long>{

}
