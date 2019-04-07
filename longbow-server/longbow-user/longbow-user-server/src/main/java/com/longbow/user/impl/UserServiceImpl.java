package com.longbow.user.impl;

import com.baidu.fsg.uid.UidGenerator;
import com.longbow.api.user.UserAPI;
import com.longbow.api.user.admin.dto.SysRoleInfo;
import com.longbow.api.user.dto.*;
import com.longbow.api.user.service.IUserService;
import com.longbow.core.IServiceLayer;
import com.longbow.core.jwt.JWTSubject;
import com.longbow.core.jwt.JWTUtils;
import com.longbow.core.util.RegexUtils;
import com.longbow.user.dal.po.SysRole;
import com.longbow.user.dal.po.SysSession;
import com.longbow.user.dal.po.SysUser;
import com.longbow.user.repository.RoleRepository;
import com.longbow.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangbin on 2018/8/14.
 */
@Slf4j
@Service(UserAPI.BEAN_USER_SERVICE)
public class UserServiceImpl implements IUserService, IServiceLayer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Resource
    private UidGenerator uidGenerator;
    @Autowired
    private HttpServletRequest request;

    @Override
    public void certify(@RequestBody CertifyUserRequest user) {

    }

    @Override
    public void register(@RequestBody RegisterUserRequest user) {
//        if (result.hasErrors()){
//            List<ObjectError> errorList = result.getAllErrors();
//            for(ObjectError error : errorList){
//                log.error(error.getDefaultMessage());
//            }
//            return;
//        }
        SysUser po = new SysUser();
        po.setUid(uidGenerator.getUID());
        po.setUsername(user.getUsername());
        po.setPassword(user.getPassword());
        po.setEmail(user.getEmail());
        po.setMobile(user.getMobile());
        userRepository.saveUserOne(po);
    }

    @Override
    public String login(@RequestBody LoginUserRequest user) {
        SysUser condition = new SysUser();
        if (RegexUtils.isMobile(user.getAccountNumber())) {
            condition.setMobile(user.getAccountNumber());
        } else if (RegexUtils.isEmail(user.getAccountNumber())) {
            condition.setEmail(user.getAccountNumber());
        } else if (RegexUtils.isUsername(user.getAccountNumber())) {
            condition.setUsername(user.getAccountNumber());
        }
        condition.setPassword(user.getPassword());
        SysUser find = userRepository.selectOneByCondition(condition);
        if (null != find) {
            JWTSubject jwtSubject = new JWTSubject();
            jwtSubject.setUserId(find.getUid());
            jwtSubject.setRoleSet(null);
            String jwtToken = JWTUtils.generateToken(jwtSubject);

            SysSession session = new SysSession();
            session.setUserId(find.getUid());
            session.setJwt(jwtToken);
            session.setSessionid(request.getSession().getId());
            session.setCreateTime(new Date());
            session.setExpireTime(JWTUtils.generateExpirationDate());
            userRepository.saveSession(session);

            return jwtToken;
        }
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public String refresh() {
        return null;
    }

    @Override
    public void resetPassword() {

    }

    @Override
    public void edit(@RequestBody EditUserRequest user) {

    }

    @Override
    public ConflictUserResponse conflictUser(@RequestBody ConflictUserRequest user) {
        ConflictUserResponse response = new ConflictUserResponse();
        if (!StringUtils.isEmpty(user.getUsername())) {
            SysUser condition = new SysUser();
            condition.setUsername(user.getUsername());
            SysUser find = userRepository.selectOneByCondition(condition);
            if (null != find) {
                response.setUsernameConflict(true);
            } else {
                response.setUsernameConflict(false);
            }
        }
        if (!StringUtils.isEmpty(user.getMobile())) {
            SysUser condition = new SysUser();
            condition.setMobile(user.getMobile());
            SysUser find = userRepository.selectOneByCondition(condition);
            if (null != find) {
                response.setMobileConflict(true);
            } else {
                response.setMobileConflict(false);
            }
        }
        if (!StringUtils.isEmpty(user.getEmail())) {
            SysUser condition = new SysUser();
            condition.setEmail(user.getEmail());
            SysUser find = userRepository.selectOneByCondition(condition);
            if (null != find) {
                response.setEmailConflict(true);
            } else {
                response.setEmailConflict(false);
            }
        }
        return response;
    }

    @Override
    public GetUserInfoResponse getUserInfo() {
        GetUserInfoResponse userInfo = new GetUserInfoResponse();
        SysUser user = null;
        List<SysRole> roleList = roleRepository.selectByUserId(user.getUid());
        Set<String> roleInfos = new HashSet<>();
        roleList.stream().forEach((item) -> {
            SysRoleInfo sysRoleInfo = new SysRoleInfo();
            item.buildInfo(sysRoleInfo);
            roleInfos.add(sysRoleInfo.getRolName());
        });
        userInfo.setRoles(roleInfos);
        return userInfo;
    }

    @Override
    public void changePassword(@RequestParam("userId") String userId, @RequestParam("newPassword") String newPassword) {
        log.info("输入参数: userId = {}, newPassword = {}", userId, newPassword);
        long uid = uidGenerator.getUID();
        log.info("get id from uidGenerator {}", uid);
        String parsedInfo = uidGenerator.parseUID(uid);
        log.info(parsedInfo);
    }

}
