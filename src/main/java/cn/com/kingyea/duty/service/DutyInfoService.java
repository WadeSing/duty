package cn.com.kingyea.duty.service;

import cn.com.kingyea.duty.bean.DutyInfo;
import cn.com.kingyea.duty.bean.DutyPerson;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DutyInfoService {

    public List<DutyInfo> queryBytime(){

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://68.29.179.176:7008/ManagerService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //参数规定日期格式
        Date date = new Date();

        //设置调用接口方法的参数
        String stationid = "441200100000"; //组织id
        //值班时间
        String watchDate = formatter.format(date);
        //账号
        String userId = "zhaoqing";
        //密码
        String userPw = "ZhaoQingzhzx111";

        //json类型转成实体类型
        /*String str = (String) objects[0];
        List<DutyInfo> list = JSONObject.parseArray(str, DutyInfo.class);*/

        List<DutyInfo> list = new ArrayList<DutyInfo>();

        try {
            QName qname = new QName("http://service.calculate.police.ccf.cn/", "queryReportByTime");
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke(qname, stationid, watchDate, userId, userPw);
            String str = (String) objects[0];
            System.out.println(str);

            JSONArray obj = JSONObject.parseArray(str);
            JSONObject o1 = (JSONObject) obj.get(0);
            if(o1.get("leaderMen") instanceof String) {
                o1.put("leaderMen", new DutyPerson[]{});
            }
            list = JSONObject.parseArray(obj.toJSONString(), DutyInfo.class);
            //list.stream().forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*public static void main(String[] args) {
        String jsonStr = "[\n" +
                "    {\n" +
                "        \"createtime\": \"2017-05-27 17:28\",\n" +
                "        \"director\": \"苏庆平\",\n" +
                "        \"directorJob\": \"科员\",\n" +
                "        \"directorMobilePhone\": \"13822601155\",\n" +
                "        \"directorPhone\": \"07582727110\",\n" +
                "        \"directorPoliceAffair\": \"18023638176\",\n" +
                "        \"directorRegistNum\": \"235006\",\n" +
                "        \"endTime\": \"2017-06-12 20:30:00\",\n" +
                "        \"id\": \"623e1476_425e_4adf_b736_a94d069f4463\",\n" +
                "        \"ifuse\": \"R\",\n" +
                "        \"masterJob\": \"局党委委员\",\n" +
                "        \"masterMobilePhone\": \"13580630033\",\n" +
                "        \"masterName\": \"吴志劲\",\n" +
                "        \"masterPhone\": \"\",\n" +
                "        \"masterPoliceAffair\": \"18023629168\",\n" +
                "        \"masterRegistNum\": \"230021\",\n" +
                "        \"startTime\": \"2017-06-12 14:30:00\",\n" +
                "        \"stationId\": \"441200000000\",\n" +
                "        \"stationName\": \"\",\n" +
                "        \"status\": \"\",\n" +
                "        \"tdirector\": \"\",\n" +
                "        \"tdirectorJob\": \"\",\n" +
                "        \"tdirectorMobilePhone\": \"\",\n" +
                "        \"tdirectorPhone\": \"\",\n" +
                "        \"tdirectorPoliceAffair\": \"\",\n" +
                "        \"tdirectorRegistNum\": \"\",\n" +
                "        \"tmasterJob\": \"\",\n" +
                "        \"tmasterMobilePhone\": \"\",\n" +
                "        \"tmasterName\": \"\",\n" +
                "        \"tmasterPhone\": \"\",\n" +
                "        \"tmasterPoliceAffair\": \"\",\n" +
                "        \"tmasterRegistNum\": \"\",\n" +
                "        \"updatetime\": \"2017-05-27 17:28\",\n" +
                "        \"watchDate\": \"2017-06-12\",\n" +
                "        \"leaderMen\": [\n" +
                "            {\n" +
                "                \"barrierId\": \"623e1476_425e_4adf_b736_a94d069f4463\",\n" +
                "                \"createtime\": \"2017-05-27 17:28\",\n" +
                "                \"id\": \"87fb2c9b_44cd_473c_9a5a_c0ee9dfbe0ab160\",\n" +
                "                \"ifuse\": \"R\",\n" +
                "                \"stationId\": \"441200000000\",\n" +
                "                \"status\": \"\",\n" +
                "                \"updatetime\": \"2017-05-27 17:28\",\n" +
                "                \"watchMen\": \"苏恒\",\n" +
                "                \"watchMenJob\": \"辅警\",\n" +
                "                \"watchMenMobilePhone\": \"13824633338 \",\n" +
                "                \"watchMenPhone\": \"07582727110\",\n" +
                "                \"watchMenPoliceAffair\": \"\",\n" +
                "                \"watchMenRegistNum\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"barrierId\": \"623e1476_425e_4adf_b736_a94d069f4463\",\n" +
                "                \"createtime\": \"2017-05-27 17:28\",\n" +
                "                \"id\": \"24fb8a18_8ba1_4e36_b048_25297c97da7f162\",\n" +
                "                \"ifuse\": \"R\",\n" +
                "                \"stationId\": \"441200000000\",\n" +
                "                \"status\": \"\",\n" +
                "                \"updatetime\": \"2017-05-27 17:28\",\n" +
                "                \"watchMen\": \"邓尚猛\",\n" +
                "                \"watchMenJob\": \"辅警\",\n" +
                "                \"watchMenMobilePhone\": \"13202769346 \",\n" +
                "                \"watchMenPhone\": \"07582727110\",\n" +
                "                \"watchMenPoliceAffair\": \"\",\n" +
                "                \"watchMenRegistNum\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"barrierId\": \"623e1476_425e_4adf_b736_a94d069f4463\",\n" +
                "                \"createtime\": \"2017-05-27 17:28\",\n" +
                "                \"id\": \"3d852b8d_724c_4b62_ab51_deed6e52882b159\",\n" +
                "                \"ifuse\": \"R\",\n" +
                "                \"stationId\": \"441200000000\",\n" +
                "                \"status\": \"\",\n" +
                "                \"updatetime\": \"2017-05-27 17:28\",\n" +
                "                \"watchMen\": \"梁婵姬\",\n" +
                "                \"watchMenJob\": \"科员\",\n" +
                "                \"watchMenMobilePhone\": \"13822692971\",\n" +
                "                \"watchMenPhone\": \"07582727110\",\n" +
                "                \"watchMenPoliceAffair\": \"18023629679\",\n" +
                "                \"watchMenRegistNum\": \"235690\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"barrierId\": \"623e1476_425e_4adf_b736_a94d069f4463\",\n" +
                "                \"createtime\": \"2017-05-27 17:28\",\n" +
                "                \"id\": \"b70633ed_90a1_4fa2_8c32_9bcb2afb7d0b161\",\n" +
                "                \"ifuse\": \"R\",\n" +
                "                \"stationId\": \"441200000000\",\n" +
                "                \"status\": \"\",\n" +
                "                \"updatetime\": \"2017-05-27 17:28\",\n" +
                "                \"watchMen\": \"谢志成\",\n" +
                "                \"watchMenJob\": \"辅警\",\n" +
                "                \"watchMenMobilePhone\": \"13413824321 \",\n" +
                "                \"watchMenPhone\": \"07582727110\",\n" +
                "                \"watchMenPoliceAffair\": \"\",\n" +
                "                \"watchMenRegistNum\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"barrierId\": \"623e1476_425e_4adf_b736_a94d069f4463\",\n" +
                "                \"createtime\": \"2017-05-27 17:28\",\n" +
                "                \"id\": \"4b300a4b_a240_4eed_8fe2_b553bddece52163\",\n" +
                "                \"ifuse\": \"R\",\n" +
                "                \"stationId\": \"441200000000\",\n" +
                "                \"status\": \"\",\n" +
                "                \"updatetime\": \"2017-05-27 17:28\",\n" +
                "                \"watchMen\": \"蓝康年\",\n" +
                "                \"watchMenJob\": \"辅警\",\n" +
                "                \"watchMenMobilePhone\": \"13727281008 \",\n" +
                "                \"watchMenPhone\": \"07582727110\",\n" +
                "                \"watchMenPoliceAffair\": \"\",\n" +
                "                \"watchMenRegistNum\": \"\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        List<DutyInfo> list = JSONObject.parseArray(jsonStr, DutyInfo.class);
        list.stream().forEach(System.out::println);
    }*/

}