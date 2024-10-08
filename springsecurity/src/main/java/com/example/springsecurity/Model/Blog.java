//package com.example.springsecurity.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Blog {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @NotEmpty(message = "title can't be empty")
//    @Column(columnDefinition = " varchar(20) not null ")
//    private String title;
//    @NotEmpty(message = "body can't be empty")
//    @Column(columnDefinition = " varchar(100) not null ")
//    private String body;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private User user;
//
//
//}
