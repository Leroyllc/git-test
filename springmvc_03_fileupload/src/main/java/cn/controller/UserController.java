package cn.controller;


import cn.exception.SysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.spi.DirObjectFactory;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/fileupload1")
    public String fileupload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
//        使用fileupload组件上传文件
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        //判断该路径是否存在
        if (!file.exists()) {
            //创建该路径
            file.mkdirs();
        }

        //解析request对象，获取上传文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析request
        List<FileItem> items = upload.parseRequest(request);

        //遍历
        for (FileItem item : items) {
            //进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                //说明普通表单项
            } else {
                //说明是上传文件项
                //获取上传文件的名称
                String fileName = item.getName();

                String uuid = UUID.randomUUID().toString().replace("-", "");

                fileName = uuid + fileName;
                //完成文件上传
                item.write(new File(path, fileName));
                //删除临时文件
                item.delete();
            }
        }

        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");
//        使用fileupload组件上传文件
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        //判断该路径是否存在
        if (!file.exists()) {
            //创建该路径
            file.mkdirs();
        }

        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().replace("-", "");

        fileName = uuid + fileName;
        //完成文件上传
        upload.transferTo(new File(path,fileName));

        return "success";
    }

    @RequestMapping("/fileupload3")
    public String fileupload(MultipartFile upload) throws Exception {
        System.out.println("springmvc文件跨服务器上传...");
//        使用fileupload组件上传文件
        //上传的位置
        String path = "http://localhost:8080/uploads/";
        File file = new File(path);
        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().replace("-", "");

        fileName = uuid + fileName;
        //上传文件
        //创建客户端对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);

        //上传文件
        webResource.put(upload.getBytes());

        return "success";
    }

    @RequestMapping("/testException")
    public String  testException() throws SysException {
        System.out.println("testException");
        try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("自定义错误");
        }
        return "error";
    }

    @RequestMapping("/testInterception")
    public String  testInterception(){
        System.out.println("testInterception");

        return "success";
    }
}
