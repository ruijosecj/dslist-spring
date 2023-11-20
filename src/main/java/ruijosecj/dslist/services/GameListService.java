package ruijosecj.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ruijosecj.dslist.dto.GameListDTO;
import ruijosecj.dslist.entities.GameList;
import ruijosecj.dslist.projections.GameMinProjection;
import ruijosecj.dslist.repositories.GameListRepository;
import ruijosecj.dslist.repositories.GameRepository;

@Service
public class GameListService {
	@Autowired
	private GameListRepository repository;
	
	@Autowired
	private GameRepository gamRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> lists = repository.findAll();
		List<GameListDTO> listsDTO = lists.stream().map(x -> new GameListDTO(x)).toList();
		return listsDTO;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gamRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		for(int i = min ; i <= max ; i++) {
			repository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
