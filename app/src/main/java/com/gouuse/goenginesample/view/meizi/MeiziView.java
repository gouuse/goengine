package com.gouuse.goenginesample.view.meizi;

import com.gouuse.goenginesample.entity.Meizi;
import com.gouuse.goenginesample.mvp.IView;

import java.util.List;

/**
 * Created by reiserx on 2018/4/2.
 * desc : 妹子图 view
 */
public interface MeiziView extends IView {
    /**
     * 获取妹子成功
     *
     * @param datas  数据
     * @param addNew 是否为添加新数据
     */
    void requestMeiziSuccess(List<Meizi.ResultsBean> datas, boolean addNew);

    /**
     * 获取妹子失败
     *
     * @param code 失败code
     * @param str  失败信息
     */
    void requestMeiziFail(long code, String str);

    void finishLoadMore();

}
