package com.example.A2.Entity;

import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductsArray {
    List<Products> products;
}
