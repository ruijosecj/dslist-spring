package ruijosecj.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruijosecj.dslist.dto.GameListDTO;
import ruijosecj.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/api/lists")
public class GameListController {
	@Autowired
	private GameListService service;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> lists = service.findAll();
		return lists;
	}
}
