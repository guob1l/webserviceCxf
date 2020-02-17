package ws.client;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import org.apache.cxf.endpoint.Client;
import org.apache.ibatis.annotations.Insert;
import ws.bean.MerchantInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//webservice 客户端代码
public class WebserviceClient {


    public static Client getClient(String wsdl){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdl);
        return  client;
    }


    /*
    webservice的bean对象动态调用
    @parameter:instance:ws bean 实例
    @parameter:methodName:调用方法名
    @parameter:methodName:调用方法参数值
    */
    public static Object setter(Object instance,String methodName,String methodValue) throws Exception {
        Method setAddress;
        if(methodName.equals("setId")){
            setAddress= instance.getClass().getMethod(methodName, Integer.class);
            setAddress.invoke(instance, Integer.parseInt(methodValue));
        }else {
            setAddress = instance.getClass().getMethod(methodName, String.class);
            setAddress.invoke(instance, methodValue);
        }
        return instance;
    }
    /*
       webservice的bean对象动态调用
       @parameter:returnObject:ws bean 实例
       @parameter:methodName:调用方法名

       */
  /**
   * @Description:
   * @Param: returnObject webservice的bean对象
   * @Param: methodName 方法名
   * @return: Object
   * @Author: gb
   * @Date: 2020/2/15
   */
    public static Object getter(Object returnObject ,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = returnObject.getClass().getMethod(methodName);
        return method.invoke(returnObject);
    }

   /**
   * @Author: gb
   * @Description:商户新增
   * @Date: 2020/2/15  14:56
   **/
    public static void addMerchantClient(){
        String wsdl = "http://127.0.0.1:8080/webs/addMerchant?wsdl";
        Client client = getClient(wsdl);
        Object[] objects = new Object[0];

        try {
            //打印返回结果
            Object merchantInfo =Thread.currentThread().getContextClassLoader().loadClass("wsadd.webservice.MerchantInfo").newInstance();
            merchantInfo = setter(merchantInfo,"setMerchantNo","000007");
            merchantInfo = setter(merchantInfo,"setCustNo","000007");
            merchantInfo = setter(merchantInfo,"setMerchantName","测试商户7");
            merchantInfo = setter(merchantInfo,"setMerchantAccount","0498007");
            merchantInfo = setter(merchantInfo,"setCreatePerson","郭勃");
            merchantInfo = setter(merchantInfo,"setStatus","1");
            merchantInfo = setter(merchantInfo,"setAddress","建设路7");
            merchantInfo = setter(merchantInfo,"setTelephone","1310010007");
            merchantInfo = setter(merchantInfo,"setCreatePerson","郭勃7");

            //调用webservice服务端方法
            objects = client.invoke("addMerchant", merchantInfo);
            //得到返回结果
            Object merchantResult = objects[0];
            Object flag = getter(merchantResult,"getFlag");
            System.out.println("返回结果:" +(String)flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 * @Description: 商户查找客户端
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2020/2/15
 */
    public static void findMerchants(){
        String wsdl = "http://127.0.0.1:8080/webs/findMerchant?wsdl";
        Client client = getClient(wsdl);
        Object[] objects = new Object[0];

        try {
            Object merchantInfo =Thread.currentThread().getContextClassLoader().loadClass("wsfind.webservice.MerchantInfo").newInstance();
            merchantInfo = setter(merchantInfo,"setMerchantNo","000000");
            //查找商户
            objects = client.invoke("find", merchantInfo);
            Object merchantResult = objects[0];
            for(Object o:(ArrayList)merchantResult){
                String address = (String)getter(o,"getAddress");
                System.out.println(address);
            }
            System.out.println("success");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * @Description: 商户更新
     * @Param:
     * @return:
     * @Author: gb
     * @Date: 2020/2/17
     */
    public static void updateMerchant(){

        String wsdl = "http://127.0.0.1:8080/webs/updateMerchant?wsdl";
        Client client = getClient(wsdl);
        Object[] objects = new Object[0];
        try {
            Object merchantInfo =Thread.currentThread().getContextClassLoader().loadClass("wsupdate.webservice.MerchantInfo").newInstance();
            merchantInfo = setter(merchantInfo,"setId","1");
            merchantInfo = setter(merchantInfo,"setAddress","建设路0号");
            //查找商户
            objects = client.invoke("updateMerchant", merchantInfo);
            Object merchantResult = objects[0];

            String flag = (String)getter(merchantResult,"getFlag");
            System.out.println("flag:"+flag);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @Description: 商户删除
     * @Param:
     * @return:
     * @Author: gb
     * @Date: 2020/2/15
     */
    public static void deleteMerchant(){

        String wsdl = "http://127.0.0.1:8080/webs/deleteMerchant?wsdl";
        Client client = getClient(wsdl);
        Object[] objects = new Object[0];
        try {
            Object merchantInfo =Thread.currentThread().getContextClassLoader().loadClass("wsdelete.webservice.MerchantInfo").newInstance();
            merchantInfo = setter(merchantInfo,"setId","1");
            //删除商户
            objects = client.invoke("deleteMerchant", merchantInfo);
            Object merchantResult = objects[0];

            String flag = (String)getter(merchantResult,"getFlag");
            System.out.println("flag:"+flag);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addMerchantClient();
        //findMerchants();
        //updateMerchant();
        //deleteMerchant();
    }
}
