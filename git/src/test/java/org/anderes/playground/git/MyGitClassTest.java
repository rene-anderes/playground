package org.anderes.playground.git;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.ClassRule;
import org.junit.Test;

public class MyGitClassTest {
	
	private final Pattern pattern = Pattern.compile("q[^u]");
	private final Pattern patternHr = Pattern.compile("<[h|H][r|R] ?((size|SIZE)? ?= ?\"[0-9]+\" ?)?>");
	
	@ClassRule
	public static FileHandlerRule rule = new FileHandlerRule("RegEx.html");
	
	@Test
	public void RegEx1() {
		String text = rule.getContent();
		
		Matcher matcher = patternHr.matcher(text);
		
		int counter = 0;
		while (matcher.find()) {
			counter++;
		}
		assertThat(counter, is(4));
	}

}
