package org.example.dao.repository;


import org.example.model.Demo;
import org.springframework.data.repository.ListCrudRepository;

import java.io.Serializable;

public interface DemoRepository extends ListCrudRepository<Demo, Long>, Serializable {

}
