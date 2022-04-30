package com.itproger.blog.repo;

import com.itproger.blog.models.MyOrder;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends CrudRepository<MyOrder, Long>, PagingAndSortingRepository<MyOrder, Long> {
    Iterable<MyOrder> findAll(Sort sort);
}
