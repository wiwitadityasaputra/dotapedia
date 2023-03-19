package wiwitaditya.demo.dotapedia.db.entity;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player_quote")
public class PlayerQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_quote_id")
    private Integer id;
    private Integer playerId;
    private String content;
    private String author;
    private long createdDate;
}
