package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.EmailToken;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.PasswordResetTokenRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmailTokenServiceImpl implements EmailTokenService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public void save(EmailToken emailToken) {
        passwordResetTokenRepository.save(emailToken);
    }

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public EmailToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public EmailToken findByUser(User user) {
        return passwordResetTokenRepository.findByUser(user);
    }

    @Override
    public void delete(EmailToken token) {
        passwordResetTokenRepository.delete(token);
    }

    @Override
    public boolean isExpired(LocalDateTime expireDate) {
        LocalDateTime now = LocalDateTime.now();
        return expireDate.isBefore(now);
    }


}