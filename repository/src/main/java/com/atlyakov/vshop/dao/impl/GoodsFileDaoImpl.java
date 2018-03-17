package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.IGoodsFileDao;
import com.atlyakov.vshop.entity.GoodsFileEntity;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsFileDaoImpl extends AbstractDao<GoodsFileEntity> implements IGoodsFileDao {
}
