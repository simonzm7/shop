package com.ceiba.products.product.query;

import com.ceiba.domain.exception.TypeException;
import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.model.enums.ProductCategory;
import com.ceiba.products.product.port.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ListByCategory {

    private final ProductDao productDao;

    public List<ProductDto> execute(String category){
        try{
            return this.productDao.listByCategory(ProductCategory.valueOf(category));
        }catch (Exception e){
            throw new TypeException("Invalid product category");
        }
    }
}
