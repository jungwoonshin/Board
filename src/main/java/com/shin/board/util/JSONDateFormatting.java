package com.shin.board.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

// MappingJacksonJSONView의 Date 처리를 위한 클래스
public class JSONDateFormatting extends JsonSerializer<Date> {
	@Override
	public void serialize(Date comment_date, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String formattedDate = formatter.format(comment_date);
		gen.writeString(formattedDate);
	}
}
