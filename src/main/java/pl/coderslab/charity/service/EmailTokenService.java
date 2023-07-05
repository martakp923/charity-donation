package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.EmailToken;
import pl.coderslab.charity.entity.User;

import java.time.LocalDateTime;

public interface EmailTokenService {
    void save(EmailToken emailToken);

    String generateToken();

    EmailToken findByToken(String token);

    EmailToken findByUser(User user);

    void delete(EmailToken token);

    boolean isExpired(LocalDateTime expireDate);

}