package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.entity.User;
import com.pairone.library.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthBusinessRule {
    private final UserRepository userRepository;

    public AuthBusinessRule(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new BusinessException("Wrong username or password"));

    }
}
