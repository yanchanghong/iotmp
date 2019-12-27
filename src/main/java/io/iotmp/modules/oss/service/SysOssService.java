

package io.iotmp.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Yanchanghong
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
