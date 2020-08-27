/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.guohong.spring.rpc;

import com.guohong.spring.model.Blog;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * 本地检查
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class BlogStub implements IBlogRpc {

	private final IBlogRpc rpc;

	@Override
	public Blog detail(Integer id) {
		System.out.println(id);

		if (id == 1234) {
			return rpc.detail(id);
		}
		return null;
	}
}
