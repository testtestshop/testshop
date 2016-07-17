package com.testshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testshop.domain.Item;
import com.testshop.domain.ItemType;

@Repository
@Transactional
public interface ItemTypeRepository extends CrudRepository<ItemType, Long>   {

}
