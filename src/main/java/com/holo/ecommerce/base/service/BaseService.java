package com.holo.ecommerce.base.service;

import com.holo.ecommerce.base.enums.ExceptionMessageResponse;
import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.exception.exceptions.ExceptionResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public abstract class BaseService<E,D extends JpaRepository<E,Long>> {
    private final D dao;
    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;
    public List<E> FindAll(){
        return dao.findAll();
    }
    public E FindById(Long id){
        return dao.findById(id).orElseThrow(() -> new ItemNotFoundException(ExceptionMessageResponse.ITEM_NOT_FOUND.getMessage()));
    }
    public E Save(E entity){
        entity = dao.save(entity);
        return entity;
    }
    public void Delete(E entity){
        dao.delete(entity);
    }
    protected Integer GetSize(Optional<Integer> sizeOptional) {
        Integer size = DEFAULT_SIZE;
        if (sizeOptional.isPresent()){
            int providedSize = sizeOptional.get();
            if(providedSize >= 0){
                size = sizeOptional.get();
            }else {
                return size;
            }
        }
        return size;
    }

    protected Integer GetPage(Optional<Integer> pageOptional) {
        Integer page = DEFAULT_PAGE;
        if (pageOptional.isPresent()){
            int providedPage = pageOptional.get();
            if(providedPage > 0){
                page = pageOptional.get();
            }else {
                return page;
            }
        }
        return page;
    }
    protected PageRequest GetPageRequest(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {
        Integer page = GetPage(pageOptional);
        Integer size = GetSize(sizeOptional);
        PageRequest pageRequest = PageRequest.of(page, size);
        return pageRequest;
    }
}
