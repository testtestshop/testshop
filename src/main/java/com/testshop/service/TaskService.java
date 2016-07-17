package com.testshop.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.testshop.domain.Item;
import com.testshop.domain.ItemType;
import com.testshop.domain.Task;
import com.testshop.domain.User;
import com.testshop.domain.supply.Status;
import com.testshop.repository.ItemRepository;
import com.testshop.repository.ItemTypeRepository;
import com.testshop.repository.TaskRepository;
import com.testshop.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public boolean create(String itemId, String itemQuantity, String describe) {
		Long id = Long.parseLong(itemId);
		Long quantity = Long.parseLong(itemQuantity);
		
		//if(!taskRepository.exists(id)) return false;
		
		Task task = new Task();
		
		Item item = itemRepository.findOne(id);
		
		task.setItem(item);
		task.setQuantity(quantity);
		task.setDesribe(describe);
		task.setStatus(Status.WAITING);
		
		User currentUser = userService.getCurrentUser();
		
		task.setUser(currentUser);
		
		task.setDate(new Date());
		
		taskRepository.save(task);
		
		return true;
	}
	
	@Transactional
	public Set<Task> getUserTask(String userId) {
		User user = userRepository.findOne(userId);
		Set<Task> tasks = user.getTask();
		
		return tasks;
	}
	
}
