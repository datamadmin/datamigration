package com.dataeconomy.framework.util;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585399872665084128L;

	protected LocalDateTimeSerializer() {
		super(LocalDateTime.class);
	}

	@Override
	public void serialize(LocalDateTime localdateTime, JsonGenerator jsonGen, SerializerProvider arg2)
			throws IOException {
		jsonGen.writeString(DateUtils.convertToDisplayFormat(localdateTime));

	}

}