package com.ruoyi.project.flowable.identity.service;

import com.ruoyi.project.flowable.identity.controller.param.GroupParam;
import com.ruoyi.project.flowable.identity.controller.param.UserParam;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;

import java.util.List;

public interface FlowableIdentityService {

    List<UserEntityImpl> listUser(UserParam userParam);

    List<GroupEntityImpl> listGroup(GroupParam groupParam);
}
