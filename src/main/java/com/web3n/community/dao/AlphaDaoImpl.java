package com.web3n.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @create 2020-03-17 10:09
 */
@Repository("AlphaDaoImpl")
public class AlphaDaoImpl  implements AlphaDao{
    @Override
    public String select() {
        return "null";
    }
}
