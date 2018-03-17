package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.INewsFileDao;
import com.atlyakov.vshop.entity.NewsFileEntity;
import org.springframework.stereotype.Repository;

@Repository
public class NewsFileDaoImpl extends AbstractDao<NewsFileEntity> implements INewsFileDao {
}
