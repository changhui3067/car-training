package com.car.training.domain;

import com.car.training.enums.Education;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class Trainer implements Serializable {

    private static final long serialVersionUID = 921909027302657526L;

    private String id;

    /**
     * 用户编号外键UserCenter
     **/
    private UserCenter userCenter;

    /**
     * 星级
     */
    private int starLevel;

    /**
     * 学历
     */
    private Education education;

    /**
     * 主修课程
     */
    private String mainCourse;

    /**
     * 汽车行业经验
     */
    private Integer autoYears;

    /**
     * 培训行业经验
     */
    private Integer trainingYears;

    /**
     * 业务领域
     **/
    private Set<String> businessCategory;

    /**
     * 执行类别
     **/
    private Set<String> executionCategory;

    /**
     * 当前职位
     **/
    private String currentPosition;

    /**
     * 公司发起的橄榄枝
     **/
    private String olives;

    /**
     * 创建时间
     **/
    private Date createDate;

    /**
     * 修改时间
     **/
    private Date modifyDate;

    /**
     * 是否诚信认证,默认为false未认证
     **/
    private boolean authFaithed;

    /**
     * 学员对讲师的平均打分
     **/
    private BigDecimal averageScore;

    /**
     * 培训师的展示视频1
     **/
    private String vedioURL1;

    /**
     * 培训师的展示视频2
     **/
    private String vedioURL2;

    /**
     * 是否推荐
     **/
    private boolean promoted;

    /**
     * 学员评论列表
     */
    private List<AutobotsComment> autobotsCommentList;

    /**
     * 学员文章列表
     */
    private List<TrainerEssay> trainerEssayList;

    /**
     * 培训公开课列表
     */
    private List<Courses> coursesList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserCenter getUserCenter() {
        return userCenter;
    }

    public void setUserCenter(UserCenter userCenter) {
        this.userCenter = userCenter;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Integer getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(Integer autoYears) {
        this.autoYears = autoYears;
    }

    public Integer getTrainingYears() {
        return trainingYears;
    }

    public void setTrainingYears(Integer trainingYears) {
        this.trainingYears = trainingYears;
    }

    public Set<String> getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Set<String> businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Set<String> getExecutionCategory() {
        return executionCategory;
    }

    public void setExecutionCategory(Set<String> executionCategory) {
        this.executionCategory = executionCategory;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getOlives() {
        return olives;
    }

    public void setOlives(String olives) {
        this.olives = olives;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isAuthFaithed() {
        return authFaithed;
    }

    public void setAuthFaithed(boolean authFaithed) {
        this.authFaithed = authFaithed;
    }

    public BigDecimal getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(BigDecimal averageScore) {
        this.averageScore = averageScore;
    }

    public String getVedioURL1() {
        return vedioURL1;
    }

    public void setVedioURL1(String vedioURL1) {
        this.vedioURL1 = vedioURL1;
    }

    public String getVedioURL2() {
        return vedioURL2;
    }

    public void setVedioURL2(String vedioURL2) {
        this.vedioURL2 = vedioURL2;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public List<AutobotsComment> getAutobotsCommentList() {
        return autobotsCommentList;
    }

    public void setAutobotsCommentList(List<AutobotsComment> autobotsCommentList) {
        this.autobotsCommentList = autobotsCommentList;
    }

    public List<TrainerEssay> getTrainerEssayList() {
        return trainerEssayList;
    }

    public void setTrainerEssayList(List<TrainerEssay> trainerEssayList) {
        this.trainerEssayList = trainerEssayList;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
