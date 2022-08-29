package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wiwitaditya.demo.dotapedia.db.entity.PlayerQuote;

import java.util.List;

public interface PlayerQuoteRepository extends JpaRepository<PlayerQuote, Integer> {

    @Query(value = "select player_id from player_quote",
            nativeQuery = true)
    List<String> findPlayerId();
}
