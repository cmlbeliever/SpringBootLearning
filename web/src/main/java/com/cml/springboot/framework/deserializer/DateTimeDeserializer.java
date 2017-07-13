package com.cml.springboot.framework.deserializer;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateTimeDeserializer extends JsonSerializer<DateTime> {

	private String format = "yyyyMMddHHmmss";

	public DateTimeDeserializer() {
		System.out.println("===================================================dddddddddddddddddddddddddddddddddddd");
	}

	public DateTimeDeserializer(String format) {
		super();
		this.format = format;
	}

	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		if (null != value) {
			gen.writeString(value.toString(format));
		}
		System.out.println("==============================");
	}

}
