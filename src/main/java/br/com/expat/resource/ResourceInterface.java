package br.com.expat.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ResourceInterface<T> {
	ResponseEntity<List<T>> get();
	ResponseEntity<?> get(Long id);
	ResponseEntity<T> post(T obj);
	ResponseEntity<?> put(T obj);
	ResponseEntity<?> delete(Long id);
}
