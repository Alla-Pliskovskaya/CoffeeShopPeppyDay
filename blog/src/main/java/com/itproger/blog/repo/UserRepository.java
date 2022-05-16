package com.itproger.blog.repo;

import com.itproger.blog.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    @Query("SELECT p FROM AppUser p WHERE p.login LIKE %?1%")

    List<AppUser> findAppUserByLogin(@RequestParam String login);
}
