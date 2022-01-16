package wiwitaditya.demo.dotapedia.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wiwitaditya.demo.dotapedia.db.entity.Hero;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Query(value = "SELECT * FROM hero where is_active = :isActive",
            nativeQuery = true)
    List<Hero> findHeroesByActive(@Param("isActive") int isActive);

    @Query(value = "SELECT * FROM hero where type = :type and is_active = :isActive",
            nativeQuery = true)
    List<Hero> findHeroesByTypeAndActive(@Param("type") String type, @Param("isActive") int isActive);
}
