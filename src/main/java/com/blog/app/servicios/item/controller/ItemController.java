package com.blog.app.servicios.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.servicios.item.model.Item;
import com.blog.app.servicios.item.service.IItemService;
import com.blog.app.servicios.item.service.ItemServiceImpl;

@RestController
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public List<Item> list() {
		return itemService.findAll();
	
	}
	
	@GetMapping("/ver/{id}/cantidad/{quantity}")
	public Item detail(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
	}
}
