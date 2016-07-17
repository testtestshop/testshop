package com.testshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.testshop.domain.Item;
import com.testshop.domain.ItemType;
import com.testshop.domain.User;
import com.testshop.repository.ItemRepository;
import com.testshop.repository.ItemTypeRepository;
import com.testshop.repository.UserRepository;
import com.testshop.service.UserService;

@Controller
@RequestMapping(value = "api/item")
public class ItemController implements RestController<Item> {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemTypeRepository itemTypeRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public String get(@PathVariable String id, Model model) {
		model.addAttribute("item", itemRepository.findOne(Long.parseLong(id)));
		return "item/item";
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public String getAll(Model model) {
		model.addAttribute("items", (List<Item>) itemRepository.findAll());

		model.addAttribute("item", new Item());
		
		return "item/itemList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Override
	public String add(@ModelAttribute("item") Item input) {
		
		//temporary hardcode, should be deleted
		ItemType itemType = itemTypeRepository.findOne(Long.valueOf(1));
		input.setItemType(itemType);
		
		itemRepository.save(input);
		
		return "redirect:/api/item";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Override
	public String update(@PathVariable String id, @ModelAttribute Item input) {
		input.setId(Long.parseLong(id));
		itemRepository.save(input);
		
		return "redirect:/api/item";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public String delete(@PathVariable String id) {
		itemRepository.delete(Long.parseLong(id));
		
		return "redirect:/api/item";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@Override
	public String deleteAll() {
		itemRepository.deleteAll();
		
		return "redirect:/api/item";
	}

}
