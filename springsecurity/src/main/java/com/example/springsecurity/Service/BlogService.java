//package com.example.springsecurity.Service;
//
//import com.example.springsecurity.Api.ApiException;
//import com.example.springsecurity.Model.Blog;
//import com.example.springsecurity.Model.User;
//import com.example.springsecurity.Repository.AuthRepository;
//import com.example.springsecurity.Repository.BlogRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class BlogService {
//
//    private final BlogRepository blogRepository;
//    private final AuthRepository authRepository;
//
//    public List<Blog> getAllBlogs(){
//        return blogRepository.findAll();
//    }
//
//
//    public void addBlog(Integer userid, Blog blog){
//        User user=authRepository.findUserById(userid);
//
//        blog.setUser(user);
//
//        blogRepository.save(blog);
//    }
//
//    public void updateBlog(Integer userid,Integer blogid,Blog blog){
//        Blog b=blogRepository.findBlogById(blogid);
//
//        if(b == null){
//            throw new ApiException("blog not found");
//        }
//
//        if(b.getUser().getId() != userid){
//            throw new ApiException("user id mismatch");
//        }
//        b.setTitle(blog.getTitle());
//        b.setBody(blog.getBody());
//        blogRepository.save(b);
//    }
//
//    public void deleteBlog(Integer userid, Integer blogid){
//        Blog b=blogRepository.findBlogById(blogid);
//
//        if(b == null){
//            throw new ApiException("blog not found");
//        }
//        blogRepository.delete(b);
//    }
//
//    //-------------end crud
//
//
//
//        public List<Blog> getMyBlogs(Integer userid){
//            User user=authRepository.findUserById(userid);
//            //هدفي اني اوصل للايدي مو اشيك اذا موجود او لا
//
//            return blogRepository.findAllByUser(user);
//        }
//
//        public Blog getBlogById(Integer userid, Integer blogid){
//        Blog b=blogRepository.findBlogById(blogid);
//        if(b == null){
//            throw new ApiException("blog not found");
//        }
//        if(b.getUser().getId() != userid){
//            throw new ApiException("user id mismatch");
//        }
//        return b;
//        }
//
//        public Blog getBlogByTitle(Integer userid,String title){
//        Blog b=blogRepository.findBlogByTitle(title);
//        if(b == null){
//            throw new ApiException("blog not found");
//        }
//        if(b.getUser().getId() != userid){
//            throw new ApiException("user id mismatch");
//        }
//        return b;
//        }
//}
