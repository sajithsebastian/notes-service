package com.ss.samples.notes.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ss.samples.notes.model.StickyNote;
import com.ss.samples.notes.utis.WordWrap;

@Component
public class StickyNoteDao {
	private static List<StickyNote> notes = new ArrayList<>();

	static {
		notes.add(new StickyNote(notes.size() + 1, WordWrap.recursiveWrap(
				"Design a word wrap micro service which provides functionality to take an input string and wraps it so that none of the lines are longer than the max length. The lines should not break any word in the middle.",
				23)));
		notes.add(new StickyNote(notes.size() + 1, WordWrap.recursiveWrap(
				"Design a word wrap micro service which provides functionality",
				23)));

		notes.add(new StickyNote(notes.size() + 1, WordWrap.recursiveWrap(
				"Design a word",
				23)));
	}

	public List<StickyNote> findAll() {
		return notes;
	}

	public StickyNote save(StickyNote note) {
		note.setId(notes.size() + 1);
		notes.add(note);
		return note;
	}

	public StickyNote findOne(int id) {
		return notes.stream().filter(n -> n.getId() == id).findAny().orElse(null);
	}

	public StickyNote delete(int id) {
		StickyNote note = notes.stream().filter(n -> n.getId() == id).findAny().orElse(null);
		if (note != null) {
			notes.remove(id - 1);
		}
		return note;
	}

}
