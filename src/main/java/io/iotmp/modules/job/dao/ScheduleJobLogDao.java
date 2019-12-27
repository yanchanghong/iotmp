

package io.iotmp.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author Yanchanghong
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
