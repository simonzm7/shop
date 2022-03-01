package com.ceiba.products.cart.controller;

import com.ceiba.products.cart.model.dto.CartDto;
import com.ceiba.products.cart.query.FetchMyCartList;
import com.ceiba.utils.AuthUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class QueryCartController {

    private final FetchMyCartList fetchMyCartList;
    private final AuthUserUtil authUserUtil;
    @GetMapping
    public List<CartDto> getMyCartList(){
        return this.fetchMyCartList.execute(this.authUserUtil.getUser());
    }
}
