package com.freightportal.dto;

import com.freightportal.model.*;
import jakarta.validation.constraints.*;

class UpdateLoadStatusRequest {

    @NotNull(message = "Status is required")
    private LoadStatus status;

    public UpdateLoadStatusRequest() {
    }

    public UpdateLoadStatusRequest(LoadStatus status) {
        this.status = status;
    }

    public LoadStatus getStatus() {
        return status;
    }

    public void setStatus(LoadStatus status) {
        this.status = status;
    }
}