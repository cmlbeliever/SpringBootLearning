package com.cml.springboot.framework.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.LocalTime;

import com.cml.springboot.framework.util.DateUtil;

@MappedTypes(LocalTime.class)
@SuppressWarnings("rawtypes")
public class JodaLocalTimeTypeHandler implements TypeHandler {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {

		java.sql.Time time = null;

		if (parameter != null) {
			LocalTime localtime = (LocalTime) parameter;
			time = DateUtil.convert(localtime);
		}

		ps.setTime(i, time);
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Object o = rs.getObject(columnName);

		if (rs.wasNull()) {
			return null;
		}

		if (o instanceof java.sql.Time) {
			return new LocalTime(((java.sql.Time) o).getTime());
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

		if (o instanceof java.sql.Time) {
			return new LocalTime(((java.sql.Time) o).getTime());
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

		if (o instanceof java.sql.Time) {
			return new LocalTime(((java.sql.Time) o).getTime());
		} else {
			return o;
		}
	}

}
