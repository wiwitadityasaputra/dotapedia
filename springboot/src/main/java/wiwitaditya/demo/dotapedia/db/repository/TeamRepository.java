package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiwitaditya.demo.dotapedia.db.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
