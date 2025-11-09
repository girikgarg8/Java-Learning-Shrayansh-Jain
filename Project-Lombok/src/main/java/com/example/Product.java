package com.example;

import lombok.*;

@Data
@Builder
/**
 * Shortcut for
 *
 *  - @ToString
 *
 * @EqualsAndHashCode
 *
 * @Getter on all fields
 *
 * @Setter on all non-final fields
 *
 * @RequiredArgsConstructor
 */

@Value // All fields are made "private" and "final".
public class Product {
     String id;
     String name;
}
