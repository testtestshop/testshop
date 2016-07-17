package com.testshop.listener;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import com.testshop.domain.Item;
import com.testshop.domain.UserRole;
import com.testshop.domain.supply.Role;
import com.testshop.repository.ItemRepository;
import com.testshop.repository.RoleRepository;
import com.testshop.repository.UserRepository;
import com.testshop.service.UserService;


@Repository
@Lazy(false)
public class AddUsersOnStaredListener {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired(required = true)
	private RoleRepository roleRepository;
	
	@Transactional
	private void addDefaultUsers(ContextRefreshedEvent event) {
		log.info("i am working!");
		
		itemRepository = event.getApplicationContext().getBean("itemRepository", ItemRepository.class);

		Item item = new Item();
		item.setName("cat");
		item.setCost(BigDecimal.valueOf(3L));
		item.setQuantity(3);
		item.setDescr("nya");
		itemRepository.save(item);
		
		userService.registration("admin", "testpass", Role.ROLE_ADMIN);
		userService.registration("user", "testpass", Role.ROLE_USER);
		userService.registration("user2", "testpass", Role.ROLE_USER);
		
		log.info("end working!");
		
	}
	
	@EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
    	addDefaultUsers(event);
    }
}
