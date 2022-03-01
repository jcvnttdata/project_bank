package com.nttdata.project_bank.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "customer_type")
@NoArgsConstructor
public class CustomerType {

    @Id
    private int id;

    private String name_type;
}
