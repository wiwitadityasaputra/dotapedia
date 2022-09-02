package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.player.PlayerCountry;
import wiwitaditya.demo.dotapedia.controller.player.model.PlayerByCountryResponse;
import wiwitaditya.demo.dotapedia.db.entity.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select * from player where player_id in (SELECT tp.player_id FROM team_player tp where tp.team_id = :teamId)",
            nativeQuery = true)
    List<Player> findPlayerByTeamId(@Param("teamId") int teamId);

    @Query(value = "SELECT * FROM player where player_id IN (:playerIds)", nativeQuery = true)
    List<Player> findByPlayerIds(@Param("playerIds") List<Integer> playerIds);

    @Query(value = "SELECT " +
            "  DISTINCT(country) as country, " +
            "  count(*) as totalPlayer " +
            "FROM player GROUP BY country ORDER BY country ASC", nativeQuery = true)
    List<PlayerCountry> findPlayerCountries();

    @Query(value = "SELECT player_id as id, " +
            "  nick_name as nickName " +
            "FROM player where country IN (:countries)", nativeQuery = true)
    List<PlayerByCountryResponse> findByCountries(@Param("countries") List<String> countries);

    @Query(value = "SELECT player_id as id, " +
            "  nick_name as nickName " +
            "FROM player ", nativeQuery = true)
    List<PlayerByCountryResponse> findByCountries();

    @Query(value = "SELECT player_id as id, " +
            "  nick_name as nickName " +
            "FROM player ORDER BY total_earnings DESC LIMIT 3", nativeQuery = true)
    List<PlayerByCountryResponse> findTop3Players();
}
