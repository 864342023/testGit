package com.sxt.bls.dao.impl;

import com.sxt.bls.dao.BookDao;
import com.sxt.bls.pojo.Book;
import com.sxt.bls.utils.BaseHibernateDaoSupport;
import com.sxt.bls.utils.PageBean;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookDaoImpl extends BaseHibernateDaoSupport implements BookDao {


    @Override
    public List<Object[]> findBookListForPageByKeyWords(Book book , PageBean pageBean) {
        pageBean.setTotalCount(getTotalCount(book));
        return this.getHibernateTemplate().execute((HibernateCallback<List<Object[]>>) session -> {
            String sql = "select * from books b where b.bookType like ? and b.bookName like ? ";
            SQLQuery sqlQuery ;
            if (book.getIsBorrow() != null){
                sql += " and b.isBorrow = ? order by b.creationTime";
                sqlQuery = session.createSQLQuery(sql);
                sqlQuery.setString(0,"%" + book.getBookType() + "%");
                sqlQuery.setString(1,"%" + book.getBookName() + "%");
                sqlQuery.setInteger(2,book.getIsBorrow());
            }else {
                sql += " order by b.creationTime";
                sqlQuery = session.createSQLQuery(sql);
                sqlQuery.setString(0,"%" + book.getBookType() + "%");
                sqlQuery.setString(1,"%" + book.getBookName() + "%");
            }
            sqlQuery.setFirstResult((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            sqlQuery.setMaxResults(pageBean.getPageSize());
            return sqlQuery.list();
        });
    }

    private int getTotalCount(Book book){
        String hql = "select new Book( b.bookid , b.bookCode, b.bookName , b.bookType, b.author, b.publishPress, b.publishDate, b.isBorrow, b.createdBy, b.creationTime, b.lastUpdateTime) from Book b where b.bookType like ? and b.bookName like ? ";
        if (book.getIsBorrow() != null){
            hql += " and b.isBorrow = ?";
            return this.getHibernateTemplate().find(hql , "%" + book.getBookType() + "%" , "%" + book.getBookName() + "%" , book.getIsBorrow()).size();
        }else {
            return this.getHibernateTemplate().find(hql , "%" + book.getBookType() + "%" , "%" + book.getBookName() + "%" ).size();
        }
    }
}
