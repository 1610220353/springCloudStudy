package com.guohong.spring.rpc;

import com.guohong.spring.model.Blog;
import org.apache.dubbo.config.annotation.Service;


/**
 * BlogRpc实现类
 *
 * @author Chill
 */
@Service(
	version = "1.0.0"
)
public class BlogRpc implements IBlogRpc {
	@Override
	public Blog detail(Integer id) {
		Blog blog = new Blog();
		blog.setId(id);
		blog.setTitle("博客标题");
		blog.setContent("博客内容");
		return blog;
	}
}
