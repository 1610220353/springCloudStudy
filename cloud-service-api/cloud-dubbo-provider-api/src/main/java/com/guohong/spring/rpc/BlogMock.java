package com.guohong.spring.rpc;


import com.guohong.spring.model.Blog;

/**
 * 降级容错
 *
 * @author Chill
 */
public class BlogMock implements IBlogRpc {
	@Override
	public Blog detail(Integer id) {
		return null;
	}
}
