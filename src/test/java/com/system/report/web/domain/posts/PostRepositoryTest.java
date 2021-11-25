package com.system.report.web.domain.posts;

import com.system.report.domain.posts.PostRepository;
import com.system.report.domain.posts.Posts;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

  @Autowired
  PostRepository postsRepository;

  @After
  public void cleanup(){
    postsRepository.deleteAll();;
  }

  @Test
  public void getPost(){
    String title = "테스트 게시글";
    String content = "테스트 본문";
    postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("jojoldu@gmail.com")
                        .build());

    List<Posts> postList = postsRepository.findAll();

    Posts posts = postList.get(0);
    assertThat(posts.getTitle()).isEqualTo(title);
    assertThat(posts.getContent()).isEqualTo(content);
  }
}