package br.paulo.patrimonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.paulo.patrimonio.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
