package com.testshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testshop.domain.Item;
import com.testshop.domain.UserRole;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Long>  {

}
