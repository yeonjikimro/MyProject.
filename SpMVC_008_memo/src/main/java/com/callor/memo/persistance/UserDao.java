package com.callor.memo.persistance;

import com.callor.memo.model.UserVO;

public interface UserDao extends GenericDao<UserVO, Long>{


	public void create_user_table();
}
