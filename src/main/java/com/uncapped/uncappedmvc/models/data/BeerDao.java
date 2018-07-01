package com.uncapped.uncappedmvc.models.data;


import com.uncapped.uncappedmvc.models.Beer;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BeerDao extends CrudRepository<Beer, Integer> {
}
