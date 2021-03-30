package com.blog.app.servicios.item.service;

import java.util.List;

import com.blog.app.servicios.item.model.Item;

public interface IItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer quantity);

}
