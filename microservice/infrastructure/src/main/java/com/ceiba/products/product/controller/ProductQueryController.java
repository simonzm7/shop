package com.ceiba.products.product.controller;


import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.query.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductQueryController {

    private final ListMyProductsHandler myProductsHandler;
    private final ListBestDiscountProductHandler listBestDiscountProductHandler;
    private final ListDiscountProductHandler listDiscountProductHandler;
    private final ListByCategory listByCategory;
    private final ListByCategoryAndDeals listByCategoryAndDeals;

    private String getUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @GetMapping("/{id}")
    public void findProduct() {

    }

    @GetMapping("/me")
    public List<ProductDto> listMyProducts(){
        return this.myProductsHandler.execute(this.getUser());
    }

    @GetMapping("/best-discounts")
    public List<ProductDto> listBestDiscounts(){
        return this.listBestDiscountProductHandler.execute();
    }
    @GetMapping("/discounts")
    public List<ProductDto> listDiscounts(){
        return this.listDiscountProductHandler.execute();
    }

    @GetMapping("/category")
    public List<ProductDto> listByCategory(@RequestParam("type") String category){
        return this.listByCategory.execute(category);
    }

    @GetMapping("/category/deals")
    public List<ProductDto> listByCategoryAndDeals(@RequestParam("type") String category){
        return this.listByCategoryAndDeals.execute(category);
    }



}
