package com.dataeconomy.framework.util;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateSerializer extends StdSerializer<LocalDate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585399872665084128L;

	protected LocalDateSerializer() {
		super(LocalDate.class);
	}

	@Override
	public void serialize(LocalDate localDate, JsonGenerator jsonGen, SerializerProvider arg2)
			throws IOException {
		jsonGen.writeString(DateUtils.convertToFilterDateString(localDate));

	}

}