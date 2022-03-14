package io.gate.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Deserializer for {@link LocalDateTime}s.
 */
public class TimestampDeserializer extends LocalDateTimeDeserializer {

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        long value = parser.getValueAsLong();
        Instant instant = Instant.ofEpochSecond(value);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
