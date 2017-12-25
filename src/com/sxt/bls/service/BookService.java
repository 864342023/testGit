package com.sxt.bls.service;

import com.sxt.bls.utils.PageBean;
import com.sxt.bls.vo.BookVo;

import java.util.List;

public interface BookService {

    List<BookVo> findBookListForPageByKeywords(BookVo bookVo , PageBean pageBean);
}
