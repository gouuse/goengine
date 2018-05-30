package com.gouuse.goenginesample.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by reiserx on 2018/5/24.
 * desc :
 */
public class Meizi {


    /**
     * error : false
     * results : [{"_id":"5b02e1cd421aa96031463fe4","createdAt":"2018-05-21T23:12:13.646Z","desc":"2018.5.25","publishedAt":"2018-05-24T11:03:54.588Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frjd77dt8zj30k80q2aga.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b02e163421aa9602d6abd36","createdAt":"2018-05-21T23:10:27.865Z","desc":"2018.5.23","publishedAt":"2018-05-23T00:22:29.342Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frjd4var2bj30k80q0dlf.jpg","used":true,"who":"lijinshanmx"}]
     */

    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5b02e1cd421aa96031463fe4
         * createdAt : 2018-05-21T23:12:13.646Z
         * desc : 2018.5.25
         * publishedAt : 2018-05-24T11:03:54.588Z
         * source : web
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/0065oQSqly1frjd77dt8zj30k80q2aga.jpg
         * used : true
         * who : lijinshanmx
         */

        @SerializedName("_id")
        private String id;
        @SerializedName("createdAt")
        private String createdAt;
        @SerializedName("desc")
        private String desc;
        @SerializedName("publishedAt")
        private String publishedAt;
        @SerializedName("source")
        private String source;
        @SerializedName("type")
        private String type;
        @SerializedName("url")
        private String url;
        @SerializedName("used")
        private boolean used;
        @SerializedName("who")
        private String who;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
