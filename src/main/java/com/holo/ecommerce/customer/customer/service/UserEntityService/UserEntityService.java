package com.holo.ecommerce.customer.customer.service.UserEntityService;
import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.config.auth.enums.AuthenticationMessageResponse;
import com.holo.ecommerce.config.auth.exception.WrongCredentialException;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.enums.UserExceptionResponse;
import com.holo.ecommerce.customer.customer.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        return getDao().findById(userId).orElseThrow(() -> new ItemNotFoundException(UserExceptionResponse.USER_NOT_FOUND.getMessage()));
    }
    public User FindUserByEmailAddress(String email){
        return getDao().findByEmailAddress(email).orElseThrow(() -> new WrongCredentialException(AuthenticationMessageResponse.AUTHENTICATE_FAILURE.getMessage()));
    }
    public User SaveUser(User user) {
        return getDao().save(user);
    }
    public User DeleteUser(Long userId) {
        User user = getDao().findById(userId).orElseThrow(() -> new ItemNotFoundException(UserExceptionResponse.USER_NOT_FOUND.getMessage()));
        getDao().deleteById(userId);
        return user;
    }

}
