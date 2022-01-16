package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiwitaditya.demo.dotapedia.db.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
