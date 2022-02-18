package com.ceiba.products.product.query;

import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.port.dao.ProductDao;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ListMyProductsHandler {

    private final ProductDao productDao;
    private final UserDao userDao;

    public List<ProductDto> execute(String email){
        BigInteger userId = this.userDao.findUserIdByEmail(email);
        return this.productDao.listMyProductsByEmail(userId);
    }

}
