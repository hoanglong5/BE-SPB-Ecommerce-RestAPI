package com.holo.ecommerce.customer.customer.service.UserEntityService;

import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.repository.UserRepository;

public class UserEntityService extends BaseService<User, UserRepository> {
    public UserEntityService(UserRepository dao) {
        super(dao);
    }
}
