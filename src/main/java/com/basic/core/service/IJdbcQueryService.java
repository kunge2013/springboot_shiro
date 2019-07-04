package com.basic.core.service;

import org.springframework.jdbc.core.RowMapper;

public interface IJdbcQueryService {
    public void queryForList(String sql, RowMapper rowMapper, Callback call);
}
