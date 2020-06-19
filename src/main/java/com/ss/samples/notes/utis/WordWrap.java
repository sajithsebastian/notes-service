package com.ss.samples.notes.utis;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WordWrap {
	private static final Logger logger = LoggerFactory.getLogger(WordWrap.class);

	public static void main(String[] args) {
		String sentenceUnwrapped= "Design a word wrap micro service which provides functionality to take an input string and wraps it so that none of the lines are longer than the max length. The lines should not break any word in the middle.";
		String[] words = sentenceUnwrapped.split(" ");
		
		String sentence="";
		System.out.println(Arrays.asList(words).stream().collect(Collectors.joining(" ")));
		sentence="";
		
		WordWrap wrap = new WordWrap();
		System.out.println(wrap.recursiveWrap(sentenceUnwrapped,23));							
	}
	
	public static String recursiveWrap(String text, int limit) {
		logger.debug("recursiveWrap");
		  if (text.length() > limit) {
		    // find the last space within limit
		    int edge = text.substring(0, limit).lastIndexOf(" ");
		    if (edge > 0) {
		      String line = text.substring(0, edge);
		      String remainder = text.substring(edge + 1);
		      return line + '\n' + recursiveWrap(remainder, limit);
		    }
		  }
		  return text;
		}	

}
