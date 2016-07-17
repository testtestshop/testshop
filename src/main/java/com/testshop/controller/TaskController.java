package com.testshop.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.testshop.domain.Item;
import com.testshop.domain.Task;
import com.testshop.domain.User;
import com.testshop.domain.supply.Status;
import com.testshop.repository.ItemRepository;
import com.testshop.repository.TaskRepository;
import com.testshop.repository.UserRepository;
import com.testshop.service.TaskService;
import com.testshop.service.UserService;

@Controller
@RequestMapping(value = "api/task")
public class TaskController implements RestController<Task> {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Override
	public String get(@PathVariable String id, Model model) {
		model.addAttribute("task", taskRepository.findOne(Long.parseLong(id)));
		model.addAttribute("newTask", new Task());
		
		return "task/taskList";
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String getUserTasks(@PathVariable String userId, Model model) {
		String username = userService.getCurrentUser().getUsername();
		
		Set<Task> tasks = taskService.getUserTask(username);
		
		model.addAttribute("tasks", tasks);
		model.addAttribute("newTask", new Task());
		
		return "task/taskList";
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public String getAll(Model model) {
		model.addAttribute("tasks", (List<Task>) taskRepository.findAll());
		model.addAttribute("newTask", new Task());
		
		return "task/taskList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Override
	public String add(@ModelAttribute("newTask") Task input) {
		taskRepository.save(input);
		
		return "redirect:/api/task";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Override
	public String update(@PathVariable String id, @ModelAttribute("newTask") Task input) {
		input.setId(Long.parseLong(id));
		taskRepository.save(input);
		
		return "redirect:/api/task";
	}
	
	@RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
	public String updateStatus(@PathVariable String id, @RequestParam(value="status") String status) {
		Task task = taskRepository.findOne(Long.parseLong(id));
		
		task.setStatus(Status.valueOf(status));
		taskRepository.save(task);
		
		return "redirect:/api/task";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Override
	public String delete(@PathVariable String id) {
		taskRepository.delete(Long.parseLong(id));
		
		return "redirect:/api/task";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@Override
	public String deleteAll() {
		taskRepository.deleteAll();
		
		return "redirect:/api/task";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(
			@RequestParam("id") String itemId,
			@RequestParam("quantity") String quantity,
			@RequestParam("describe") String describe,
			HttpServletRequest request) {
		
		taskService.create(itemId, quantity, describe);
		
		return "redirect:/api/item";
	}
}
