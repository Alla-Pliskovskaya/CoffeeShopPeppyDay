package com.itproger.blog.repo;

import com.itproger.blog.models.CoffeePrice;
import com.itproger.blog.models.PriceId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoffeePriceRepository extends CrudRepository<CoffeePrice, PriceId>, PagingAndSortingRepository<CoffeePrice, PriceId> {
    Iterable<CoffeePrice> findAll(Sort sort);
}
