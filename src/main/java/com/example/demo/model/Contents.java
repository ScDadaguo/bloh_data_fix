package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author dadaguo
*/
@Component
public class Contents implements Serializable {

    private static final long serialVersionUID = 1596792133240L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer cid;

    /**
    * 
    * isNullAble:1
    */
    private String title;

    /**
    * 
    * isNullAble:1
    */
    private String slug;

    /**
    * 
    * isNullAble:1,defaultVal:0
    */
    private Integer created;

    /**
    * 
    * isNullAble:1,defaultVal:0
    */
    private Integer modified;

    /**
    * 内容文字
    * isNullAble:1
    */
    private String content;

    /**
    * 
    * isNullAble:1,defaultVal:0
    */
    private Integer authorId;

    /**
    * 
    * isNullAble:1,defaultVal:post
    */
    private String type;

    /**
    * 
    * isNullAble:1,defaultVal:publish
    */
    private String status;

    /**
    * 
    * isNullAble:1
    */
    private String tags;

    /**
    * 
    * isNullAble:1
    */
    private String categories;

    /**
    * 
    * isNullAble:1,defaultVal:0
    */
    private Integer hits;

    /**
    * 
    * isNullAble:1,defaultVal:0
    */
    private Integer commentsNum;

    /**
    * 
    * isNullAble:1,defaultVal:1
    */
    private Integer allowComment;

    /**
    * 
    * isNullAble:1,defaultVal:1
    */
    private Integer allowPing;

    /**
    * 
    * isNullAble:1,defaultVal:1
    */
    private Integer allowFeed;


    public void setCid(Integer cid){this.cid = cid;}

    public Integer getCid(){return this.cid;}

    public void setTitle(String title){this.title = title;}

    public String getTitle(){return this.title;}

    public void setSlug(String slug){this.slug = slug;}

    public String getSlug(){return this.slug;}

    public void setCreated(Integer created){this.created = created;}

    public Integer getCreated(){return this.created;}

    public void setModified(Integer modified){this.modified = modified;}

    public Integer getModified(){return this.modified;}

    public void setContent(String content){this.content = content;}

    public String getContent(){return this.content;}

    public void setAuthorId(Integer authorId){this.authorId = authorId;}

    public Integer getAuthorId(){return this.authorId;}

    public void setType(String type){this.type = type;}

    public String getType(){return this.type;}

    public void setStatus(String status){this.status = status;}

    public String getStatus(){return this.status;}

    public void setTags(String tags){this.tags = tags;}

    public String getTags(){return this.tags;}

    public void setCategories(String categories){this.categories = categories;}

    public String getCategories(){return this.categories;}

    public void setHits(Integer hits){this.hits = hits;}

    public Integer getHits(){return this.hits;}

    public void setCommentsNum(Integer commentsNum){this.commentsNum = commentsNum;}

    public Integer getCommentsNum(){return this.commentsNum;}

    public void setAllowComment(Integer allowComment){this.allowComment = allowComment;}

    public Integer getAllowComment(){return this.allowComment;}

    public void setAllowPing(Integer allowPing){this.allowPing = allowPing;}

    public Integer getAllowPing(){return this.allowPing;}

    public void setAllowFeed(Integer allowFeed){this.allowFeed = allowFeed;}

