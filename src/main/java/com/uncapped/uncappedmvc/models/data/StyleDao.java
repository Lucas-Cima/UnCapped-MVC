package com.uncapped.uncappedmvc.models.data;


import com.uncapped.uncappedmvc.models.Style;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StyleDao extends CrudRepository<Style, Integer> {
}
