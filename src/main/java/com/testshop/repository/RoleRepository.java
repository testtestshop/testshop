package com.testshop.repository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.testshop.domain.UserRole;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<UserRole, Long> {
}
