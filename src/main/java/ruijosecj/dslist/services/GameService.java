package ruijosecj.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruijosecj.dslist.dto.GameMinDTO;
import ruijosecj.dslist.entities.Game;
import ruijosecj.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public List<GameMinDTO> findAll(){
		List<Game> games = repository.findAll();
		List<GameMinDTO> gamesDTO = games.stream().map(game -> new GameMinDTO(game)).toList();
		return gamesDTO;
	}
}
