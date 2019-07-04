package com.basic.core.service;

import org.springframework.lang.Nullable;

import java.util.List;

public interface IJdbcQueryService {
    <T> List<T> queryForList(String sql, Class<T> elementType, @Nullable Object[] args) ;
}
