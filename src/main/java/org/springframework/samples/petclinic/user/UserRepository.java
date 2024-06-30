package org.springframework.samples.petclinic.user;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<User, Integer> {

	User findById(@Param("id") Integer id);

	void save(User user);

}
