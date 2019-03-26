package hu.me.demo.service.impl;

import hu.me.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public final int adultMinimum = 18;

    @Override
    public boolean isAdult(int age) {
        return age > adultMinimum;
    }


}
