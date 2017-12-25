package com.sxt.bls.dao;

import com.sxt.bls.pojo.Book;
import com.sxt.bls.utils.PageBean;

import java.util.List;

public interface BookDao {

    List<Object[]> findBookListForPageByKeyWords(Book book , PageBean pageBean);
}
