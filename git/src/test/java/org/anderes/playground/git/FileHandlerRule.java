package org.anderes.playground.git;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class FileHandlerRule implements TestRule {

	private String txtFile;
	private String content;

	public FileHandlerRule(final String txtFile) {
		this.txtFile = txtFile;
		try {
			content = readFile(txtFile);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return base;
	}

	public String getContent() {
		return content;
	}
	
	public String getTxtFile() {
		return txtFile;
	}

	private String readFile(final String txtFile) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(getFile(txtFile).openStream()));
		String zeile = null;
		while ((zeile = in.readLine()) != null) {
			sb.append(zeile);
		}
		in.close();
		return sb.toString();
	}
	
	private URL getFile(final String txtFile) {
		return this.getClass().getResource(txtFile);
	}

}
