package com.nttdata.project_bank.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document
@NoArgsConstructor
public class Customer {
    int customer_id;
    String customer_name;
}
