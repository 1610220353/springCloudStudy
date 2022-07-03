package com.guohong.spring;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

import static org.springframework.util.StringUtils.capitalize;

/**
 * Created by JackieGao on 2018-12-20.
 */
public class CamelCaseNamingStrategy extends DefaultGeneratorStrategy {
    @Override
    public String getJavaClassName(final Definition definition, final Mode mode) {
        StringBuilder result = new StringBuilder();
        result.append(capitalize(definition.getOutputName()));
        if (mode == Mode.RECORD) {
            result.append("Record");
        } else if (mode == Mode.DAO) {
            result.append("DAO");
        }
        return result.toString();
    }

}
