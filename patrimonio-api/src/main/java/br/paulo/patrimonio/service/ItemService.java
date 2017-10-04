package br.paulo.patrimonio.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.paulo.patrimonio.model.Item;
import br.paulo.patrimonio.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> listar() {
		return this.itemRepository.findAll();
	}
	
	public Item porId(Long id) {
		return this.itemRepository.findOne(id);
	}
	
	public Item adicionar(Item item) {
		return this.itemRepository.save(item);
	}
	
	public Item editar(Item item, Long id) {
		Item itemAtualizado = this.porId(id);
		
		if(itemAtualizado == null) {
			return null;
		} else {
			BeanUtils.copyProperties(item, itemAtualizado);
			return this.itemRepository.save(itemAtualizado);
		}
		
	}

}
