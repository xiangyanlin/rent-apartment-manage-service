package com.xyl.rental.utils;
import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/5/18 19:17
 */
public class RandomDataUtil {

    // 18位身份证号码各位的含义:
    // 1-2位省、自治区、直辖市代码；
    // 3-4位地级市、盟、自治州代码；
    // 5-6位县、县级市、区代码；
    // 7-14位出生年月日，比如19670401代表1967年4月1日；
    // 15-17位为顺序号，其中17位（倒数第二位）男为单数，女为双数；
    // 18位为校验码，0-9和X。
    // 作为尾号的校验码，是由把前十七位数字带入统一的公式计算出来的，
    // 计算的结果是0-10，如果某人的尾号是0－9，都不会出现X，但如果尾号是10，那么就得用X来代替，
    // 因为如果用10做尾号，那么此人的身份证就变成了19位。X是罗马数字的10，用X来代替10

    public static String getRandomIdCard() {
        String idCard = "";
        // 随机生成省、自治区、直辖市代码 1-2
        String provinces[] = { "11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
                "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
                "63", "64", "65", "71", "81", "82" };
        String province = provinces[new Random().nextInt(provinces.length - 1)];
        // 随机生成地级市、盟、自治州代码 3-4
        String citys[] = { "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "21", "22", "23", "24", "25", "26", "27", "28" };
        String city = citys[new Random().nextInt(citys.length - 1)];
        // 随机生成县、县级市、区代码 5-6
        String countys[] = { "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" };
        String county = countys[new Random().nextInt(countys.length - 1)];
        // 随机生成出生年月 7-14
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE,
                date.get(Calendar.DATE) - new Random().nextInt(365 * 100));
        String birth = dft.format(date.getTime());
        // 随机生成顺序号 15-17
        String no = new Random().nextInt(999) + "";
        // 随机生成校验码 18
        String checks[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "X" };
        String check = checks[new Random().nextInt(checks.length - 1)];
        // 拼接身份证号码
        idCard = province + city + county + birth + no + check;

        return idCard;
    }
    public static String getProfession(){

        String str = null;
        Random random = new Random();
        String profession[]={ "医生", "教师", "教授", "程序员","记者","律师","文员","研究员",
                "学生", "国家机关工作人员", "老板", "军人", "婚介", "房产销售", "自由职业", "数据库管理员","工人"};
        int index = random.nextInt(profession.length - 1);

        str = profession[index]; //获得一个随机的姓氏
        return str;
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    public static String getRandomTel() {
        StringBuilder sb = new StringBuilder("1");
        Random random = new Random();
        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String getRandomName() {
        Random random = new Random();
        int len = random.nextInt(2) + 1;
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBk"); //转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }

    public static String getChineseFamilyName() {

        String str = null;

        Random random = new Random();

        /* 598 百家姓 */

        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",

                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",

                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",

                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",

                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",

                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟",

                "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应",

                "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀",

                "羊", "于", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山",

                "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景",

                "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠",

                "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却",

                "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习",

                "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",

                "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",

                "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉",

                "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨",

                "哈", "谯", "篁", "年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",

                "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦", "召", "仪", "风", "介", "巨",

                "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾",

                "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正",

                "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇",

                "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生",

                "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门",

                "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"};

        int index = random.nextInt(Surname.length - 1);

        str = Surname[index]; //获得一个随机的姓氏

        return str;

    }

    public static char getRandomChar() {

        Random random = new Random();

        /* 随机数字字符 */

        char[] Surname = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'};
        int index = random.nextInt(Surname.length - 1);

        char ch = Surname[index]; //获得一个随机的字符

        return ch;

    }

    public static char getRandomLowChar() {

        Random random = new Random();

        /* 随机数字字符 */

        char[] Surname = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int index = random.nextInt(Surname.length - 1);

        char ch = Surname[index]; //获得一个随机的字符

        return ch;

    }

    public static char getRandomUpChar() {

        Random random = new Random();

        /* 随机数字字符 */

        char[] Surname = {'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'};
        int index = random.nextInt(Surname.length - 1);

        char ch = Surname[index]; //获得一个随机的字符

        return ch;

    }

    public static Date getRandomDate(String start, String end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            if (startDate.getTime() - endDate.getTime() >= 0) {
                return null;
            }
            long rand = (long) (startDate.getTime() + (Math.random() * (endDate.getTime() - startDate.getTime())));
            return new Date(rand);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRandomAddress() {
        String[] pro = {"北京", "天津", "上海", "重庆", "河北", "山西", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "内蒙古", "广西", "西藏", "宁夏", "新疆维吾尔自治区", "香港", "澳门", "台湾"};
        String[][] city = {{"东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "房山区", "通州区",
                "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "门头沟区", "密云县", "延庆县"}, {"和平区", "河东区", "河西区",
                "南开区", "河北区", "红桥区", "东丽区", "西青区", "北辰区", "津南区", "武清区", "宝坻区", "滨海新区", "静海县",
                "宁河县", "蓟县"}, {"黄浦区", "卢湾区", "徐汇区", "长宁区", "静安区", "普陀区", "闸北区", "虹口区", "杨浦区",
                "闵行区", "宝山区", "嘉定区", "浦东新区", "金山区", "松江区", "青浦区", "奉贤区", "崇明县"}, {"渝中区",
                "大渡口区", "江北区", "南岸区", "北碚区", "渝北区", "巴南区", "长寿区", "双桥区", "沙坪坝区", "万盛区",
                "万州区", "涪陵区", "黔江区", "永川区", "合川区", "江津区", "九龙坡区", "南川区", "綦江县", "潼南县",
                "荣昌县", "璧山县", "大足县", "铜梁县", "梁平县", "开县", "忠县", "城口县", "垫江县", "武隆县", "丰都县",
                "奉节县", "云阳县", "巫溪县", "巫山县", "石柱土家族自治县", "秀山土家族苗族自治县", "酉阳土家族苗族自治县",
                "彭水苗族土家族自治县"}, {"石家庄", "唐山", "秦皇岛", "邯郸", "邢台", "保定", "张家口", "承德", "沧州", "廊坊",
                "衡水"}, {"太原", "大同", "阳泉", "长治", "晋城", "朔州", "晋中", "运城", "忻州", "临汾", "吕梁"}, {"沈阳", "大连",
                "鞍山", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳", "盘锦", "铁岭", "朝阳", "葫芦岛"}, {"长春", "吉林",
                "四平", "辽源", "通化", "白山", "松原", "白城", "延边朝鲜族自治州"}, {"哈尔滨", "齐齐哈尔", "鹤岗", "双鸭山",
                "鸡西", "大庆", "伊春", "牡丹江", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭"}, {"南京", "苏州", "无锡", "常州",
                "镇江", "南通", "泰州", "扬州", "盐城", "连云港", "徐州", "淮安", "宿迁"}, {"杭州", "宁波", "温州", "嘉兴", "湖州",
                "绍兴", "金华", "衢州", "舟山", "台州", "丽水"}, {"合肥", "芜湖", "蚌埠", "淮南", "马鞍山", "淮北", "铜陵", "安庆",
                "黄山", "滁州", "阜阳", "宿州", "巢湖", "六安", "亳州", "池州", "宣城"}, {"福州", "厦门", "莆田", "三明", "泉州",
                "漳州", "南平", "龙岩", "宁德"}, {"南昌", "景德镇", "萍乡", "九江", "新余", "鹰潭", "赣州", "吉安", "宜春", "抚州",
                "上饶"}, {"济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照", "莱芜", "临沂",
                "德州", "聊城", "滨州", "菏泽"}, {"郑州", "开封", "洛阳", "平顶山", "安阳", "鹤壁", "新乡", "焦作", "濮阳", "许昌",
                "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店"}, {"武汉", "黄石", "十堰", "荆州", "宜昌", "襄樊", "鄂州",
                "荆门", "孝感", "黄冈", "咸宁", "随州", "恩施"}, {"长沙", "株洲", "湘潭", "衡阳", "邵阳", "岳阳", "常德", "张家界",
                "益阳", "郴州", "永州", "怀化", "娄底", "湘西"}, {"广州", "深圳", "珠海", "汕头", "韶关", "佛山", "江门", "湛江",
                "茂名", "肇庆", "惠州", "梅州", "汕尾", "河源", "阳江", "清远", "东莞", "中山", "潮州", "揭阳", "云浮"}, {"海口",
                "三亚"}, {"成都", "自贡", "攀枝花", "泸州", "德阳", "绵阳", "广元", "遂宁", "内江", "乐山", "南充", "眉山", "宜宾",
                "广安", "达州", "雅安", "巴中", "资阳", "阿坝", "甘孜", "凉山"}, {"贵阳", "六盘水", "遵义", "安顺", "铜仁", "毕节",
                "黔西南", "黔东南", "黔南"}, {"昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "普洱", "临沧", "德宏", "怒江", "迪庆",
                "大理", "楚雄", "红河", "文山", "西双版纳"}, {"西安", "铜川", "宝鸡", "咸阳", "渭南", "延安", "汉中", "榆林", "安康",
                "商洛"}, {"兰州", "嘉峪关", "金昌", "白银", "天水", "武威", "酒泉", "张掖", "庆阳", "平凉", "定西", "陇南", "临夏",
                "甘南"}, {"西宁", "海东", "海北", "海南", "黄南", "果洛", "玉树", "海西"}, {"呼和浩特", "包头", "乌海", "赤峰",
                "通辽", "鄂尔多斯", "呼伦贝尔", "巴彦淖尔", "乌兰察布", "锡林郭勒盟", "兴安盟", "阿拉善盟"}, {"南宁", "柳州",
                "桂林", "梧州", "北海", "防城港", "钦州", "贵港", "玉林", "百色", "贺州", "河池", "来宾", "崇左"}, {"拉萨", "那曲",
                "昌都", "林芝", "山南", "日喀则", "阿里"}, {"银川", "石嘴山", "吴忠", "固原", "中卫"}, {"乌鲁木齐", "克拉玛依",
                "吐鲁番", "哈密", "和田", "阿克苏", "喀什", "克孜勒苏", "巴音郭楞", "昌吉", "博尔塔拉", "伊犁", "塔城", "阿勒泰"},
                {"香港岛", "九龙东", "九龙西", "新界东", "新界西"}, {"澳门半岛", "离岛"}, {"台北", "高雄", "基隆", "新竹", "台中", "嘉义", "台南市"}};
        Random random = new Random();
        int proNumber = random.nextInt(34);
        String address = pro[proNumber] + city[proNumber][random.nextInt(city[proNumber].length)];
        return address;
    }

    public static String getRandomAddressCity() {
        String[] pro = {"北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "内蒙古省", "广西省", "西藏省", "宁夏省", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区", "台湾省"};
        String[][] city1 = {{"东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "房山区", "通州区",
                "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "门头沟区", "密云县", "延庆县"}, {"和平区", "河东区", "河西区",
                "南开区", "河北区", "红桥区", "东丽区", "西青区", "北辰区", "津南区", "武清区", "宝坻区", "滨海新区", "静海县",
                "宁河县", "蓟县"}, {"黄浦区", "卢湾区", "徐汇区", "长宁区", "静安区", "普陀区", "闸北区", "虹口区", "杨浦区",
                "闵行区", "宝山区", "嘉定区", "浦东新区", "金山区", "松江区", "青浦区", "奉贤区", "崇明县"}, {"渝中区",
                "大渡口区", "江北区", "南岸区", "北碚区", "渝北区", "巴南区", "长寿区", "双桥区", "沙坪坝区", "万盛区",
                "万州区", "涪陵区", "黔江区", "永川区", "合川区", "江津区", "九龙坡区", "南川区", "綦江县", "潼南县",
                "荣昌县", "璧山县", "大足县", "铜梁县", "梁平县", "开县", "忠县", "城口县", "垫江县", "武隆县", "丰都县",
                "奉节县", "云阳县", "巫溪县", "巫山县", "石柱土家族自治县", "秀山土家族苗族自治县", "酉阳土家族苗族自治县",
                "彭水苗族土家族自治县"}, {"石家庄", "唐山", "秦皇岛", "邯郸", "邢台", "保定", "张家口", "承德", "沧州", "廊坊",
                "衡水"}, {"太原", "大同", "阳泉", "长治", "晋城", "朔州", "晋中", "运城", "忻州", "临汾", "吕梁"}, {"沈阳", "大连",
                "鞍山", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳", "盘锦", "铁岭", "朝阳", "葫芦岛"}, {"长春", "吉林",
                "四平", "辽源", "通化", "白山", "松原", "白城", "延边朝鲜族自治州"}, {"哈尔滨", "齐齐哈尔", "鹤岗", "双鸭山",
                "鸡西", "大庆", "伊春", "牡丹江", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭"}, {"南京", "苏州", "无锡", "常州",
                "镇江", "南通", "泰州", "扬州", "盐城", "连云港", "徐州", "淮安", "宿迁"}, {"杭州", "宁波", "温州", "嘉兴", "湖州",
                "绍兴", "金华", "衢州", "舟山", "台州", "丽水"}, {"合肥", "芜湖", "蚌埠", "淮南", "马鞍山", "淮北", "铜陵", "安庆",
                "黄山", "滁州", "阜阳", "宿州", "巢湖", "六安", "亳州", "池州", "宣城"}, {"福州", "厦门", "莆田", "三明", "泉州",
                "漳州", "南平", "龙岩", "宁德"}, {"南昌", "景德镇", "萍乡", "九江", "新余", "鹰潭", "赣州", "吉安", "宜春", "抚州",
                "上饶"}, {"济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照", "莱芜", "临沂",
                "德州", "聊城", "滨州", "菏泽"}, {"郑州", "开封", "洛阳", "平顶山", "安阳", "鹤壁", "新乡", "焦作", "濮阳", "许昌",
                "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店"}, {"武汉", "黄石", "十堰", "荆州", "宜昌", "襄樊", "鄂州",
                "荆门", "孝感", "黄冈", "咸宁", "随州", "恩施"}, {"长沙", "株洲", "湘潭", "衡阳", "邵阳", "岳阳", "常德", "张家界",
                "益阳", "郴州", "永州", "怀化", "娄底", "湘西"}, {"广州", "深圳", "珠海", "汕头", "韶关", "佛山", "江门", "湛江",
                "茂名", "肇庆", "惠州", "梅州", "汕尾", "河源", "阳江", "清远", "东莞", "中山", "潮州", "揭阳", "云浮"}, {"海口",
                "三亚"}, {"成都", "自贡", "攀枝花", "泸州", "德阳", "绵阳", "广元", "遂宁", "内江", "乐山", "南充", "眉山", "宜宾",
                "广安", "达州", "雅安", "巴中", "资阳", "阿坝", "甘孜", "凉山"}, {"贵阳", "六盘水", "遵义", "安顺", "铜仁", "毕节",
                "黔西南", "黔东南", "黔南"}, {"昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "普洱", "临沧", "德宏", "怒江", "迪庆",
                "大理", "楚雄", "红河", "文山", "西双版纳"}, {"西安", "铜川", "宝鸡", "咸阳", "渭南", "延安", "汉中", "榆林", "安康",
                "商洛"}, {"兰州", "嘉峪关", "金昌", "白银", "天水", "武威", "酒泉", "张掖", "庆阳", "平凉", "定西", "陇南", "临夏",
                "甘南"}, {"西宁", "海东", "海北", "海南", "黄南", "果洛", "玉树", "海西"}, {"呼和浩特", "包头", "乌海", "赤峰",
                "通辽", "鄂尔多斯", "呼伦贝尔", "巴彦淖尔", "乌兰察布", "锡林郭勒盟", "兴安盟", "阿拉善盟"}, {"南宁", "柳州",
                "桂林", "梧州", "北海", "防城港", "钦州", "贵港", "玉林", "百色", "贺州", "河池", "来宾", "崇左"}, {"拉萨", "那曲",
                "昌都", "林芝", "山南", "日喀则", "阿里"}, {"银川", "石嘴山", "吴忠", "固原", "中卫"}, {"乌鲁木齐", "克拉玛依",
                "吐鲁番", "哈密", "和田", "阿克苏", "喀什", "克孜勒苏", "巴音郭楞", "昌吉", "博尔塔拉", "伊犁", "塔城", "阿勒泰"},
                {"香港岛", "九龙东", "九龙西", "新界东", "新界西"}, {"澳门半岛", "离岛"}, {"台北", "高雄", "基隆", "新竹", "台中", "嘉义", "台南市"}};
        String[][] city  = new String[pro.length][40];
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city1[i].length; j++) {
                if (i < 4){
                    city[i][j] = "市辖区";
                }
                else {
                    city[i][j] = city1[i][j]+"市";
                }
            }
        }
        Random random = new Random();
        int proNumber = random.nextInt(34);
        String address = pro[proNumber] + city[proNumber][random.nextInt(city1[proNumber].length)];
        return address;
    }

    public static String getRandomEmail() {
        String email = "";
        String[] emailFormat = {"@qq.com", "@gmail.com", "com@163.net", "@mail.com", "@163.com", "@sohu.com",
                "@yahoo.com", "@126.com", "@188.com", "@hotmail.com"};
        Random random = new Random();
        boolean falg = random.nextInt(2) == 1;
        int numberLength;
        if (falg){
            numberLength = 7 - 2 ;
        } else {
            numberLength = 9 + random.nextInt(3);
        }
        int charLength = 3 + random.nextInt(2);
        for (int i = 0; i < numberLength; i++) {
            if (i==0){
                email += random.nextInt(9)+1;
            } else {
                email += random.nextInt(10);
            }
        }
        if (falg) {
            for (int i = 0; i < charLength; i++) {
                email += getRandomLowChar();
            }
        }
        email += emailFormat[random.nextInt(10)];
        return email;
    }

    public static int getRandomNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }


