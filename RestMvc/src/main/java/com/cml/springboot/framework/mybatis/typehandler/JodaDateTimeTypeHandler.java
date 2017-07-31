package com.cml.springboot.framework.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

@MappedTypes(DateTime.class)
@SuppressWarnings("rawtypes")
public class JodaDateTimeTypeHandler implements TypeHandler {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {

		java.sql.Timestamp timestamp = null;

		if (parameter != null) {
			DateTime date = (DateTime) parameter;
			timestamp = Timestamp.valueOf(date.toString("yyyy-MM-dd HH:mm:ss"));
		}

		ps.setTimestamp(i, timestamp);
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Object o = rs.getObject(columnName);

		if (rs.wasNull()) {
			return null;
		}

		if (o instanceof Date || o instanceof String) {
			return new DateTime(o);
		} else {
			return o;
		}

	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Object o = cs.getObject(columnIndex);

		if (cs.wasNull()) {
			return null;
		}

		if (o instanceof Date || o instanceof String) {
			return new DateTime(o);
		} else if (o instanceof java.sql.Timestamp) {
			java.sql.Timestamp t = (java.sql.Timestamp) o;
			return new DateTime(t.getTime());
		} else {
			return o;
		}

	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		Object o = rs.getObject(columnIndex);

		if (rs.wasNull()) {
			return null;
		}

		if (o instanceof Date || o instanceof String) {
			return new DateTime(o);
		} else {
			return o;
		}
	}

}
