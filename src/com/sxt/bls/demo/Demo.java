package com.sxt.bls.demo;

import com.sxt.bls.dao.impl.BookDaoImpl;
import com.sxt.bls.pojo.Book;
import com.sxt.bls.service.BookService;
import com.sxt.bls.service.impl.BookServiceImpl;
import com.sxt.bls.utils.PageBean;
import com.sxt.bls.vo.BookVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Demo {

    @Test
    public void findBookList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        BookService bean = applicationContext.getBean(BookService.class);
        BookVo book = new BookVo();
        book.setBookType("小说");
        book.setBookName("帝尊");

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(1);
        List<BookVo> list = bean.findBookListForPageByKeywords(book ,pageBean);
        System.out.println(pageBean.getTotalCount());
        System.out.println(list);
    }

}
