/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.filter.wall.mysql;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.wall.WallUtils;

/**
 * SQLServerWallTest
 * 
 * @author RaymondXiu
 * @version 1.0, 2012-3-18
 * @see
 */
public class MySqlWallTest8 extends TestCase {

    public void test_true() throws Exception {
        Assert.assertTrue(WallUtils.isValidateMySql(//
        "SELECT a.* FROM vote_info a where 1=1 AND FID = ?")); // 前置永真
    }
    
    public void test_false_1() throws Exception {
        Assert.assertFalse(WallUtils.isValidateMySql(//
        "SELECT a.* FROM vote_info a where FID = ? AND 1=1")); // 后置永真，拦截
    }
    
    public void test_false_2() throws Exception {
        Assert.assertFalse(WallUtils.isValidateMySql(//
        "SELECT a.* FROM vote_info a where FID = ? OR (FID = ? AND 1=1)")); // 后置永真，拦截
    }
    
    public void test_false_3() throws Exception {
        Assert.assertFalse(WallUtils.isValidateMySql(//
        "SELECT a.* FROM vote_info a where FID = ? OR (1=1 AND FID = ?)")); // 后置永真，拦截
    }
}