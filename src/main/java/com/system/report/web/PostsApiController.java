package com.system.report.web;

import com.system.report.service.posts.PostsService;
import com.system.report.web.dto.PostResponseDto;
import com.system.report.web.dto.PostsSaveRequestDto;
import com.system.report.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto requestsDto){
    return postsService.save(requestsDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
    return postsService.update(id,requestDto);
  }

  @GetMapping("/api/v1/posts/{id}"){
    public PostResponseDto findById(@PathVariable Long id){
      return postsService.findById(id);
    }
  }

}
