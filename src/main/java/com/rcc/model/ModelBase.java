package com.rcc.model;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.HashMap;
import java.util.Map;

public class ModelBase extends SqlMapClientDaoSupport {

    protected Map createParams(Object... args) {
        Map params = new HashMap();
        Object name = null;
        for (Object o : args) {
            if (name == null) {
                name = o;
            } else {
                params.put(name, o);
                name = null;
            }
        }
        return params;
    }
}
