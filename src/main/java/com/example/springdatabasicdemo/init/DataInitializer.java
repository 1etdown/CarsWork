package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.enums.*;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelService modelService;
    private final UserService userService;
    private final BrandService brandService;
    private final OfferService offerService;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword;

    @Autowired
    public DataInitializer(UserRepository userRepository, UserRoleRepository userRoleRepository,
                           ModelService modelService, UserService userService, BrandService brandService,
                           OfferService offerService, PasswordEncoder passwordEncoder,
                           @Value("${app.default.password}") String defaultPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelService = modelService;
        this.userService = userService;
        this.brandService = brandService;
        this.offerService = offerService;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initUsers();
        seedData();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var moderatorRole = new UserRole(Role.Moderator);
            var adminRole = new UserRole(Role.Admin);
            var normalUserRole = new UserRole(Role.User);
            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(normalUserRole);
        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }
    private void initAdmin() {
        var adminRole = userRoleRepository.findRoleByName(Role.Admin).orElseThrow();
        var adminUser = new Users("Admin", passwordEncoder.encode(defaultPassword), "Solid Snake", "admin@miit.ru", 30);
        adminUser.setRole(List.of(adminRole));
        userRepository.save(adminUser);
    }

    private void initModerator() {
        var moderatorRole = userRoleRepository.findRoleByName(Role.Moderator).orElseThrow();
        var moderatorUser = new Users("moderator", passwordEncoder.encode(defaultPassword), "Venom Snake", "moderator@miit.ru", 25);
        moderatorUser.setRole(List.of(moderatorRole));
        userRepository.save(moderatorUser);
    }

    private void initNormalUser() {
        var userRole = userRoleRepository.findRoleByName(Role.User).orElseThrow();
        var normalUser = new Users("user", passwordEncoder.encode(defaultPassword), "Liquid Snake", "user@miit.ru", 22);
        normalUser.setRole(List.of(userRole));
        userRepository.save(normalUser);
    }
    private void seedData() {

        AddBrandDto brandDto = new AddBrandDto(
                UUID.randomUUID(),
                "Porsche",
                new Date(),
                new Date()
        );
        AddBrandDto brandPorsche = brandService.createBrand(brandDto);

        AddModelDto modelDto = new AddModelDto(
                UUID.randomUUID(),
                "911",
                brandPorsche,
                Category.Car,
                "https://source.unsplash.com/random/200x200?sig=1",
                2004,
                2010,
                new Date(),
                new Date()
        );
        AddModelDto model911 = modelService.createModel(modelDto);
        AddModelDto modelDto2 = new AddModelDto(
                UUID.randomUUID(),
                "918",
                brandPorsche,
                Category.Car,
                "https://source.unsplash.com/random/200x200?sig=1",
                2004,
                2010,
                new Date(),
                new Date()
        );
        AddModelDto model918 = modelService.createModel(modelDto2);

        var adminRole = userRoleRepository.findRoleByName(Role.Admin).orElseThrow();
        var adminUser = new Users("admin", passwordEncoder.encode(defaultPassword), "Solid Snake", "admin@miit.ru", 30);
        adminUser.setRole(List.of(adminRole));
        userRepository.save(adminUser);

        // Creating an offer using the model created above
        AddOfferDto offerDto = new AddOfferDto(
                UUID.randomUUID(),
                model911,
                "admin",
                "Sport Car",
                EngineType.GASOLINE,
                "https://upload.wikimedia.org/wikipedia/commons/c/c4/Porsche_911_Turbo.jpg",
                100,
                new BigDecimal(25000),
                TransmissionType.MANUAL,
                2007,
                new Date(),
                new Date()
        );
        offerService.createOffer(offerDto);

        AddOfferDto offerDto2 = new AddOfferDto(
                UUID.randomUUID(),
                model918,
                "admin",
                "Sport Car",
                EngineType.GASOLINE,
                "https://s.auto.drom.ru/img4/catalog/photos/fullsize/porsche/918/porsche_918_35767.jpg",
                100,
                new BigDecimal(1000000),
                TransmissionType.MANUAL,
                2007,
                new Date(),
                new Date()
        );
        offerService.createOffer(offerDto2);
    }


}
