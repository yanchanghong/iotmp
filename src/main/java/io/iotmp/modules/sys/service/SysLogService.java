

package io.iotmp.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Yanchanghong
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 删除日志
     */
    void deleteBatch(Long[] logIds);
}
