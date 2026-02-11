package com.pos.payload.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorySalesDTO {
    private String categoryName;
    private Double totalSales;
    private Long quantitySold;
}
