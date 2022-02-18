package com.ceiba.products.product.query;


import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.port.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListBestDiscountProductHandler {

    private final ProductDao productDao;

    public List<ProductDto> execute(){
        return this.productDao.listBestDiscountProducts();
    }

}
