package com.ss.samples.notes.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ss.samples.notes.dao.StickyNoteDao;
import com.ss.samples.notes.exception.NotesNotFoundException;
import com.ss.samples.notes.model.StickyNote;
import com.ss.samples.notes.utis.WordWrap;




@RestController
@RequestMapping(value = "v1")
public class NotesController {
	
    private static final Logger logger = LoggerFactory.getLogger(NotesController.class);

	
	@Autowired
	WordWrap wrapper;
	
	@Autowired 
	StickyNoteDao noteDao;
	
	@PostMapping(path ="/notes")
	@ResponseStatus(value = HttpStatus.CREATED)
	public StickyNote createNote(@Valid @RequestBody StickyNote note) {
		logger.info("createNote note={}",note.getContent());
		note.setContent(wrapper.recursiveWrap(note.getContent(),23));
		noteDao.save(note);			 		
		return note;	
	}
		

	@GetMapping(path ="/notes/{id}")
	public StickyNote getNote(@PathVariable int id) {
		logger.info("getNote id={}",id);
		//Find Note
		StickyNote note= noteDao.findOne(id);
		if(note == null ) {
			throw new NotesNotFoundException(String.format("Notes not found for id=%d ",id));
		}				
		return note;	
	}
	
	

	@GetMapping(path ="/notes")
	public List<StickyNote> getNotes() {
		
		logger.info("getNotes");
		
		//Find Note
		List<StickyNote> notes= noteDao.findAll();
		if(notes == null ) {
			throw new NotesNotFoundException(String.format("Notes not found"));
		}
		return notes;	
	}
	
	
	@DeleteMapping(path ="/notes/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public StickyNote deleteNote(@PathVariable int id) {
		
		logger.info("deleteNote id={}",id);
		//Find Note
		StickyNote note= noteDao.delete(id);
		if(note == null ) {
			throw new NotesNotFoundException(String.format("Notes not found for id=%d ",id));
		}
		return note;	
	}
	
	
	
}

