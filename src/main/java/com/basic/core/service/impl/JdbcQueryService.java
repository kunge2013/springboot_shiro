package com.basic.core.service.impl;

import com.basic.core.service.Callback;
import com.basic.core.service.IJdbcQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class JdbcQueryService implements IJdbcQueryService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void queryForList(String sql, RowMapper rowMapper, Callback call) {
        call.callBack(this.jdbcTemplate.query(sql, rowMapper));
    }
}
