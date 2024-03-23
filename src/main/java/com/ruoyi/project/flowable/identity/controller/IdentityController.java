package com.ruoyi.project.flowable.identity.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.flowable.identity.controller.param.GroupParam;
import com.ruoyi.project.flowable.identity.controller.param.UserParam;
import com.ruoyi.project.flowable.identity.service.FlowableIdentityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 身份信息
 *
 * @author yhq
 */
@Controller
@RequestMapping("/flowable/identity")
public class IdentityController extends BaseController {
    private final static String PREFIX = "flowable/identity";

    @Autowired
    private FlowableIdentityService flowableIdentityService;

    /**
     * 身份页
     *
     * @return 身份页
     */
    @RequiresPermissions("flowable:identity:view")
    @GetMapping()
    public String view() {
        return PREFIX + "/view";
    }

    /**
     * 用户查询
     *
     * @param userParam 请求参数
     * @return 用户列表
     */
    @RequiresPermissions("flowable:identity:list")
    @PostMapping("/listUser")
    @ResponseBody
    public TableDataInfo listUser(UserParam userParam) {
        return getDataTable(flowableIdentityService.listUser(userParam));
    }

    /**
     * 组查询
     *
     * @param groupParam 请求参数
     * @return 组列表
     */
    @RequiresPermissions("flowable:identity:list")
    @PostMapping("/listGroup")
    @ResponseBody
    public TableDataInfo listGroup(GroupParam groupParam) {
        return getDataTable(flowableIdentityService.listGroup(groupParam));
    }

    // /**
    //  * 新增部门
    //  */
    // @GetMapping("/add/{parentId}")
    // public String add(@PathVariable("parentId") Long parentId, ModelMap mmap) {
    //     if (!getSysUser().isAdmin()) {
    //         parentId = getSysUser().getDeptId();
    //     }
    //     mmap.put("dept", flowableIdentityService.selectDeptById(parentId));
    //     return PREFIX + "/add";
    // }

    // /**
    //  * 新增保存部门
    //  */
    // @Log(title = "部门管理", businessType = BusinessType.INSERT)
    // @RequiresPermissions("flowable:identity:add")
    // @PostMapping("/add")
    // @ResponseBody
    // public AjaxResult addSave(@Validated Dept dept) {
    //     if (!flowableIdentityService.checkDeptNameUnique(dept)) {
    //         return error("新增部门'" + dept.getDeptName() + "'失败，部门名称已存在");
    //     }
    //     return toAjax(flowableIdentityService.insertDept(dept));
    // }
    //
    // /**
    //  * 修改部门
    //  */
    // @RequiresPermissions("flowable:identity:edit")
    // @GetMapping("/edit/{deptId}")
    // public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap) {
    //     flowableIdentityService.checkDeptDataScope(deptId);
    //     Dept dept = flowableIdentityService.selectDeptById(deptId);
    //     if (StringUtils.isNotNull(dept) && 100L == deptId) {
    //         dept.setParentName("无");
    //     }
    //     mmap.put("dept", dept);
    //     return PREFIX + "/edit";
    // }
    //
    // /**
    //  * 修改保存部门
    //  */
    // @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    // @RequiresPermissions("flowable:identity:edit")
    // @PostMapping("/edit")
    // @ResponseBody
    // public AjaxResult editSave(@Validated Dept dept) {
    //     Long deptId = dept.getDeptId();
    //     flowableIdentityService.checkDeptDataScope(deptId);
    //     if (!flowableIdentityService.checkDeptNameUnique(dept)) {
    //         return error("修改部门'" + dept.getDeptName() + "'失败，部门名称已存在");
    //     } else if (dept.getParentId().equals(deptId)) {
    //         return error("修改部门'" + dept.getDeptName() + "'失败，上级部门不能是自己");
    //     } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus()) && flowableIdentityService.selectNormalChildrenDeptById(deptId) > 0) {
    //         return AjaxResult.error("该部门包含未停用的子部门！");
    //     }
    //     return toAjax(flowableIdentityService.updateDept(dept));
    // }
    //
    // /**
    //  * 删除
    //  */
    // @Log(title = "部门管理", businessType = BusinessType.DELETE)
    // @RequiresPermissions("flowable:identity:remove")
    // @GetMapping("/remove/{deptId}")
    // @ResponseBody
    // public AjaxResult remove(@PathVariable("deptId") Long deptId) {
    //     if (flowableIdentityService.selectDeptCount(deptId) > 0) {
    //         return AjaxResult.warn("存在下级部门,不允许删除");
    //     }
    //     if (flowableIdentityService.checkDeptExistUser(deptId)) {
    //         return AjaxResult.warn("部门存在用户,不允许删除");
    //     }
    //     flowableIdentityService.checkDeptDataScope(deptId);
    //     return toAjax(flowableIdentityService.deleteDeptById(deptId));
    // }
    //
    // /**
    //  * 校验部门名称
    //  */
    // @PostMapping("/checkDeptNameUnique")
    // @ResponseBody
    // public boolean checkDeptNameUnique(Dept dept) {
    //     return flowableIdentityService.checkDeptNameUnique(dept);
    // }
    //
    // /**
    //  * 选择部门树
    //  *
    //  * @param deptId    部门ID
    //  * @param excludeId 排除ID
    //  */
    // @GetMapping(value = {"/selectDeptTree/{deptId}", "/selectDeptTree/{deptId}/{excludeId}"})
    // public String selectDeptTree(@PathVariable("deptId") Long deptId,
    //                              @PathVariable(value = "excludeId", required = false) Long excludeId, ModelMap mmap) {
    //     mmap.put("dept", flowableIdentityService.selectDeptById(deptId));
    //     mmap.put("excludeId", excludeId);
    //     return PREFIX + "/tree";
    // }
    //
    // /**
    //  * 加载部门列表树（排除下级）
    //  */
    // @GetMapping("/treeData/{excludeId}")
    // @ResponseBody
    // public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId) {
    //     Dept dept = new Dept();
    //     dept.setExcludeId(excludeId);
    //     return flowableIdentityService.selectDeptTreeExcludeChild(dept);
    // }
}
