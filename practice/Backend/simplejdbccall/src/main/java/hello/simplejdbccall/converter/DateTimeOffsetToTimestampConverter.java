package hello.simplejdbccall.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOffsetToTimestampConverter implements Converter<OffsetDateTime, String> {
    private static DateTimeFormatter MAIN_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnnnnn xxx");
    
    @Override
    public String convert(OffsetDateTime source) {
        return source.format(MAIN_FORMATTER);
    }
}
