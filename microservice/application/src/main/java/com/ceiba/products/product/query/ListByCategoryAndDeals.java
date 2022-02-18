package com.ceiba.products.product.query;

import com.ceiba.domain.exception.TypeException;
import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.model.enums.ProductCategory;
import com.ceiba.products.product.port.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListByCategoryAndDeals {

    private final ProductDao productDao;

    public List<ProductDto> execute(String category){
        try{
            return this.productDao.listByCategoryAndDeals(ProductCategory.valueOf(category));
        }catch (Exception e){
            throw new TypeException("Invalid product category");
        }
    }
}
