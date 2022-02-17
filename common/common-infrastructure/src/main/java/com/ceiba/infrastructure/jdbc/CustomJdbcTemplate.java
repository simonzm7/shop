package com.ceiba.infrastructure.jdbc;


import com.ceiba.infrastructure.exception.TechnicalException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;

@Repository
@RequiredArgsConstructor
@Getter
public class CustomJdbcTemplate {

    private static final String MAPPING_PARAMETERS_ERR_MESSAGE = "Error mapping parameters";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private MapSqlParameterSource createMapParameters(Object model){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        Field[] fields = model.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
            try{
                Field field = fields[i];
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                    field.setAccessible(true);
                    paramSource.addValue(field.getName(), field.get(model));
                    field.setAccessible(false);
                }
            } catch (Exception e){
                throw new TechnicalException(this.MAPPING_PARAMETERS_ERR_MESSAGE, e);
            }
        }
        return paramSource;
    }

    public BigInteger create(String sql, Object model){
        MapSqlParameterSource parameterSource = this.createMapParameters(model);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] { "id" });
        return BigInteger.valueOf(keyHolder.getKey().longValue());
    }

    public void update(String sql, Object model){
        MapSqlParameterSource parameterSource = this.createMapParameters(model);
        this.namedParameterJdbcTemplate.update(sql, parameterSource);
    }

}
