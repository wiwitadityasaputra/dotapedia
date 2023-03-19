package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.controller.home.model.TopHeroResponse;
import wiwitaditya.demo.dotapedia.db.entity.Hero;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Query(value = "SELECT * FROM hero where is_active = :isActive",
            nativeQuery = true)
    List<Hero> findHeroesByActive(@Param("isActive") int isActive);

    @Query(value = "SELECT * FROM hero where type = :type and is_active = :isActive",
            nativeQuery = true)
    List<Hero> findHeroesByTypeAndActive(@Param("type") String type, @Param("isActive") int isActive);

    @Query(value = "SELECT * FROM hero where hero_id IN (:heroIds)", nativeQuery = true)
    List<Hero> findByHeroIds(@Param("heroIds") List<Integer> heroIds);

    @Query(value = "SELECT DISTINCT(pg.hero_id) as heroId, " +
            "  count(*) as total, " +
            "  h.name as name, " +
            "  h.image_name as imageName " +
            "FROM player_game pg " +
            "LEFT JOIN hero h ON h.hero_id = pg.hero_id " +
            "GROUP BY pg.hero_id " +
            "ORDER BY total DESC " +
            "LIMIT 6", nativeQuery = true)
    List<TopHeroResponse> findTop6Hero();
}
