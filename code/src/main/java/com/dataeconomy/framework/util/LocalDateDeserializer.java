package com.dataeconomy.framework.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585399872665084128L;

	protected LocalDateDeserializer() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		String localDate = parser.readValueAs(String.class);
		if (StringUtils.isEmpty(localDate)) {
			return null;
		} else {
			return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(DateUtils.SIMPLE_DATE_FORMAT));
		}

	}

}