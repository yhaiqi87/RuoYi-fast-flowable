package com.ruoyi.project.flowable.identity.service.impl;

import com.ruoyi.framework.web.page.PageDomain;
import com.ruoyi.framework.web.page.TableSupport;
import com.ruoyi.project.flowable.identity.controller.param.GroupParam;
import com.ruoyi.project.flowable.identity.controller.param.UserParam;
import com.ruoyi.project.flowable.identity.service.FlowableIdentityService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.IdentityService;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 身份信息
 */
@Slf4j
@Service
public class FlowableIdentityServiceImpl implements FlowableIdentityService {
    @Autowired
    IdentityService identityService;

    /**
     * @param userParam 请求参数
     * @return 用户列表
     */
    @Override
    public List<UserEntityImpl> listUser(UserParam userParam) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        List<User> list = identityService.createUserQuery()
                .listPage(pageNum, pageSize);
        log.info("user list 大小：{}", list.size());
        return list.stream().map(o -> (UserEntityImpl) o).collect(Collectors.toList());
    }

    /**
     * @param groupParam 请求参数
     * @return 组列表
     */
    @Override
    public List<GroupEntityImpl> listGroup(GroupParam groupParam) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        List<Group> list = identityService.createGroupQuery()
                .listPage(pageNum, pageSize);
        log.info("group list 大小：{}", list.size());
        return list.stream().map(o -> (GroupEntityImpl) o).collect(Collectors.toList());
    }
}
