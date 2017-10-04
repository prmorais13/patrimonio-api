package br.paulo.patrimonio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.paulo.patrimonio.model.Item;
import br.paulo.patrimonio.service.ItemService;

@RestController
@RequestMapping("/itens")
@CrossOrigin("${origin-permitida}")
public class ItemResource {

	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<Item> itensTodos() {
		return this.itemService.listar();
	}
	
	@GetMapping("/{id}")
	public Item buscarPorId(@PathVariable Long id) {
		return this.itemService.porId(id);
	}
	
	@PostMapping
	public Item salvar(@RequestBody @Valid Item item) {
		return this.itemService.adicionar(item);
	}
	
	@PutMapping("/{id}")
	public Item atualizar(@RequestBody @Valid Item item, @PathVariable Long id) {
		return this.itemService.editar(item, id);
	}
}
