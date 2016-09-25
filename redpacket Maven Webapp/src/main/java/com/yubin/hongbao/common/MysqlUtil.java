package com.yubin.hongbao.common;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作mysql数据库工具类
 * @author acer-pv
 *
 */
public class MysqlUtil {
	
	private static JdbcTemplate jdbcTemplate = MysqlJdbcTemplate.getJdbcTemplate();
	
	/**
	 * 获取jdbc连接
	 * @return
	 */
	public static JdbcTemplate getJdbcTemplate() {
		return MysqlJdbcTemplate.getJdbcTemplate();
	}
	
	
	public static int update(String sql, Object... args) {
		try {
			return jdbcTemplate.update(sql, args);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<Map<String, Object>> test() {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String  sql = "select * from red_packet";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		/*for(Map<String, Object> map:list) {
			for(String key:map.keySet()) {
				System.out.print("["+key+":"+map.get(key)+"]");
			}
			System.out.println("\n");
		}*/
		if(list != null && list.size() > 0 ) {
			return list;
		}
		return null;
	}
}	
