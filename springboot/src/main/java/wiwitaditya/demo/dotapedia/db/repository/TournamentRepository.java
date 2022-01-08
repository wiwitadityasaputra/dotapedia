package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiwitaditya.demo.dotapedia.db.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
