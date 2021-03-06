package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.*;
import com.car.training.enums.JobType;
import com.car.training.enums.ReactTime;
import com.car.training.enums.UserType;
import com.car.training.service.SimpleService;
import com.car.training.utils.BeanOperation;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by bill on 12/2/16.
 */
@AutoConfig
public class TestAction extends SimpleAction {

    @Autowired
    BeanOperation beanOperation;

    @Autowired
    SimpleService simpleService;

    //personInfo fields
    private String avatarUrl = "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480230106666.png";
    private Region region;
    private String name = "Silk";
    private Date birthday = new Date();
    private String email = "a@b";
    private String marriageStatus = "";
    private String mobile;

    //autobotProps
    private String workingStatus = "求职";
    private int autoYears = 10;
    //    private String autoBrand;
    private String certRecords = "no";
    private String workingHistory = "no";
    private String currentPosition = "no position";
    private String trainingHistory = "no";
    private String education = "高中";

    private HashSet<String> businessCategory;

    private String[] autoBrands = new String[]{"大众", "丰田", "本田", "日产", "奥迪", "雪佛兰", "现代", "宝马", "别克", "奇瑞", "比亚迪", "福特", "马自达"};

    private String[] businessCategories = new String[]{"销售", "产品", "技术", "管理", "财务", "人事", "生产", "非技术", "领导力", "新能源", "市场", "营销", "客户关系", "其他"};
    private String[] titles1 = new String[]{"总", "副", "", "全职", "临时"};
    private String[] titles2 = new String[]{"助理", "秘书", "洗车工", "修理工"};

    private String[] executionCategories = new String[]{"开发", "培训", "辅导", "项目管理", "经销商托管"};
    private String[] businessCategoriesForAutobot = new String[]{"内训", "销售市场", "售后客服", "高级管理", "人事财务", "生产研发"};
    private String[] welfares = new String[]{"包吃", "包住", "五险一金", "免费班车", "员工旅游", "工作补贴", "员工培训", "绩效奖金", "定期体检"};
    private String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "欧阳", "夏侯", "诸葛", "闻人", "东方"};
    private String[] names = {
            "嘉", "琼", "桂", "娣", "叶", "璧", "璐", "娅", "琦", "晶", "妍", "茜", "秋", "珊", "莎", "锦", "黛", "青", "倩", "婷", "姣", "婉", "娴", "瑾", "颖", "露", "瑶", "怡", "婵", "雁", "蓓", "纨", "仪", "荷", "丹", "蓉", "眉", "君", "琴", "蕊", "薇", "菁", "梦", "岚", "苑", "婕", "馨", "瑗", "琰", "韵", "融", "园", "艺", "咏", "卿", "聪", "澜", "纯", "毓", "悦", "昭", "冰", "爽", "琬", "茗", "羽", "希", "宁", "欣", "飘", "育", "滢", "馥", "筠", "柔", "竹", "霭", "凝", "晓", "欢", "霄", "枫", "芸", "菲", "寒", "伊", "亚", "宜", "可", "姬", "舒", "影", "荔", "枝", "思", "丽", "秀", "娟", "英", "华", "慧", "巧", "美", "娜", "静", "淑", "惠", "珠", "翠", "雅", "芝", "玉", "萍", "红", "娥", "玲", "芬", "芳", "燕", "彩", "春", "菊", "勤", "珍", "贞", "莉", "兰", "凤", "洁", "梅", "琳", "素", "云", "莲", "真", "环", "雪", "荣", "爱", "妹", "霞", "香", "月", "莺", "媛", "艳", "瑞", "凡", "涛", "昌", "进", "林", "有", "坚", "和", "彪", "博", "诚", "先", "敬", "震", "振", "壮", "会", "群", "豪", "心", "邦", "承", "乐", "绍", "功", "松", "善", "厚", "庆", "磊", "民", "友", "裕", "河", "哲", "江", "超", "浩", "亮", "政", "谦", "亨", "奇", "固", "之", "轮", "翰", "朗", "伯", "宏", "言", "若", "鸣", "朋", "斌", "梁", "栋", "维", "启", "克", "伦", "翔", "旭", "鹏", "泽", "晨", "辰", "士", "以", "建", "家", "致", "树", "炎", "德", "行", "时", "泰", "盛", "雄", "琛", "钧", "冠", "策", "腾", "伟", "刚", "勇", "毅", "俊", "峰", "强", "军", "平", "保", "东", "文", "辉", "力", "明", "永", "健", "世", "广", "志", "义", "兴", "良", "海", "山", "仁", "波", "宁", "贵", "福", "生", "龙", "元", "全", "国", "胜", "学", "祥", "才", "发", "成", "康", "星", "光", "天", "达", "安", "岩", "中", "茂", "武", "新", "利", "清", "飞", "彬", "富", "顺", "信", "子", "杰", "楠", "榕", "风", "航", "弘"
    };
    String[] avatars = new String[]{"http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480689638002.png",
            "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480689657310.png",
            "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480689674598.png",
            "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480689694642.png",
            "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480689711691.png",
    };
    private HashSet<String> executionCategory;
    private String mainCourse = "no course";
    private String videoUrl1 = "http://player.youku.com/player.php/sid/XOTU2NzY1NjY4/v.swf";
    private String videoUrl2 = "http://player.youku.com/player.php/sid/XOTU2NzY1NjY4/v.swf";

    //companyProps
