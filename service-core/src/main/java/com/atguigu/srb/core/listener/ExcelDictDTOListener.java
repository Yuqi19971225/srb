package com.atguigu.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.srb.core.mapper.DictMapper;
import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ：FYQ
 * @description：读取excel监听器
 * @date ：2022/7/26 21:25
 */
@NoArgsConstructor
@Slf4j
public class ExcelDictDTOListener extends AnalysisEventListener<ExcelDictDTO> {
    //每隔5条存数据库，生产环境改为3000
    private static final Integer BATCH_COUNT = 5;

    private List<ExcelDictDTO> list = new ArrayList<>();

    private DictMapper dictMapper;

    //传入mapper对象
    public ExcelDictDTOListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    /**
     * @param data:    传入Excel对象
     * @param context:
     * @return void
     * @description 遍历每一行的记录
     * @date
     */
    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext context) {
        log.info("解析到一条记录: {}", data);
        list.add(data);

        //达到BATCH_COUNT,清理一次列表，防止内存溢出
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    /**
     * @param context:
     * @return void
     * @description 所有解析完成后调用
     * @date
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //最后存储一次，保证所有数据被存储
        saveData();
        log.info("所有数据解析完成");
    }

    private void saveData() {
        log.info("{}条数据，开始存储数据库", list.size());
        dictMapper.insertBatch(list);
        log.info("存储数据库成功！");
    }
}
