package com.guohong.spring.rpc;


import com.guohong.spring.model.Blog;

/**
 * RPC接口类
 *
 * @author Chill
 */
public interface IBlogRpc {

	/**
	 * Blog详情
	 *
	 * @param id 主键
	 * @return
	 */
	Blog detail(Integer id);
}
