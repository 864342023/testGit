package com.sxt.bls.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxt.bls.service.BookService;
import com.sxt.bls.utils.PageBean;
import com.sxt.bls.utils.StackUtils;
import com.sxt.bls.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<BookVo> {
    @Autowired
    private BookService bookService;
    private int currentPage;

    public String findBookList(){
        if (currentPage == 0){
            currentPage = 1;
        }
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        List<BookVo> bookVos = bookService.findBookListForPageByKeywords(bookVo, pageBean);
        StackUtils.putStack("bookList",bookVos);
        StackUtils.putStack("page",pageBean);
        return "bookList";
    }



    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private BookVo bookVo = new BookVo();
    @Override
    public BookVo getModel() {
        return bookVo;
    }


}
