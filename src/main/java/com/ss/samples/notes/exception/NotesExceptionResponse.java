package com.ss.samples.notes.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class NotesExceptionResponse {
	private Date timeStamp;
	private String message;
	private String details;

}
