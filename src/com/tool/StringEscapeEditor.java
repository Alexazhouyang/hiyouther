package com.tool;

import java.beans.PropertyEditorSupport;
import org.apache.commons.lang.StringEscapeUtils;
public class StringEscapeEditor extends PropertyEditorSupport {


	public StringEscapeEditor() {
		super();
	}



	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;	
			setValue(value.replaceAll(".*([';]+|(--)+).*", " "));
		}
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}
}