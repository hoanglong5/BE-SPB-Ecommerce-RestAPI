package com.holo.ecommerce.product.service.entityservice;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.entity.ProductItem;
import com.holo.ecommerce.product.enums.ProductExceptionResponse;
import com.holo.ecommerce.product.repository.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemEntityService extends BaseService<ProductItem, ProductItemRepository> {
    public ProductItemEntityService(ProductItemRepository dao) {
        super(dao);
    }
    public List<ProductItem> GetAllProductItem(){
        return getDao().findAll();
    }
    public ProductItem GetProductItem(Long productItemId){
        return getDao().findById(productItemId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.PRODUCT_ITEM_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }

    public ProductItem DeleteProductItem(Long productItemId){
        getDao().deleteById(productItemId);
        ProductItem productItem = getDao().findById(productItemId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.PRODUCT_ITEM_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
        return productItem;
    }

    public ProductItem SaveProductItem(ProductItem productSaving){
        return getDao().save(productSaving);
    }
}
