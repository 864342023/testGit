package com.sxt.bls.service.impl;

import com.sxt.bls.dao.BookDao;
import com.sxt.bls.service.BookService;
import com.sxt.bls.utils.PageBean;
import com.sxt.bls.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao ;

    @Override
    public List<BookVo> findBookListForPageByKeywords(BookVo bookVo, PageBean pageBean) {
        /*Book book = new Book();
        BeanUtils.copyProperties(bookVo,book);*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BookVo> bookVoList = null;
        List<Object[]> list = bookDao.findBookListForPageByKeyWords(bookVo, pageBean);
        if (null != list && list.size() > 0){
            bookVoList = new ArrayList<>();
            for (Object[] objs : list ) {
                BookVo vo = new BookVo();
                vo.setBookid((Integer) objs[0]);
                vo.setBookCode(String.valueOf(objs[1]));
                vo.setBookName(String.valueOf(objs[2]));
                vo.setBookType(String.valueOf(objs[3]));
                vo.setAuthor(String.valueOf(objs[4]));
                vo.setPublishPress(String.valueOf(objs[5]));
                try {
                    vo.setPublishDate((Date) sdf.parseObject(String.valueOf(objs[6])));
                    vo.setCreationTime((Date) sdf.parseObject(String.valueOf(objs[9])));
                    vo.setLastUpdateTime((Date) sdf.parseObject(String.valueOf(objs[10])));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                vo.setIsBorrow((Integer) objs[7]);
                vo.setCreatedBy(String.valueOf(objs[8]));
                bookVoList.add(vo);

            }
        }
        return bookVoList;
    }

}