    public static Map<String, String> getRandomAddressCode(){
        String json = "{ \"430000\": {\n" +
                "    \"430100\": \"长沙市\",\n" +
                "    \"430200\": \"株洲市\",\n" +
                "    \"430300\": \"湘潭市\",\n" +
                "    \"430400\": \"衡阳市\",\n" +
                "    \"430500\": \"邵阳市\",\n" +
                "    \"430600\": \"岳阳市\",\n" +
                "    \"430700\": \"常德市\",\n" +
                "    \"430800\": \"张家界市\",\n" +
                "    \"430900\": \"益阳市\",\n" +
                "    \"431000\": \"郴州市\",\n" +
                "    \"431100\": \"永州市\",\n" +
                "    \"431200\": \"怀化市\",\n" +
                "    \"431300\": \"娄底市\",\n" +
                "    \"433100\": \"湘西土家族苗族自治州\"\n" +
                "  },\n" +
                "  \"430100\": {\n" +
                "    \"430102\": \"芙蓉区\",\n" +
                "    \"430103\": \"天心区\",\n" +
                "    \"430104\": \"岳麓区\",\n" +
                "    \"430105\": \"开福区\",\n" +
                "    \"430111\": \"雨花区\",\n" +
                "    \"430112\": \"望城区\",\n" +
                "    \"430121\": \"长沙县\",\n" +
                "    \"430124\": \"宁乡县\",\n" +
                "    \"430181\": \"浏阳市\"\n" +
                "  },\n" +
                "  \"430200\": {\n" +
                "    \"430202\": \"荷塘区\",\n" +
                "    \"430203\": \"芦淞区\",\n" +
                "    \"430204\": \"石峰区\",\n" +
                "    \"430211\": \"天元区\",\n" +
                "    \"430221\": \"株洲县\",\n" +
                "    \"430223\": \"攸县\",\n" +
                "    \"430224\": \"茶陵县\",\n" +
                "    \"430225\": \"炎陵县\",\n" +
                "    \"430281\": \"醴陵市\"\n" +
                "  },\n" +
                "  \"430300\": {\n" +
                "    \"430302\": \"雨湖区\",\n" +
                "    \"430304\": \"岳塘区\",\n" +
                "    \"430321\": \"湘潭县\",\n" +
                "    \"430381\": \"湘乡市\",\n" +
                "    \"430382\": \"韶山市\"\n" +
                "  },\n" +
                "  \"430400\": {\n" +
                "    \"430405\": \"珠晖区\",\n" +
                "    \"430406\": \"雁峰区\",\n" +
                "    \"430407\": \"石鼓区\",\n" +
                "    \"430408\": \"蒸湘区\",\n" +
                "    \"430412\": \"南岳区\",\n" +
                "    \"430421\": \"衡阳县\",\n" +
                "    \"430422\": \"衡南县\",\n" +
                "    \"430423\": \"衡山县\",\n" +
                "    \"430424\": \"衡东县\",\n" +
                "    \"430426\": \"祁东县\",\n" +
                "    \"430481\": \"耒阳市\",\n" +
                "    \"430482\": \"常宁市\"\n" +
                "  },\n" +
                "  \"430500\": {\n" +
                "    \"430502\": \"双清区\",\n" +
                "    \"430503\": \"大祥区\",\n" +
                "    \"430511\": \"北塔区\",\n" +
                "    \"430521\": \"邵东县\",\n" +
                "    \"430522\": \"新邵县\",\n" +
                "    \"430523\": \"邵阳县\",\n" +
                "    \"430524\": \"隆回县\",\n" +
                "    \"430525\": \"洞口县\",\n" +
                "    \"430527\": \"绥宁县\",\n" +
                "    \"430528\": \"新宁县\",\n" +
                "    \"430529\": \"城步苗族自治县\",\n" +
                "    \"430581\": \"武冈市\"\n" +
                "  },\n" +
                "  \"430600\": {\n" +
                "    \"430602\": \"岳阳楼区\",\n" +
                "    \"430603\": \"云溪区\",\n" +
                "    \"430611\": \"君山区\",\n" +
                "    \"430621\": \"岳阳县\",\n" +
                "    \"430623\": \"华容县\",\n" +
                "    \"430624\": \"湘阴县\",\n" +
                "    \"430626\": \"平江县\",\n" +
                "    \"430681\": \"汨罗市\",\n" +
                "    \"430682\": \"临湘市\"\n" +
                "  },\n" +
                "  \"430700\": {\n" +
                "    \"430702\": \"武陵区\",\n" +
                "    \"430703\": \"鼎城区\",\n" +
                "    \"430721\": \"安乡县\",\n" +
                "    \"430722\": \"汉寿县\",\n" +
                "    \"430723\": \"澧县\",\n" +
                "    \"430724\": \"临澧县\",\n" +
                "    \"430725\": \"桃源县\",\n" +
                "    \"430726\": \"石门县\",\n" +
                "    \"430781\": \"津市市\"\n" +
                "  },\n" +
                "  \"430800\": {\n" +
                "    \"430802\": \"永定区\",\n" +
                "    \"430811\": \"武陵源区\",\n" +
                "    \"430821\": \"慈利县\",\n" +
                "    \"430822\": \"桑植县\"\n" +
                "  },\n" +
                "  \"430900\": {\n" +
                "    \"430902\": \"资阳区\",\n" +
                "    \"430903\": \"赫山区\",\n" +
                "    \"430921\": \"南县\",\n" +
                "    \"430922\": \"桃江县\",\n" +
                "    \"430923\": \"安化县\",\n" +
                "    \"430981\": \"沅江市\"\n" +
                "  },\n" +
                "  \"431000\": {\n" +
                "    \"431002\": \"北湖区\",\n" +
                "    \"431003\": \"苏仙区\",\n" +
                "    \"431021\": \"桂阳县\",\n" +
                "    \"431022\": \"宜章县\",\n" +
                "    \"431023\": \"永兴县\",\n" +
                "    \"431024\": \"嘉禾县\",\n" +
                "    \"431025\": \"临武县\",\n" +
                "    \"431026\": \"汝城县\",\n" +
                "    \"431027\": \"桂东县\",\n" +
                "    \"431028\": \"安仁县\",\n" +
                "    \"431081\": \"资兴市\"\n" +
                "  },\n" +
                "  \"431100\": {\n" +
                "    \"431102\": \"零陵区\",\n" +
                "    \"431103\": \"冷水滩区\",\n" +
                "    \"431121\": \"祁阳县\",\n" +
                "    \"431122\": \"东安县\",\n" +
                "    \"431123\": \"双牌县\",\n" +
                "    \"431124\": \"道县\",\n" +
                "    \"431125\": \"江永县\",\n" +
                "    \"431126\": \"宁远县\",\n" +
                "    \"431127\": \"蓝山县\",\n" +
                "    \"431128\": \"新田县\",\n" +
                "    \"431129\": \"江华瑶族自治县\"\n" +
                "  },\n" +
                "  \"431200\": {\n" +
                "    \"431202\": \"鹤城区\",\n" +
                "    \"431221\": \"中方县\",\n" +
                "    \"431222\": \"沅陵县\",\n" +
                "    \"431223\": \"辰溪县\",\n" +
                "    \"431224\": \"溆浦县\",\n" +
                "    \"431225\": \"会同县\",\n" +
                "    \"431226\": \"麻阳苗族自治县\",\n" +
                "    \"431227\": \"新晃侗族自治县\",\n" +
                "    \"431228\": \"芷江侗族自治县\",\n" +
                "    \"431229\": \"靖州苗族侗族自治县\",\n" +
                "    \"431230\": \"通道侗族自治县\",\n" +
                "    \"431281\": \"洪江市\"\n" +
                "  },\n" +
                "  \"431300\": {\n" +
                "    \"431302\": \"娄星区\",\n" +
                "    \"431321\": \"双峰县\",\n" +
                "    \"431322\": \"新化县\",\n" +
                "    \"431381\": \"冷水江市\",\n" +
                "    \"431382\": \"涟源市\"\n" +
                "  },\n" +
                "  \"433100\": {\n" +
                "    \"433101\": \"吉首市\",\n" +
                "    \"433122\": \"泸溪县\",\n" +
                "    \"433123\": \"凤凰县\",\n" +
                "    \"433124\": \"花垣县\",\n" +
                "    \"433125\": \"保靖县\",\n" +
                "    \"433126\": \"古丈县\",\n" +
                "    \"433127\": \"永顺县\",\n" +
                "    \"433130\": \"龙山县\"\n" +
                "  } }";
        final Map<String, Map<String, String>> codeData = (Map<String, Map<String, String>>) JSON.parse(json);
        final int randomNum = getRandomNum(0, 14);
        int i = 0;
        String key = "";
        for (String code : codeData.keySet()) {
            if (i == randomNum){
                key = code;
            }
            i++;
        }
        Map<String, String> map = new HashMap<>();
        final Map<String, String> map2 = codeData.get(key);
        int randomNum2 = getRandomNum(0, map2.size() - 1);
        int j = 0;
        String key2 = "";
        for (String code : map2.keySet()) {
            if (j == randomNum2){
                key2 = code;
            }
            j++;
        }
        map.put(key, key2);
        return map;
    }

    public static void main(String[] args) {
        System.out.println(getRandomAddressCode());
    }
}
