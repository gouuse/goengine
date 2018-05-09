package com.gouuse.goenginesample.engine;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reiserx on 2018/5/9.
 * desc :
 */
public class Friend {

    /**
     * data : [{"icon":"","id":17,"link":"http://www.wanandroid.com/article/list/0?cid=176","name":"国内大牛博客集合","order":1,"visible":1},{"icon":"","id":16,"link":"https://github.com/android-cn/android-dev-com","name":"国外大牛博客集合","order":2,"visible":1},{"icon":"","id":25,"link":"http://jcenter.bintray.com/","name":"jcenter仓库","order":2,"visible":1},{"icon":"","id":26,"link":"https://dl.google.com/dl/android/maven2/index.html","name":"google仓库","order":2,"visible":1},{"icon":"","id":1,"link":"http://blog.csdn.net/lmj623565791","name":"鸿洋的博客","order":3,"visible":1},{"icon":"","id":2,"link":"http://blog.csdn.net/guolin_blog","name":"郭霖的博客","order":3,"visible":1},{"icon":"","id":4,"link":"https://github.com/trending/java","name":"今天最火的开源项目","order":3,"visible":1},{"icon":"","id":15,"link":"https://stackoverflow.com/","name":"stackoverflow","order":4,"visible":1},{"icon":"","id":3,"link":"http://www.wanandroid.com/blog/show/6","name":"鸿洋公众号文章聚合","order":5,"visible":1},{"icon":"","id":5,"link":"http://gank.io/","name":"干货集中营","order":5,"visible":1},{"icon":"","id":6,"link":"https://juejin.im/timeline/android","name":"掘金","order":6,"visible":1},{"icon":"","id":7,"link":"https://toutiao.io/","name":"开发者头条","order":7,"visible":1},{"icon":"","id":8,"link":"https://segmentfault.com/t/android","name":"segmentfault","order":8,"visible":1},{"icon":"","id":9,"link":"http://p.codekk.com/","name":"Android开源项目解析","order":9,"visible":1},{"icon":"","id":10,"link":"http://www.androiddevtools.cn/","name":"androiddevtools","order":10,"visible":1},{"icon":"","id":11,"link":"http://www.wanandroid.com/article/list/0?cid=185","name":"Android开发热门专题","order":11,"visible":1},{"icon":"","id":12,"link":"http://www.wanandroid.com/article/list/0?cid=73","name":"Android面试相关","order":12,"visible":1},{"icon":"","id":14,"link":"http://jikedaohang.com/","name":"极客导航","order":13,"visible":1},{"icon":"","id":21,"link":"https://developers.googleblog.cn/","name":"谷歌开发者中文博客","order":13,"visible":1},{"icon":"","id":13,"link":"https://learngitbranching.js.org/","name":"Git在线可视化学习","order":14,"visible":1},{"icon":"","id":22,"link":"https://www.androidos.net.cn/sourcecode","name":"在线查看Android源码","order":14,"visible":1},{"icon":"","id":19,"link":"http://md.aclickall.com/","name":"md在线编辑器","order":15,"visible":1},{"icon":"","id":20,"link":"https://unsplash.com/","name":"无版权素材网站","order":16,"visible":1},{"icon":"","id":23,"link":"https://www.fotor.com.cn","name":"素材设计","order":17,"visible":1},{"icon":"","id":24,"link":"https://www.chuangkit.com/designtools/startdesign","name":"素材设计-创客","order":18,"visible":1},{"icon":"","id":18,"link":"http://tongji.baidu.com/data/browser","name":"互联网相关统计","order":997,"visible":1},{"icon":"","id":27,"link":"https://domchristie.github.io/turndown/","name":"html2markdown","order":998,"visible":1},{"icon":"","id":28,"link":"https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=a9wfngm5","name":"阿里云优惠券","order":999,"visible":1}]
     * errorCode : 0
     * errorMsg :
     */

    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;
    @SerializedName("data")
    private List<DataBean> data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * icon :
         * id : 17
         * link : http://www.wanandroid.com/article/list/0?cid=176
         * name : 国内大牛博客集合
         * order : 1
         * visible : 1
         */

        @SerializedName("icon")
        private String icon;
        @SerializedName("id")
        private int id;
        @SerializedName("link")
        private String link;
        @SerializedName("name")
        private String name;
        @SerializedName("order")
        private int order;
        @SerializedName("visible")
        private int visible;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }
    }
}
