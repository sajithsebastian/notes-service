package com.ss.samples.notes.model;


import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StickyNote {
	
	@NonNull
	int  id;
	@NonNull
	@Size(min=2,message="content length too small")
	private String content;	
	
	
	
			
}
