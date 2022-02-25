package com.carlosveigafilho.dscatalog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carlosveigafilho.dscatalog.entities.Category;
import com.carlosveigafilho.dscatalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//Esta consulta sozinha nao resolve o problema de N mais 1 consultas
	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE "
			+ "(COALESCE(:categories) IS NULL OR cats IN :categories) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT ('%', :name, '%')))")
	Page<Product> find(List<Category> categories, String name, Pageable pageable);
	
	//Para resolver, acrescente esta solucao
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products")
	List<Product> findProductsWithCategories(List<Product> products);
	
	/* Esta consulta funcionou no H2 mas não funcionou no PostgreSQL
	 * @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE "
			+ "(:category IS NULL OR :category IN cats) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT ('%', :name, '%')))")
	Page<Product> find(Category category, String name, Pageable pageable);
	 */
}
