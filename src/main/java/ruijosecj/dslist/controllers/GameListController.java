package ruijosecj.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruijosecj.dslist.dto.GameListDTO;
import ruijosecj.dslist.dto.GameMinDTO;
import ruijosecj.dslist.services.GameListService;
import ruijosecj.dslist.services.GameService;

@RestController
@RequestMapping(value = "/api/lists")
public class GameListController {
	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> lists = service.findAll();
		return lists;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findAll(@PathVariable Long listId){
		List<GameMinDTO> lists = gameService.findByList(listId);
		return lists;
	}
}
