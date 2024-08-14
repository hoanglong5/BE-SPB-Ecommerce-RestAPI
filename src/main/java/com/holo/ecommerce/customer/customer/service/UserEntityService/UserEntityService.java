package com.holo.ecommerce.customer.customer.service.UserEntityService;
import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.enums.UserExceptionMessage;
import com.holo.ecommerce.customer.customer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEntityService extends BaseService<User, UserRepository> {
    public UserEntityService(UserRepository dao) {
        super(dao);
    }

    public List<User> FindAllUser() {
        return getDao().findAll();
    }

    public User FindUserById(Long userId) {
        return getDao().findById(userId).orElseThrow(() -> new ItemNotFoundException(UserExceptionMessage.USER_NOT_FOUND.getMessage()));
    }
    public User SaveUser(User user) {
        return getDao().save(user);
    }
    public User DeleteUser(Long userId) {
        User user = getDao().findById(userId).orElseThrow(() -> new ItemNotFoundException(UserExceptionMessage.USER_NOT_FOUND.getMessage()));
        getDao().deleteById(userId);
        return user;
    }
}
