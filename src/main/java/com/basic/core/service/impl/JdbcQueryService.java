package com.basic.core.service.impl;
import com.basic.core.service.IJdbcQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class JdbcQueryService implements IJdbcQueryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public <T> List<T> queryForList(String sql, Class<T> elementType, @Nullable Object[] args) {
       return  jdbcTemplate.queryForList(sql, elementType, args);
    }
}
