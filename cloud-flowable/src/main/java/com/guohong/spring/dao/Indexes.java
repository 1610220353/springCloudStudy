/*
 * This file is generated by jOOQ.
 */
package com.guohong.spring.dao;


import com.guohong.spring.dao.tables.Connectorconfig;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CONNECTORCONFIG_ID_UINDEX = Indexes0.CONNECTORCONFIG_ID_UINDEX;
    public static final Index CONNECTORCONFIG_PKEY = Indexes0.CONNECTORCONFIG_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CONNECTORCONFIG_ID_UINDEX = Internal.createIndex("ConnectorConfig_id_uindex", Connectorconfig.CONNECTORCONFIG, new OrderField[] { Connectorconfig.CONNECTORCONFIG.ID }, true);
        public static Index CONNECTORCONFIG_PKEY = Internal.createIndex("ConnectorConfig_pkey", Connectorconfig.CONNECTORCONFIG, new OrderField[] { Connectorconfig.CONNECTORCONFIG.ID }, true);
    }
}
