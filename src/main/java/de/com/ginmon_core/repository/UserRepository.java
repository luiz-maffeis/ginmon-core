package de.com.ginmon_core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.com.ginmon_core.model.UserComment;

public interface UserRepository extends CrudRepository<UserComment, Integer>{
	List<UserComment> findByLogin(String login);
	List<UserComment> findById(Integer id);

}
