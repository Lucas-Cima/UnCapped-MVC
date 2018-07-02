package com.uncapped.uncappedmvc.models.data;


import com.uncapped.uncappedmvc.models.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface BeerDao extends CrudRepository<Beer, Integer> {
}
