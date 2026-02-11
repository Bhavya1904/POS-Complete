package com.pos.service.impl;

import com.pos.domain.UserRole;
import com.pos.modal.User;
import com.pos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializationComponent implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.password}")
    private String adminPassword;



    @Override
    public void run(String... args) {
        initializeAdminUser();
    }

    private void initializeAdminUser() {
        String adminUsername = "bhavya192004@gmail.com";

        if (userRepository.findByEmail(adminUsername)==null) {
            User adminUser = new User();

            adminUser.setPassword(passwordEncoder.encode(adminPassword));
            adminUser.setFullName("Bhavya");
            adminUser.setEmail(adminUsername);
            adminUser.setRole(UserRole.ROLE_ADMIN);

            User admin=userRepository.save(adminUser);
        }
    }
}
