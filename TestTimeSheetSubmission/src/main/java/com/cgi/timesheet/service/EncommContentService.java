package com.cgi.timesheet.service;

import com.cgi.timesheet.models.entity.ParaType;

public interface EncommContentService extends GenericEncommContentService<ParaType, Integer> {
	ParaType getById(Integer id);
}
