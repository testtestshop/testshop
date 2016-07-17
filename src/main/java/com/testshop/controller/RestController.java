package com.testshop.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface RestController<T> {
	String get(String id, Model model);
	String add(T input);
	String getAll(Model model);
	String update(String id, T input);
	String delete(String id);
	String deleteAll();
}
