package ruijosecj.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ruijosecj.dslist.dto.GameListDTO;
import ruijosecj.dslist.entities.GameList;
import ruijosecj.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> lists = repository.findAll();
		List<GameListDTO> listsDTO = lists.stream().map(x -> new GameListDTO(x)).toList();
		return listsDTO;
	}
}
