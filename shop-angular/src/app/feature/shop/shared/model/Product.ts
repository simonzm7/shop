import { ProductCategory } from "src/app/shared/enums/ProductCategory";

export class Product {
    id: BigInt;
    productName: string;
    description: string;
    productCategory: ProductCategory;
    productImageUrl: string;
    productStock: number;
    productDiscount: number;
    createdAt: Date;

    constructor(
        id: BigInt,
        productName: string,
        description: string,
        productCategory: ProductCategory,
        productImageUrl: string,
        productStock: number,
        productDiscount: number,
        createdAt: Date,
    ) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.productCategory = productCategory;
        this.productImageUrl = productImageUrl;
        this.productStock = productStock;
        this.productDiscount = productDiscount;
        this.createdAt = createdAt;
    }   
}