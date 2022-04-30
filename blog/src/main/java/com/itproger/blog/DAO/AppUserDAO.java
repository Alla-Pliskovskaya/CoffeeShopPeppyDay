package com.itproger.blog.DAO;

import com.itproger.blog.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
public class AppUserDAO
{
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String login)
    {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.login = :login ";
            Query query = entityManager.createQuery(sql, AppUser.class);

            query.setParameter("login", login);

            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
