package ruijosecj.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ruijosecj.dslist.dto.GameDTO;
import ruijosecj.dslist.dto.GameMinDTO;
import ruijosecj.dslist.entities.Game;
import ruijosecj.dslist.projections.GameMinProjection;
import ruijosecj.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> games = repository.findAll();
		List<GameMinDTO> gamesDTO = games.stream().map(game -> new GameMinDTO(game)).toList();
		return gamesDTO;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
		Game game = repository.findById(id).get();
		GameDTO gameDTO = new GameDTO(game);
		return gameDTO;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = repository.searchByList(listId);
		List<GameMinDTO> gamesDTO = result.stream().map(game -> new GameMinDTO(game)).toList();
		return gamesDTO;
	}
}
