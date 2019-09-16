package com.dataeconomy.framework.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585399872665084128L;

	protected LocalDateTimeDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		String localDate = parser.readValueAs(String.class);
		if (StringUtils.isEmpty(localDate)) {
			return null;
		} else {
			return LocalDateTime.parse(localDate, DateTimeFormatter.ofPattern(DateUtils.DISPLAY_DATE_TIME_FORMAT)).atZone(ZoneId.of(AppWebUtils.getCurrentTimeZone()))
					.withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();

		}

	}

}