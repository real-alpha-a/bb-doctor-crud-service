package com.pmtech.doctorcrudservice.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // TODO: Replace this with actual logged-in user from SecurityContext
        return Optional.of("system_user");
    }
}