package wiwitaditya.demo.dotapedia.controller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wiwitaditya.demo.dotapedia.db.repository.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(name = "/")
    public List getAllPlayer() {
        return playerRepository.findAll();
    }
}
