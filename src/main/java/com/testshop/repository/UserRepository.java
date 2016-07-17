package com.testshop.repository;

import org.springframework.stereotype.Repository;

import com.testshop.domain.User;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, String> {
}
