package com.cml.learn.jpa.framework.db.converter;

import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

/**
 * 数据库date类型转换成DateTime
 * 
 * @author cml
 *
 */
@Converter(autoApply = true)
public class DateToDateTimeConverter implements AttributeConverter<DateTime, Date> {

	@Override
	public Date convertToDatabaseColumn(DateTime attribute) {
		if (attribute != null) {
			return new Date(attribute.getMillis());
		}
		return null;
	}

	@Override
	public DateTime convertToEntityAttribute(Date dbData) {
		if (dbData != null) {
			return new DateTime(dbData.getTime());
		}
		return null;
	}

}
