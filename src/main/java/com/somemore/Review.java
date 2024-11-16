package com.somemore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)


    @Column(name = "center_id", nullable = false, length = 16)
    private Strin centerId;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "img_url")
    private String imgUrl;

}