    public Integer getAllowFeed(){return this.allowFeed;}
    @Override
    public String toString() {
        return "Contents{" +
                "cid='" + cid + '\'' +
                "title='" + title + '\'' +
                "slug='" + slug + '\'' +
                "created='" + created + '\'' +
                "modified='" + modified + '\'' +
                "content='" + content + '\'' +
                "authorId='" + authorId + '\'' +
                "type='" + type + '\'' +
                "status='" + status + '\'' +
                "tags='" + tags + '\'' +
                "categories='" + categories + '\'' +
                "hits='" + hits + '\'' +
                "commentsNum='" + commentsNum + '\'' +
                "allowComment='" + allowComment + '\'' +
                "allowPing='" + allowPing + '\'' +
                "allowFeed='" + allowFeed + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Contents set;

        private ConditionBuilder where;

        public UpdateBuilder set(Contents set){
            this.set = set;
            return this;
        }

        public Contents getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends Contents{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> cidList;

        public List<Integer> getCidList(){return this.cidList;}

        private Integer cidSt;

        private Integer cidEd;

        public Integer getCidSt(){return this.cidSt;}

        public Integer getCidEd(){return this.cidEd;}

        private List<String> titleList;

        public List<String> getTitleList(){return this.titleList;}


        private List<String> fuzzyTitle;

        public List<String> getFuzzyTitle(){return this.fuzzyTitle;}

        private List<String> rightFuzzyTitle;

        public List<String> getRightFuzzyTitle(){return this.rightFuzzyTitle;}
        private List<String> slugList;

        public List<String> getSlugList(){return this.slugList;}


        private List<String> fuzzySlug;

        public List<String> getFuzzySlug(){return this.fuzzySlug;}

        private List<String> rightFuzzySlug;

        public List<String> getRightFuzzySlug(){return this.rightFuzzySlug;}
        private List<Integer> createdList;

        public List<Integer> getCreatedList(){return this.createdList;}

        private Integer createdSt;

        private Integer createdEd;

        public Integer getCreatedSt(){return this.createdSt;}

        public Integer getCreatedEd(){return this.createdEd;}

        private List<Integer> modifiedList;

        public List<Integer> getModifiedList(){return this.modifiedList;}

        private Integer modifiedSt;

        private Integer modifiedEd;

        public Integer getModifiedSt(){return this.modifiedSt;}

        public Integer getModifiedEd(){return this.modifiedEd;}

        private List<String> contentList;

        public List<String> getContentList(){return this.contentList;}


        private List<String> fuzzyContent;

        public List<String> getFuzzyContent(){return this.fuzzyContent;}

        private List<String> rightFuzzyContent;

        public List<String> getRightFuzzyContent(){return this.rightFuzzyContent;}
        private List<Integer> authorIdList;

        public List<Integer> getAuthorIdList(){return this.authorIdList;}

        private Integer authorIdSt;

        private Integer authorIdEd;

        public Integer getAuthorIdSt(){return this.authorIdSt;}

        public Integer getAuthorIdEd(){return this.authorIdEd;}

        private List<String> typeList;

        public List<String> getTypeList(){return this.typeList;}


        private List<String> fuzzyType;

        public List<String> getFuzzyType(){return this.fuzzyType;}

        private List<String> rightFuzzyType;

        public List<String> getRightFuzzyType(){return this.rightFuzzyType;}
        private List<String> statusList;

        public List<String> getStatusList(){return this.statusList;}


        private List<String> fuzzyStatus;

        public List<String> getFuzzyStatus(){return this.fuzzyStatus;}

        private List<String> rightFuzzyStatus;

        public List<String> getRightFuzzyStatus(){return this.rightFuzzyStatus;}
        private List<String> tagsList;

        public List<String> getTagsList(){return this.tagsList;}


        private List<String> fuzzyTags;

        public List<String> getFuzzyTags(){return this.fuzzyTags;}

        private List<String> rightFuzzyTags;

        public List<String> getRightFuzzyTags(){return this.rightFuzzyTags;}
        private List<String> categoriesList;

        public List<String> getCategoriesList(){return this.categoriesList;}


        private List<String> fuzzyCategories;

        public List<String> getFuzzyCategories(){return this.fuzzyCategories;}

        private List<String> rightFuzzyCategories;

        public List<String> getRightFuzzyCategories(){return this.rightFuzzyCategories;}
        private List<Integer> hitsList;

        public List<Integer> getHitsList(){return this.hitsList;}

        private Integer hitsSt;

        private Integer hitsEd;

        public Integer getHitsSt(){return this.hitsSt;}

        public Integer getHitsEd(){return this.hitsEd;}

        private List<Integer> commentsNumList;

        public List<Integer> getCommentsNumList(){return this.commentsNumList;}

        private Integer commentsNumSt;

        private Integer commentsNumEd;

        public Integer getCommentsNumSt(){return this.commentsNumSt;}

        public Integer getCommentsNumEd(){return this.commentsNumEd;}

        private List<Integer> allowCommentList;

        public List<Integer> getAllowCommentList(){return this.allowCommentList;}

        private Integer allowCommentSt;

        private Integer allowCommentEd;

        public Integer getAllowCommentSt(){return this.allowCommentSt;}

        public Integer getAllowCommentEd(){return this.allowCommentEd;}

        private List<Integer> allowPingList;

        public List<Integer> getAllowPingList(){return this.allowPingList;}

        private Integer allowPingSt;

        private Integer allowPingEd;

        public Integer getAllowPingSt(){return this.allowPingSt;}

        public Integer getAllowPingEd(){return this.allowPingEd;}

        private List<Integer> allowFeedList;

        public List<Integer> getAllowFeedList(){return this.allowFeedList;}

        private Integer allowFeedSt;

        private Integer allowFeedEd;

        public Integer getAllowFeedSt(){return this.allowFeedSt;}

        public Integer getAllowFeedEd(){return this.allowFeedEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder cidBetWeen(Integer cidSt,Integer cidEd){
            this.cidSt = cidSt;
            this.cidEd = cidEd;
            return this;
        }

        public QueryBuilder cidGreaterEqThan(Integer cidSt){
            this.cidSt = cidSt;
            return this;
        }
        public QueryBuilder cidLessEqThan(Integer cidEd){
            this.cidEd = cidEd;
            return this;
        }


        public QueryBuilder cid(Integer cid){
            setCid(cid);
            return this;
        }

        public QueryBuilder cidList(Integer ... cid){
            this.cidList = solveNullList(cid);
            return this;
        }

        public QueryBuilder cidList(List<Integer> cid){
            this.cidList = cid;
            return this;
        }

        public QueryBuilder fetchCid(){
            setFetchFields("fetchFields","cid");
            return this;
        }

        public QueryBuilder excludeCid(){
            setFetchFields("excludeFields","cid");
            return this;
        }

        public QueryBuilder fuzzyTitle (List<String> fuzzyTitle){
            this.fuzzyTitle = fuzzyTitle;
            return this;
        }

        public QueryBuilder fuzzyTitle (String ... fuzzyTitle){
            this.fuzzyTitle = solveNullList(fuzzyTitle);
            return this;
        }

        public QueryBuilder rightFuzzyTitle (List<String> rightFuzzyTitle){
            this.rightFuzzyTitle = rightFuzzyTitle;
            return this;
        }

        public QueryBuilder rightFuzzyTitle (String ... rightFuzzyTitle){
            this.rightFuzzyTitle = solveNullList(rightFuzzyTitle);
            return this;
        }

        public QueryBuilder title(String title){
            setTitle(title);
            return this;
        }

        public QueryBuilder titleList(String ... title){
            this.titleList = solveNullList(title);
            return this;
        }

        public QueryBuilder titleList(List<String> title){
            this.titleList = title;
            return this;
        }

        public QueryBuilder fetchTitle(){
            setFetchFields("fetchFields","title");
            return this;
        }

        public QueryBuilder excludeTitle(){
            setFetchFields("excludeFields","title");
            return this;
        }

        public QueryBuilder fuzzySlug (List<String> fuzzySlug){
            this.fuzzySlug = fuzzySlug;
            return this;
        }

        public QueryBuilder fuzzySlug (String ... fuzzySlug){
            this.fuzzySlug = solveNullList(fuzzySlug);
            return this;
        }

        public QueryBuilder rightFuzzySlug (List<String> rightFuzzySlug){
            this.rightFuzzySlug = rightFuzzySlug;
            return this;
        }

        public QueryBuilder rightFuzzySlug (String ... rightFuzzySlug){
            this.rightFuzzySlug = solveNullList(rightFuzzySlug);
            return this;
        }

        public QueryBuilder slug(String slug){
            setSlug(slug);
            return this;
        }

        public QueryBuilder slugList(String ... slug){
            this.slugList = solveNullList(slug);
            return this;
        }

        public QueryBuilder slugList(List<String> slug){
            this.slugList = slug;
            return this;
        }

        public QueryBuilder fetchSlug(){
            setFetchFields("fetchFields","slug");
            return this;
        }

        public QueryBuilder excludeSlug(){
            setFetchFields("excludeFields","slug");
            return this;
        }

        public QueryBuilder createdBetWeen(Integer createdSt,Integer createdEd){
            this.createdSt = createdSt;
            this.createdEd = createdEd;
            return this;
        }

        public QueryBuilder createdGreaterEqThan(Integer createdSt){
            this.createdSt = createdSt;
            return this;
        }
        public QueryBuilder createdLessEqThan(Integer createdEd){
            this.createdEd = createdEd;
            return this;
        }


        public QueryBuilder created(Integer created){
            setCreated(created);
            return this;
        }

        public QueryBuilder createdList(Integer ... created){
            this.createdList = solveNullList(created);
            return this;
        }

        public QueryBuilder createdList(List<Integer> created){
            this.createdList = created;
            return this;
        }

        public QueryBuilder fetchCreated(){
            setFetchFields("fetchFields","created");
            return this;
        }

        public QueryBuilder excludeCreated(){
            setFetchFields("excludeFields","created");
            return this;
        }

        public QueryBuilder modifiedBetWeen(Integer modifiedSt,Integer modifiedEd){
            this.modifiedSt = modifiedSt;
            this.modifiedEd = modifiedEd;
            return this;
        }

        public QueryBuilder modifiedGreaterEqThan(Integer modifiedSt){
            this.modifiedSt = modifiedSt;
            return this;
        }
        public QueryBuilder modifiedLessEqThan(Integer modifiedEd){
            this.modifiedEd = modifiedEd;
            return this;
        }


        public QueryBuilder modified(Integer modified){
            setModified(modified);
            return this;
        }

        public QueryBuilder modifiedList(Integer ... modified){
            this.modifiedList = solveNullList(modified);
            return this;
        }

        public QueryBuilder modifiedList(List<Integer> modified){
            this.modifiedList = modified;
            return this;
        }

        public QueryBuilder fetchModified(){
            setFetchFields("fetchFields","modified");
            return this;
        }

        public QueryBuilder excludeModified(){
            setFetchFields("excludeFields","modified");
            return this;
        }

        public QueryBuilder fuzzyContent (List<String> fuzzyContent){
            this.fuzzyContent = fuzzyContent;
            return this;
        }

        public QueryBuilder fuzzyContent (String ... fuzzyContent){
            this.fuzzyContent = solveNullList(fuzzyContent);
            return this;
        }

        public QueryBuilder rightFuzzyContent (List<String> rightFuzzyContent){
            this.rightFuzzyContent = rightFuzzyContent;
            return this;
        }

        public QueryBuilder rightFuzzyContent (String ... rightFuzzyContent){
            this.rightFuzzyContent = solveNullList(rightFuzzyContent);
            return this;
        }

        public QueryBuilder content(String content){
            setContent(content);
            return this;
        }

        public QueryBuilder contentList(String ... content){
            this.contentList = solveNullList(content);
            return this;
        }

        public QueryBuilder contentList(List<String> content){
            this.contentList = content;
            return this;
        }

        public QueryBuilder fetchContent(){
            setFetchFields("fetchFields","content");
            return this;
        }

        public QueryBuilder excludeContent(){
            setFetchFields("excludeFields","content");
            return this;
        }

        public QueryBuilder authorIdBetWeen(Integer authorIdSt,Integer authorIdEd){
            this.authorIdSt = authorIdSt;
            this.authorIdEd = authorIdEd;
            return this;
        }

        public QueryBuilder authorIdGreaterEqThan(Integer authorIdSt){
            this.authorIdSt = authorIdSt;
            return this;
        }
        public QueryBuilder authorIdLessEqThan(Integer authorIdEd){
            this.authorIdEd = authorIdEd;
            return this;
        }


        public QueryBuilder authorId(Integer authorId){
            setAuthorId(authorId);
            return this;
        }

        public QueryBuilder authorIdList(Integer ... authorId){
            this.authorIdList = solveNullList(authorId);
            return this;
        }

        public QueryBuilder authorIdList(List<Integer> authorId){
            this.authorIdList = authorId;
            return this;
        }

        public QueryBuilder fetchAuthorId(){
            setFetchFields("fetchFields","authorId");
            return this;
        }

        public QueryBuilder excludeAuthorId(){
            setFetchFields("excludeFields","authorId");
            return this;
        }

        public QueryBuilder fuzzyType (List<String> fuzzyType){
            this.fuzzyType = fuzzyType;
            return this;
        }

        public QueryBuilder fuzzyType (String ... fuzzyType){
            this.fuzzyType = solveNullList(fuzzyType);
            return this;
        }

        public QueryBuilder rightFuzzyType (List<String> rightFuzzyType){
            this.rightFuzzyType = rightFuzzyType;
            return this;
        }

        public QueryBuilder rightFuzzyType (String ... rightFuzzyType){
            this.rightFuzzyType = solveNullList(rightFuzzyType);
            return this;
        }

        public QueryBuilder type(String type){
            setType(type);
            return this;
        }

        public QueryBuilder typeList(String ... type){
            this.typeList = solveNullList(type);
            return this;
        }

        public QueryBuilder typeList(List<String> type){
            this.typeList = type;
            return this;
        }

        public QueryBuilder fetchType(){
            setFetchFields("fetchFields","type");
            return this;
        }

        public QueryBuilder excludeType(){
            setFetchFields("excludeFields","type");
            return this;
        }

        public QueryBuilder fuzzyStatus (List<String> fuzzyStatus){
            this.fuzzyStatus = fuzzyStatus;
            return this;
        }

        public QueryBuilder fuzzyStatus (String ... fuzzyStatus){
            this.fuzzyStatus = solveNullList(fuzzyStatus);
            return this;
        }

        public QueryBuilder rightFuzzyStatus (List<String> rightFuzzyStatus){
            this.rightFuzzyStatus = rightFuzzyStatus;
            return this;
        }

        public QueryBuilder rightFuzzyStatus (String ... rightFuzzyStatus){
            this.rightFuzzyStatus = solveNullList(rightFuzzyStatus);
            return this;
        }

        public QueryBuilder status(String status){
            setStatus(status);
            return this;
        }

        public QueryBuilder statusList(String ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public QueryBuilder statusList(List<String> status){
            this.statusList = status;
            return this;
        }

        public QueryBuilder fetchStatus(){
            setFetchFields("fetchFields","status");
            return this;
        }

        public QueryBuilder excludeStatus(){
            setFetchFields("excludeFields","status");
            return this;
        }

        public QueryBuilder fuzzyTags (List<String> fuzzyTags){
            this.fuzzyTags = fuzzyTags;
            return this;
        }

        public QueryBuilder fuzzyTags (String ... fuzzyTags){
            this.fuzzyTags = solveNullList(fuzzyTags);
            return this;
        }

        public QueryBuilder rightFuzzyTags (List<String> rightFuzzyTags){
            this.rightFuzzyTags = rightFuzzyTags;
            return this;
        }

        public QueryBuilder rightFuzzyTags (String ... rightFuzzyTags){
            this.rightFuzzyTags = solveNullList(rightFuzzyTags);
            return this;
        }

        public QueryBuilder tags(String tags){
            setTags(tags);
            return this;
        }

        public QueryBuilder tagsList(String ... tags){
            this.tagsList = solveNullList(tags);
            return this;
        }

        public QueryBuilder tagsList(List<String> tags){
            this.tagsList = tags;
            return this;
        }

        public QueryBuilder fetchTags(){
            setFetchFields("fetchFields","tags");
            return this;
        }

        public QueryBuilder excludeTags(){
            setFetchFields("excludeFields","tags");
            return this;
        }

        public QueryBuilder fuzzyCategories (List<String> fuzzyCategories){
            this.fuzzyCategories = fuzzyCategories;
            return this;
        }

        public QueryBuilder fuzzyCategories (String ... fuzzyCategories){
            this.fuzzyCategories = solveNullList(fuzzyCategories);
            return this;
        }

        public QueryBuilder rightFuzzyCategories (List<String> rightFuzzyCategories){
            this.rightFuzzyCategories = rightFuzzyCategories;
            return this;
        }

        public QueryBuilder rightFuzzyCategories (String ... rightFuzzyCategories){
            this.rightFuzzyCategories = solveNullList(rightFuzzyCategories);
            return this;
        }

        public QueryBuilder categories(String categories){
            setCategories(categories);
            return this;
        }

        public QueryBuilder categoriesList(String ... categories){
            this.categoriesList = solveNullList(categories);
            return this;
        }

        public QueryBuilder categoriesList(List<String> categories){
            this.categoriesList = categories;
            return this;
        }

        public QueryBuilder fetchCategories(){
            setFetchFields("fetchFields","categories");
            return this;
        }

        public QueryBuilder excludeCategories(){
            setFetchFields("excludeFields","categories");
            return this;
        }

        public QueryBuilder hitsBetWeen(Integer hitsSt,Integer hitsEd){
            this.hitsSt = hitsSt;
            this.hitsEd = hitsEd;
            return this;
        }

        public QueryBuilder hitsGreaterEqThan(Integer hitsSt){
            this.hitsSt = hitsSt;
            return this;
        }
        public QueryBuilder hitsLessEqThan(Integer hitsEd){
            this.hitsEd = hitsEd;
            return this;
        }


        public QueryBuilder hits(Integer hits){
            setHits(hits);
            return this;
        }

        public QueryBuilder hitsList(Integer ... hits){
            this.hitsList = solveNullList(hits);
            return this;
        }

        public QueryBuilder hitsList(List<Integer> hits){
            this.hitsList = hits;
            return this;
        }

        public QueryBuilder fetchHits(){
            setFetchFields("fetchFields","hits");
            return this;
        }

        public QueryBuilder excludeHits(){
            setFetchFields("excludeFields","hits");
            return this;
        }

        public QueryBuilder commentsNumBetWeen(Integer commentsNumSt,Integer commentsNumEd){
            this.commentsNumSt = commentsNumSt;
            this.commentsNumEd = commentsNumEd;
            return this;
        }

        public QueryBuilder commentsNumGreaterEqThan(Integer commentsNumSt){
            this.commentsNumSt = commentsNumSt;
            return this;
        }
        public QueryBuilder commentsNumLessEqThan(Integer commentsNumEd){
            this.commentsNumEd = commentsNumEd;
            return this;
        }


        public QueryBuilder commentsNum(Integer commentsNum){
            setCommentsNum(commentsNum);
            return this;
        }

        public QueryBuilder commentsNumList(Integer ... commentsNum){
            this.commentsNumList = solveNullList(commentsNum);
            return this;
        }

        public QueryBuilder commentsNumList(List<Integer> commentsNum){
            this.commentsNumList = commentsNum;
            return this;
        }

        public QueryBuilder fetchCommentsNum(){
            setFetchFields("fetchFields","commentsNum");
            return this;
        }

        public QueryBuilder excludeCommentsNum(){
            setFetchFields("excludeFields","commentsNum");
            return this;
        }

        public QueryBuilder allowCommentBetWeen(Integer allowCommentSt,Integer allowCommentEd){
            this.allowCommentSt = allowCommentSt;
            this.allowCommentEd = allowCommentEd;
            return this;
        }

        public QueryBuilder allowCommentGreaterEqThan(Integer allowCommentSt){
            this.allowCommentSt = allowCommentSt;
            return this;
        }
        public QueryBuilder allowCommentLessEqThan(Integer allowCommentEd){
            this.allowCommentEd = allowCommentEd;
            return this;
        }


        public QueryBuilder allowComment(Integer allowComment){
            setAllowComment(allowComment);
            return this;
        }

        public QueryBuilder allowCommentList(Integer ... allowComment){
            this.allowCommentList = solveNullList(allowComment);
            return this;
        }

        public QueryBuilder allowCommentList(List<Integer> allowComment){
            this.allowCommentList = allowComment;
            return this;
        }

        public QueryBuilder fetchAllowComment(){
            setFetchFields("fetchFields","allowComment");
            return this;
        }

        public QueryBuilder excludeAllowComment(){
            setFetchFields("excludeFields","allowComment");
            return this;
        }

        public QueryBuilder allowPingBetWeen(Integer allowPingSt,Integer allowPingEd){
            this.allowPingSt = allowPingSt;
            this.allowPingEd = allowPingEd;
            return this;
        }

        public QueryBuilder allowPingGreaterEqThan(Integer allowPingSt){
            this.allowPingSt = allowPingSt;
            return this;
        }
        public QueryBuilder allowPingLessEqThan(Integer allowPingEd){
            this.allowPingEd = allowPingEd;
            return this;
        }


        public QueryBuilder allowPing(Integer allowPing){
            setAllowPing(allowPing);
            return this;
        }

        public QueryBuilder allowPingList(Integer ... allowPing){
            this.allowPingList = solveNullList(allowPing);
            return this;
        }

        public QueryBuilder allowPingList(List<Integer> allowPing){
            this.allowPingList = allowPing;
            return this;
        }

        public QueryBuilder fetchAllowPing(){
            setFetchFields("fetchFields","allowPing");
            return this;
        }

        public QueryBuilder excludeAllowPing(){
            setFetchFields("excludeFields","allowPing");
            return this;
        }

        public QueryBuilder allowFeedBetWeen(Integer allowFeedSt,Integer allowFeedEd){
            this.allowFeedSt = allowFeedSt;
            this.allowFeedEd = allowFeedEd;
            return this;
        }

        public QueryBuilder allowFeedGreaterEqThan(Integer allowFeedSt){
            this.allowFeedSt = allowFeedSt;
            return this;
        }
        public QueryBuilder allowFeedLessEqThan(Integer allowFeedEd){
            this.allowFeedEd = allowFeedEd;
            return this;
        }


        public QueryBuilder allowFeed(Integer allowFeed){
            setAllowFeed(allowFeed);
            return this;
        }

        public QueryBuilder allowFeedList(Integer ... allowFeed){
            this.allowFeedList = solveNullList(allowFeed);
            return this;
        }

        public QueryBuilder allowFeedList(List<Integer> allowFeed){
            this.allowFeedList = allowFeed;
            return this;
        }

        public QueryBuilder fetchAllowFeed(){
            setFetchFields("fetchFields","allowFeed");
            return this;
        }

        public QueryBuilder excludeAllowFeed(){
            setFetchFields("excludeFields","allowFeed");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public Contents build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> cidList;

        public List<Integer> getCidList(){return this.cidList;}

        private Integer cidSt;

        private Integer cidEd;

        public Integer getCidSt(){return this.cidSt;}

        public Integer getCidEd(){return this.cidEd;}

        private List<String> titleList;

        public List<String> getTitleList(){return this.titleList;}


        private List<String> fuzzyTitle;

        public List<String> getFuzzyTitle(){return this.fuzzyTitle;}

        private List<String> rightFuzzyTitle;

        public List<String> getRightFuzzyTitle(){return this.rightFuzzyTitle;}
        private List<String> slugList;

        public List<String> getSlugList(){return this.slugList;}


        private List<String> fuzzySlug;

        public List<String> getFuzzySlug(){return this.fuzzySlug;}

        private List<String> rightFuzzySlug;

        public List<String> getRightFuzzySlug(){return this.rightFuzzySlug;}
        private List<Integer> createdList;

        public List<Integer> getCreatedList(){return this.createdList;}

        private Integer createdSt;

        private Integer createdEd;

        public Integer getCreatedSt(){return this.createdSt;}

        public Integer getCreatedEd(){return this.createdEd;}

        private List<Integer> modifiedList;

        public List<Integer> getModifiedList(){return this.modifiedList;}

        private Integer modifiedSt;

        private Integer modifiedEd;

        public Integer getModifiedSt(){return this.modifiedSt;}

        public Integer getModifiedEd(){return this.modifiedEd;}

        private List<String> contentList;

        public List<String> getContentList(){return this.contentList;}


        private List<String> fuzzyContent;

        public List<String> getFuzzyContent(){return this.fuzzyContent;}

        private List<String> rightFuzzyContent;

        public List<String> getRightFuzzyContent(){return this.rightFuzzyContent;}
        private List<Integer> authorIdList;

        public List<Integer> getAuthorIdList(){return this.authorIdList;}

        private Integer authorIdSt;

        private Integer authorIdEd;

        public Integer getAuthorIdSt(){return this.authorIdSt;}

        public Integer getAuthorIdEd(){return this.authorIdEd;}

        private List<String> typeList;

        public List<String> getTypeList(){return this.typeList;}


        private List<String> fuzzyType;

        public List<String> getFuzzyType(){return this.fuzzyType;}

        private List<String> rightFuzzyType;

        public List<String> getRightFuzzyType(){return this.rightFuzzyType;}
        private List<String> statusList;

        public List<String> getStatusList(){return this.statusList;}


        private List<String> fuzzyStatus;

        public List<String> getFuzzyStatus(){return this.fuzzyStatus;}

        private List<String> rightFuzzyStatus;

        public List<String> getRightFuzzyStatus(){return this.rightFuzzyStatus;}
        private List<String> tagsList;

        public List<String> getTagsList(){return this.tagsList;}


        private List<String> fuzzyTags;

        public List<String> getFuzzyTags(){return this.fuzzyTags;}

        private List<String> rightFuzzyTags;

        public List<String> getRightFuzzyTags(){return this.rightFuzzyTags;}
        private List<String> categoriesList;

        public List<String> getCategoriesList(){return this.categoriesList;}


        private List<String> fuzzyCategories;

        public List<String> getFuzzyCategories(){return this.fuzzyCategories;}

        private List<String> rightFuzzyCategories;

        public List<String> getRightFuzzyCategories(){return this.rightFuzzyCategories;}
        private List<Integer> hitsList;

        public List<Integer> getHitsList(){return this.hitsList;}

        private Integer hitsSt;

        private Integer hitsEd;

        public Integer getHitsSt(){return this.hitsSt;}

        public Integer getHitsEd(){return this.hitsEd;}

        private List<Integer> commentsNumList;

        public List<Integer> getCommentsNumList(){return this.commentsNumList;}

        private Integer commentsNumSt;

        private Integer commentsNumEd;

        public Integer getCommentsNumSt(){return this.commentsNumSt;}

        public Integer getCommentsNumEd(){return this.commentsNumEd;}

        private List<Integer> allowCommentList;

        public List<Integer> getAllowCommentList(){return this.allowCommentList;}

        private Integer allowCommentSt;

        private Integer allowCommentEd;

        public Integer getAllowCommentSt(){return this.allowCommentSt;}

        public Integer getAllowCommentEd(){return this.allowCommentEd;}

        private List<Integer> allowPingList;

        public List<Integer> getAllowPingList(){return this.allowPingList;}

        private Integer allowPingSt;

        private Integer allowPingEd;

        public Integer getAllowPingSt(){return this.allowPingSt;}

        public Integer getAllowPingEd(){return this.allowPingEd;}

        private List<Integer> allowFeedList;

        public List<Integer> getAllowFeedList(){return this.allowFeedList;}

        private Integer allowFeedSt;

        private Integer allowFeedEd;

        public Integer getAllowFeedSt(){return this.allowFeedSt;}

        public Integer getAllowFeedEd(){return this.allowFeedEd;}


        public ConditionBuilder cidBetWeen(Integer cidSt,Integer cidEd){
            this.cidSt = cidSt;
            this.cidEd = cidEd;
            return this;
        }

        public ConditionBuilder cidGreaterEqThan(Integer cidSt){
            this.cidSt = cidSt;
            return this;
        }
        public ConditionBuilder cidLessEqThan(Integer cidEd){
            this.cidEd = cidEd;
            return this;
        }


        public ConditionBuilder cidList(Integer ... cid){
            this.cidList = solveNullList(cid);
            return this;
        }

        public ConditionBuilder cidList(List<Integer> cid){
            this.cidList = cid;
            return this;
        }

        public ConditionBuilder fuzzyTitle (List<String> fuzzyTitle){
            this.fuzzyTitle = fuzzyTitle;
            return this;
        }

        public ConditionBuilder fuzzyTitle (String ... fuzzyTitle){
            this.fuzzyTitle = solveNullList(fuzzyTitle);
            return this;
        }

        public ConditionBuilder rightFuzzyTitle (List<String> rightFuzzyTitle){
            this.rightFuzzyTitle = rightFuzzyTitle;
            return this;
        }

        public ConditionBuilder rightFuzzyTitle (String ... rightFuzzyTitle){
            this.rightFuzzyTitle = solveNullList(rightFuzzyTitle);
            return this;
        }

        public ConditionBuilder titleList(String ... title){
            this.titleList = solveNullList(title);
            return this;
        }

        public ConditionBuilder titleList(List<String> title){
            this.titleList = title;
            return this;
        }

        public ConditionBuilder fuzzySlug (List<String> fuzzySlug){
            this.fuzzySlug = fuzzySlug;
            return this;
        }

        public ConditionBuilder fuzzySlug (String ... fuzzySlug){
            this.fuzzySlug = solveNullList(fuzzySlug);
            return this;
        }

        public ConditionBuilder rightFuzzySlug (List<String> rightFuzzySlug){
            this.rightFuzzySlug = rightFuzzySlug;
            return this;
        }

        public ConditionBuilder rightFuzzySlug (String ... rightFuzzySlug){
            this.rightFuzzySlug = solveNullList(rightFuzzySlug);
            return this;
        }

        public ConditionBuilder slugList(String ... slug){
            this.slugList = solveNullList(slug);
            return this;
        }

        public ConditionBuilder slugList(List<String> slug){
            this.slugList = slug;
            return this;
        }

        public ConditionBuilder createdBetWeen(Integer createdSt,Integer createdEd){
            this.createdSt = createdSt;
            this.createdEd = createdEd;
            return this;
        }

        public ConditionBuilder createdGreaterEqThan(Integer createdSt){
            this.createdSt = createdSt;
            return this;
        }
        public ConditionBuilder createdLessEqThan(Integer createdEd){
            this.createdEd = createdEd;
            return this;
        }


        public ConditionBuilder createdList(Integer ... created){
            this.createdList = solveNullList(created);
            return this;
        }

        public ConditionBuilder createdList(List<Integer> created){
            this.createdList = created;
            return this;
        }

        public ConditionBuilder modifiedBetWeen(Integer modifiedSt,Integer modifiedEd){
            this.modifiedSt = modifiedSt;
            this.modifiedEd = modifiedEd;
            return this;
        }

        public ConditionBuilder modifiedGreaterEqThan(Integer modifiedSt){
            this.modifiedSt = modifiedSt;
            return this;
        }
        public ConditionBuilder modifiedLessEqThan(Integer modifiedEd){
            this.modifiedEd = modifiedEd;
            return this;
        }


        public ConditionBuilder modifiedList(Integer ... modified){
            this.modifiedList = solveNullList(modified);
            return this;
        }

        public ConditionBuilder modifiedList(List<Integer> modified){
            this.modifiedList = modified;
            return this;
        }

        public ConditionBuilder fuzzyContent (List<String> fuzzyContent){
            this.fuzzyContent = fuzzyContent;
            return this;
        }

        public ConditionBuilder fuzzyContent (String ... fuzzyContent){
            this.fuzzyContent = solveNullList(fuzzyContent);
            return this;
        }

        public ConditionBuilder rightFuzzyContent (List<String> rightFuzzyContent){
            this.rightFuzzyContent = rightFuzzyContent;
            return this;
        }

        public ConditionBuilder rightFuzzyContent (String ... rightFuzzyContent){
            this.rightFuzzyContent = solveNullList(rightFuzzyContent);
            return this;
        }

        public ConditionBuilder contentList(String ... content){
            this.contentList = solveNullList(content);
            return this;
        }

        public ConditionBuilder contentList(List<String> content){
            this.contentList = content;
            return this;
        }

        public ConditionBuilder authorIdBetWeen(Integer authorIdSt,Integer authorIdEd){
            this.authorIdSt = authorIdSt;
            this.authorIdEd = authorIdEd;
            return this;
        }

        public ConditionBuilder authorIdGreaterEqThan(Integer authorIdSt){
            this.authorIdSt = authorIdSt;
            return this;
        }
        public ConditionBuilder authorIdLessEqThan(Integer authorIdEd){
            this.authorIdEd = authorIdEd;
            return this;
        }


        public ConditionBuilder authorIdList(Integer ... authorId){
            this.authorIdList = solveNullList(authorId);
            return this;
        }

        public ConditionBuilder authorIdList(List<Integer> authorId){
            this.authorIdList = authorId;
            return this;
        }

        public ConditionBuilder fuzzyType (List<String> fuzzyType){
            this.fuzzyType = fuzzyType;
            return this;
        }

        public ConditionBuilder fuzzyType (String ... fuzzyType){
            this.fuzzyType = solveNullList(fuzzyType);
            return this;
        }

        public ConditionBuilder rightFuzzyType (List<String> rightFuzzyType){
            this.rightFuzzyType = rightFuzzyType;
            return this;
        }

        public ConditionBuilder rightFuzzyType (String ... rightFuzzyType){
            this.rightFuzzyType = solveNullList(rightFuzzyType);
            return this;
        }

        public ConditionBuilder typeList(String ... type){
            this.typeList = solveNullList(type);
            return this;
        }

        public ConditionBuilder typeList(List<String> type){
            this.typeList = type;
            return this;
        }

        public ConditionBuilder fuzzyStatus (List<String> fuzzyStatus){
            this.fuzzyStatus = fuzzyStatus;
            return this;
        }

        public ConditionBuilder fuzzyStatus (String ... fuzzyStatus){
            this.fuzzyStatus = solveNullList(fuzzyStatus);
            return this;
        }

        public ConditionBuilder rightFuzzyStatus (List<String> rightFuzzyStatus){
            this.rightFuzzyStatus = rightFuzzyStatus;
            return this;
        }

        public ConditionBuilder rightFuzzyStatus (String ... rightFuzzyStatus){
            this.rightFuzzyStatus = solveNullList(rightFuzzyStatus);
            return this;
        }

        public ConditionBuilder statusList(String ... status){
            this.statusList = solveNullList(status);
            return this;
        }

        public ConditionBuilder statusList(List<String> status){
            this.statusList = status;
            return this;
        }

        public ConditionBuilder fuzzyTags (List<String> fuzzyTags){
            this.fuzzyTags = fuzzyTags;
            return this;
        }

        public ConditionBuilder fuzzyTags (String ... fuzzyTags){
            this.fuzzyTags = solveNullList(fuzzyTags);
            return this;
        }

        public ConditionBuilder rightFuzzyTags (List<String> rightFuzzyTags){
            this.rightFuzzyTags = rightFuzzyTags;
            return this;
        }

        public ConditionBuilder rightFuzzyTags (String ... rightFuzzyTags){
            this.rightFuzzyTags = solveNullList(rightFuzzyTags);
            return this;
        }

        public ConditionBuilder tagsList(String ... tags){
            this.tagsList = solveNullList(tags);
            return this;
        }

        public ConditionBuilder tagsList(List<String> tags){
            this.tagsList = tags;
            return this;
        }

        public ConditionBuilder fuzzyCategories (List<String> fuzzyCategories){
            this.fuzzyCategories = fuzzyCategories;
            return this;
        }

        public ConditionBuilder fuzzyCategories (String ... fuzzyCategories){
            this.fuzzyCategories = solveNullList(fuzzyCategories);
            return this;
        }

        public ConditionBuilder rightFuzzyCategories (List<String> rightFuzzyCategories){
            this.rightFuzzyCategories = rightFuzzyCategories;
            return this;
        }

        public ConditionBuilder rightFuzzyCategories (String ... rightFuzzyCategories){
            this.rightFuzzyCategories = solveNullList(rightFuzzyCategories);
            return this;
        }

        public ConditionBuilder categoriesList(String ... categories){
            this.categoriesList = solveNullList(categories);
            return this;
        }

        public ConditionBuilder categoriesList(List<String> categories){
            this.categoriesList = categories;
            return this;
        }

        public ConditionBuilder hitsBetWeen(Integer hitsSt,Integer hitsEd){
            this.hitsSt = hitsSt;
            this.hitsEd = hitsEd;
            return this;
        }

        public ConditionBuilder hitsGreaterEqThan(Integer hitsSt){
            this.hitsSt = hitsSt;
            return this;
        }
        public ConditionBuilder hitsLessEqThan(Integer hitsEd){
            this.hitsEd = hitsEd;
            return this;
        }


        public ConditionBuilder hitsList(Integer ... hits){
            this.hitsList = solveNullList(hits);
            return this;
        }

        public ConditionBuilder hitsList(List<Integer> hits){
            this.hitsList = hits;
            return this;
        }

        public ConditionBuilder commentsNumBetWeen(Integer commentsNumSt,Integer commentsNumEd){
            this.commentsNumSt = commentsNumSt;
            this.commentsNumEd = commentsNumEd;
            return this;
        }

        public ConditionBuilder commentsNumGreaterEqThan(Integer commentsNumSt){
            this.commentsNumSt = commentsNumSt;
            return this;
        }
        public ConditionBuilder commentsNumLessEqThan(Integer commentsNumEd){
            this.commentsNumEd = commentsNumEd;
            return this;
        }


        public ConditionBuilder commentsNumList(Integer ... commentsNum){
            this.commentsNumList = solveNullList(commentsNum);
            return this;
        }

        public ConditionBuilder commentsNumList(List<Integer> commentsNum){
            this.commentsNumList = commentsNum;
            return this;
        }

        public ConditionBuilder allowCommentBetWeen(Integer allowCommentSt,Integer allowCommentEd){
            this.allowCommentSt = allowCommentSt;
            this.allowCommentEd = allowCommentEd;
            return this;
        }

        public ConditionBuilder allowCommentGreaterEqThan(Integer allowCommentSt){
            this.allowCommentSt = allowCommentSt;
            return this;
        }
        public ConditionBuilder allowCommentLessEqThan(Integer allowCommentEd){
            this.allowCommentEd = allowCommentEd;
            return this;
        }


        public ConditionBuilder allowCommentList(Integer ... allowComment){
            this.allowCommentList = solveNullList(allowComment);
            return this;
        }

        public ConditionBuilder allowCommentList(List<Integer> allowComment){
            this.allowCommentList = allowComment;
            return this;
        }

        public ConditionBuilder allowPingBetWeen(Integer allowPingSt,Integer allowPingEd){
            this.allowPingSt = allowPingSt;
            this.allowPingEd = allowPingEd;
            return this;
        }

        public ConditionBuilder allowPingGreaterEqThan(Integer allowPingSt){
            this.allowPingSt = allowPingSt;
            return this;
        }
        public ConditionBuilder allowPingLessEqThan(Integer allowPingEd){
            this.allowPingEd = allowPingEd;
            return this;
        }


        public ConditionBuilder allowPingList(Integer ... allowPing){
            this.allowPingList = solveNullList(allowPing);
            return this;
        }

        public ConditionBuilder allowPingList(List<Integer> allowPing){
            this.allowPingList = allowPing;
            return this;
        }

        public ConditionBuilder allowFeedBetWeen(Integer allowFeedSt,Integer allowFeedEd){
            this.allowFeedSt = allowFeedSt;
            this.allowFeedEd = allowFeedEd;
            return this;
        }

        public ConditionBuilder allowFeedGreaterEqThan(Integer allowFeedSt){
            this.allowFeedSt = allowFeedSt;
            return this;
        }
        public ConditionBuilder allowFeedLessEqThan(Integer allowFeedEd){
            this.allowFeedEd = allowFeedEd;
            return this;
        }


        public ConditionBuilder allowFeedList(Integer ... allowFeed){
            this.allowFeedList = solveNullList(allowFeed);
            return this;
        }

        public ConditionBuilder allowFeedList(List<Integer> allowFeed){
            this.allowFeedList = allowFeed;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private Contents obj;

        public Builder(){
            this.obj = new Contents();
        }

        public Builder cid(Integer cid){
            this.obj.setCid(cid);
            return this;
        }
        public Builder title(String title){
            this.obj.setTitle(title);
            return this;
        }
        public Builder slug(String slug){
            this.obj.setSlug(slug);
            return this;
        }
        public Builder created(Integer created){
            this.obj.setCreated(created);
            return this;
        }
        public Builder modified(Integer modified){
            this.obj.setModified(modified);
            return this;
        }
        public Builder content(String content){
            this.obj.setContent(content);
            return this;
        }
        public Builder authorId(Integer authorId){
            this.obj.setAuthorId(authorId);
            return this;
        }
        public Builder type(String type){
            this.obj.setType(type);
            return this;
        }
        public Builder status(String status){
            this.obj.setStatus(status);
            return this;
        }
        public Builder tags(String tags){
            this.obj.setTags(tags);
            return this;
        }
        public Builder categories(String categories){
            this.obj.setCategories(categories);
            return this;
        }
        public Builder hits(Integer hits){
            this.obj.setHits(hits);
            return this;
        }
        public Builder commentsNum(Integer commentsNum){
            this.obj.setCommentsNum(commentsNum);
            return this;
        }
        public Builder allowComment(Integer allowComment){
            this.obj.setAllowComment(allowComment);
            return this;
        }
        public Builder allowPing(Integer allowPing){
            this.obj.setAllowPing(allowPing);
            return this;
        }
        public Builder allowFeed(Integer allowFeed){
            this.obj.setAllowFeed(allowFeed);
            return this;
        }
        public Contents build(){return obj;}
    }

}
