package com.itproger.blog.repo;

import com.itproger.blog.models.MyOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<MyOrder, Long> {
}