//  "name",
    private String address = "bu tian zendi";
    //  "region",
    private String autoBrand;
    private String businessRange;
    private String logoUrl = "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480767851719.png";
    private String scale = "50人以下";
    private String introduction = "hello introduction";
    private ReactTime reactTime = null;
    private String welfare = "";
    //  "businessCategory",
    private String photoUrl = "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480230106666.png";

    private String title;

    private int workExperienceRequirement;

    private String educationRequirement;

    private String salary;

    private String jobDescription;

    private Date createDate = new Date();

    private String majorRequirement;

    private String department;

    public String execute() throws Exception {
        for (int i = 0; i < 50; i++) {
            addAutobot();
            addTrainer();
            addCompany();
        }
        for (Company company : (List<Company>) simpleService.getAll(Company.class)) {
            addJob(company);
        }

        return successJSON();
    }

    private void addCompany() {
        initValue(businessCategories);
        LoginUser loginUser = new LoginUser();
        Company company = new Company();
        company.setLoginUser(loginUser);
        loginUser.setPassword("1");
        Random random = new Random();
        loginUser.setUsername(mobile);
        beanOperation.setAllValue(this, company);
        if (random.nextBoolean()) {
            company.setCompanyType("STORE");
            loginUser.setType(UserType.STORE);
            company.setName(autoBrand + "经销商");
        } else {
            company.setCompanyType("COMPANY");
            loginUser.setType(UserType.COMPANY);
            company.setName(autoBrand + "培训店");
        }
        simpleService.save(company);
    }

    private void addJob(Company company) {
        Job job = new Job();
        //job type
        //company

        Random random = new Random();
        title = getRandom(titles1) + getRandom(titles2);
        workExperienceRequirement = randomInt(10);
        educationRequirement = "无";
        salary = randomInt(10) + "000";
        jobDescription = getRandom(businessCategoriesForAutobot)+getRandom(businessCategoriesForAutobot)+getRandom(businessCategoriesForAutobot);
        majorRequirement = "无";
        department = getRandom(businessCategoriesForAutobot) + "部";

        beanOperation.setAllValue(this, job);
        job.setCompany(company);
        job.setType(company.getCompanyType().equals("COMPANY") ? JobType.TRAINER : JobType.AUTOBOT);
        if(company.getCompanyType().equals("COMPANY")){
            job.setBusinessCategory(getRandom(businessCategories));
        }else {
            job.setBusinessCategory(getRandom(businessCategoriesForAutobot));
        }
        simpleService.save(job);
    }

    public void addTrainer() {
        initValue(businessCategories);
        Trainer trainer = new Trainer();
        PersonInfo personInfo = new PersonInfo();
        beanOperation.setAllValue(this, trainer);
        beanOperation.setAllValue(this, personInfo);
        trainer.setPersonInfo(personInfo);
        LoginUser loginUser = new LoginUser();
        loginUser.setType(UserType.TRAINER);
        loginUser.setPassword("1");
        loginUser.setUsername(mobile);
        trainer.setLoginUser(loginUser);
        simpleService.save(trainer);

    }


    public void addAutobot() {
        System.out.println("add trainer");
        initValue(businessCategoriesForAutobot);
        Autobot autobot = new Autobot();
        PersonInfo personInfo = new PersonInfo();
        beanOperation.setAllValue(this, autobot);
        beanOperation.setAllValue(this, personInfo);
        autobot.setPersonInfo(personInfo);
        LoginUser loginUser = new LoginUser();
        loginUser.setType(UserType.AUTOBOT);
        loginUser.setPassword("1");
        loginUser.setUsername(mobile);
        autobot.setLoginUser(loginUser);
        simpleService.save(autobot);
    }


    private void initValue(String[] businessCategories) {
        avatarUrl = getRandom(avatars);
        welfare = getRandom(welfares);
        autoBrand = getRandom(autoBrands);
        businessRange = getRandom(autoBrands);
        autoYears = randomInt(20);
        businessCategory = new HashSet<>();
        businessCategory.add(businessCategories[randomInt(businessCategories.length)]);
        executionCategory = new HashSet<>();
        executionCategory.add(executionCategories[randomInt(executionCategories.length)]);
        name = Surname[randomInt(Surname.length)] + names[randomInt(names.length)];
        if (Math.random() > 0.5) {
            name += names[randomInt(names.length)];
        }
        region = new Region();
        region.setId(2L);
        mobile = "1578907" +  randomInt(10) + randomInt(10) + randomInt(10) + randomInt(10);
    }

    private String getRandom(String[] arr) {
        if (arr != null && arr.length > 0) {
            return arr[randomInt(arr.length)];
        } else {
            return "";
        }
    }

    private static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
}
