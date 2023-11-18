package ruijosecj.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruijosecj.dslist.dto.GameDTO;
import ruijosecj.dslist.dto.GameMinDTO;
import ruijosecj.dslist.services.GameService;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> games = service.findAll();
		return games;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO game = service.findById(id);
		return game;
	}

}
