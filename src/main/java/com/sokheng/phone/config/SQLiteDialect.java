package com.sokheng.phone.config;

import org.hibernate.dialect.H2Dialect;

public class SQLiteDialect extends H2Dialect {
    public SQLiteDialect() {
        super();
        registerKeyword("IF");
        registerKeyword("EXISTS");
    }
}