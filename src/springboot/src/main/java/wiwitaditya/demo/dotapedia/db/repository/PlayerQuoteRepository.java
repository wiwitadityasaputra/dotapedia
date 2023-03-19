package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerQuoteResponse;
import wiwitaditya.demo.dotapedia.db.entity.PlayerQuote;

import java.util.List;

public interface PlayerQuoteRepository extends JpaRepository<PlayerQuote, Integer> {

    @Query(value = "select content as content, " +
            " author as author, " +
            " created_date as createdDate " +
            "from player_quote where player_id = :playerId", nativeQuery = true)
    List<PlayerQuoteResponse> findPlayerId(@Param("playerId") int playerId);
}
