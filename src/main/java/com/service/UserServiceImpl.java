package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @desc
 **/
@Service("systemLogService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

    /**
     * 添加缓存,指定key为users,特别注意: key如果是纯字符串,有时候会不添加缓存,如果添加字符串则可以
     * @return
     */
    @Cacheable(value = "myCache",key = "'users'")
    public List<User> getUsers() {
        List<User> users = userDao.getUsers();
        for (User user : users) {
            System.out.println(user.getName());
        }
        return users;
    }

    /**
     * 查询指定用户数据
     * 添加缓存,指定key为0
     * condition属性默认为空，表示将缓存所有的调用情形。其值是通过SpringEL表达式来指定的
     * 当为true时表示进行缓存处理；当为false时表示不进行缓存处理，即每次调用该方法时该方法都会执行一次
     * @param id
     * @return
     */
    @Cacheable(value = "myCache",key = "0",condition = "#id != null")
    public User findUser(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 删除用户数据信息,删除用户前清除内存中指定key的缓存数据
     * @param id
     * @return
     */
    @CacheEvict(value="myCache",key="'users'",beforeInvocation = true)
	public int deleteUser(String id) {
	    return userDao.deleteByPrimaryKey(id);
	}

    /**
     * 用@CachePut处理，这中方法需要对指定缓存key保持一致，尽管这样，还是不行
     * 因为它返回的缓存是int(增加或删除或修改的记录数或是该记录的对象，这对我们查询所有或部分记录的缓存还是不可行的)
     * @param record
     * @return
     */
//	@CachePut(value="myCache",key="'users'")
    @CacheEvict(value="myCache",key="'users'",beforeInvocation = true)
	public int insert(User record) {
		return userDao.insertSelective(record);
	}

	public int insertTest(User record) {
		return userDao.insert(record);
	}

	public int updateUser(User record) {
		return userDao.updateByPrimaryKeySelective(record);
	}

    /**
     * 获取用户统计数量
     * @return
     */
	@Cacheable(value = "myCache",key = "0")
	public int count() {
		int num= userDao.count();
		return num;
	}
}
