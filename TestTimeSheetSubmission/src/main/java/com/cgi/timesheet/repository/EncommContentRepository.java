package com.cgi.timesheet.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.timesheet.models.entity.ParaType;
@Repository
public interface EncommContentRepository extends CrudRepository<ParaType, Integer> {

}