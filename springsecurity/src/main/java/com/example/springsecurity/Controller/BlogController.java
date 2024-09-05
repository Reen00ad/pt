//package com.example.springsecurity.Controller;
//
//import com.example.springsecurity.Model.Blog;
//import com.example.springsecurity.Model.User;
//import com.example.springsecurity.Service.BlogService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/blog")
//@RequiredArgsConstructor
//public class BlogController {
//
//    private final BlogService blogService;
//
//    @GetMapping("/getalla")
//    public ResponseEntity getAllBlogs(){
//        return ResponseEntity.status(200).body(blogService.getAllBlogs());
//    }
//
////
//    @PostMapping("/add")
//    public ResponseEntity addBlogs(@AuthenticationPrincipal User user, @RequestBody @Valid Blog blog){
//        blogService.addBlog(user.getId(),blog);
//        return ResponseEntity.status(200).body("blog added successfully");
//    }
//    @PutMapping("/update/{blogid}")
//    public ResponseEntity updateBlog(@AuthenticationPrincipal User user,@PathVariable Integer blogid, @RequestBody @Valid Blog blog){
//        blogService.updateBlog(user.getId(),blogid,blog);
//        return ResponseEntity.status(200).body("blog updated successfully");
//    }
//    @DeleteMapping("/delete/{blogid}")
//    public ResponseEntity deleteBlog(@AuthenticationPrincipal User user,@PathVariable Integer blogid){
//        blogService.deleteBlog(user.getId(),blogid);
//        return ResponseEntity.status(200).body("blog deleted successfully");
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity getMyBlogs(@AuthenticationPrincipal User user){
//    return ResponseEntity.status(200).body(blogService.getMyBlogs(user.getId()));
//    }
//    @GetMapping("/getBlogById/{blogid}")
//    public ResponseEntity getBlogById(@AuthenticationPrincipal User user,@PathVariable Integer blogid){
//        return ResponseEntity.status(200).body(blogService.getBlogById(user.getId(),blogid));
//    }
//    @GetMapping("/getBlogByTitle/{blogtitle}")
//    public ResponseEntity getBlogByTitle(@AuthenticationPrincipal User user,@PathVariable String blogtitle){
//        return ResponseEntity.status(200).body(blogService.getBlogByTitle(user.getId(),blogtitle));
//    }
//}
