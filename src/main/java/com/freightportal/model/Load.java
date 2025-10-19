package com.freightportal.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import com.freightportal.model.LoadStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Document(collection = "loads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Load {
    @Id
    private String id;

    @NotBlank
    private String loadNumber;

    @NotNull
    private String shipperId;

    private String shipperName;

    @NotNull
    private Location pickup;

    @NotNull
    private Location delivery;

    @NotNull
    private Cargo cargo;

    @NotNull
    private BigDecimal rate;

    @NotNull
    private String currency = "USD";

    @Enumerated(EnumType.STRING)
    private LoadStatus status = LoadStatus.AVAILABLE;

    private LocalDateTime postedDate;
    private LocalDateTime pickupDate;
    private LocalDateTime deliveryDate;

    private List<String> specialRequirements;
    private String notes;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

