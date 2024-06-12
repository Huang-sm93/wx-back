package com.wx.appbackend.service.myaccount;

import com.wx.appbackend.service.myaccount.dao.AccountDao;
import com.wx.appbackend.service.myaccount.entity.AccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.AccountResDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountDao accountDao;

    @Override
    public void update(AccountReqDTO reqDTO) {

    }

    @Override
    public int insert(AccountReqDTO reqDTO) {
        return 0;
    }

    @Override
    public AccountResDTO selectById(long id) throws Exception {
        return accountDao.selectById(id);
    }

    @Override
    public void delete(long id) throws Exception {

    }

    @Override
    public List<AccountResDTO> getPage() throws Exception {
        return null;
    }
}
