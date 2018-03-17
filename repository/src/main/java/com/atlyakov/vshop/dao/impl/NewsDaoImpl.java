package com.atlyakov.vshop.dao.impl;

import com.atlyakov.vshop.dao.AbstractDao;
import com.atlyakov.vshop.dao.INewsDao;
import com.atlyakov.vshop.entity.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends AbstractDao<News> implements INewsDao {
}
