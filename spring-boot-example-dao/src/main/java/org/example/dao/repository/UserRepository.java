package org.example.dao.repository;

import org.example.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
    User findByUserNameAndUserPwd(String userName, String userPwd);
}
