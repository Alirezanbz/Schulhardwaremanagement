package com.example.schulhardwaremanagement.Service;


import com.example.schulhardwaremanagement.Entity.Benutzer;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class LastScannedUserService {
    private Benutzer lastScannedUser;
    private String lastStatusMessage = "";

    public void setLastScannedUser(Benutzer user) {
        this.lastScannedUser = user;
        this.lastStatusMessage = "";
    }

    public void clearLastScannedUser() {
        this.lastScannedUser = null;
    }

    public void setLastStatusMessage(String message) {
        this.lastStatusMessage = message;
    }

    public Optional<Benutzer> getLastScannedUser() {
        return Optional.ofNullable(lastScannedUser);
    }

    public String getLastStatusMessage() {
        return lastStatusMessage;
    }
}
