package com.demo.productservice.repositories;

import com.demo.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder.In;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Optional<Product> findById(Integer id);

    @Query(value = "select * from product p where p.category = ?1 and p.sub_category = ?2", nativeQuery = true)
    List<Product> findByCategoryAndSubCategory(
            @Param("category") String category, @Param("sub_category") String sub_category);

    List<Product> findByCategory(String category);

    @Modifying
    @Query(value = "update product p set p.count = ?2 where p.id = ?1", nativeQuery = true)
    void updateProductCount(@Param("id") Integer id, @Param("qty") int qty);

    @Modifying
    @Query(value = "update product p set p.count = 20 where p.id = id", nativeQuery = true)
    void restockInventory(@Param("id") Integer id);


}
