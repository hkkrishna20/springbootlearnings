
package com.cgi.timesheet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.timesheet.models.entity.ParaType;
import com.cgi.timesheet.service.EncommContentService;

@RestController
@RequestMapping("/contentTable")
public class ContentTableController {

	@Autowired
	EncommContentService encommContentTypeService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<ParaType> getAllPosts(Pageable pageable) {

		List<ParaType> ParaType = encommContentTypeService.getAll();
		if (ParaType.isEmpty()) {
			return null;
		}
		return ParaType;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ParaType get(@PathVariable("id") String id) {
		ParaType inc = encommContentTypeService.get(Integer.parseInt(id));
		if (inc == null) {
			return null; 
		}
		return inc;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)

	public ResponseEntity<Void> create(@Valid @RequestBody ParaType ParaType) {
		encommContentTypeService.add(ParaType);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ParaType ParaType) {
		ParaType inc = encommContentTypeService.find(ParaType.getContentId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			encommContentTypeService.update(ParaType);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePost(@PathVariable("id") String id) {
		ParaType inc = encommContentTypeService.find(Integer.parseInt(id));
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			encommContentTypeService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}