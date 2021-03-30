package com.blog.app.servicios.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blog.app.servicios.item.model.Item;
import com.blog.app.servicios.item.model.Product;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Product> productos = Arrays
				.asList(clienteRest.getForObject("http://localhost:8081/listar", Product[].class));

		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Product product = clienteRest.getForObject("http://localhost:8081/ver/{id}", Product.class, pathVariables);
		return new Item(product, quantity);
	}

}
