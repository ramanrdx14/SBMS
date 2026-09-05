package org.example;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
public class Customer {
    private Integer cid;
    private String cname;
    private Double csalary;
}
