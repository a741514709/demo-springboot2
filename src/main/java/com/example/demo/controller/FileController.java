package com.example.demo.controller;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;

@Controller
@RequestMapping("/file")
public class FileController {


    // 获得SpringBoot提供的mongodb的GridFS对象
    @Resource
    private GridFsTemplate gridFsTemplate;

    @Qualifier(value = "gridFSBuckets")
    private GridFSBucket gridFSBucket;


    /**
     * 文件上传
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(HttpServletRequest request) throws Exception {
        Part part = request.getPart("file");

        // 获得提交的文件名
        String fileName = part.getSubmittedFileName();
        // 获得文件输入流
        InputStream ins = part.getInputStream();
        // 获得文件类型
        String contentType = part.getContentType();
        // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息

        ObjectId gridFSFile = gridFsTemplate.store(ins, fileName, contentType);

        return gridFSFile;

    }

    //文件下载

    @GetMapping(value = "/downloadFile")
    //TODO 未做完
    public void downloadFile(@RequestParam(name = "fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {

        GridFSFile gfsfile = gridFsTemplate.findOne(query(whereFilename().is(fileName)));

        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gfsfile.getObjectId());
        GridFsResource gridFsResource= new GridFsResource(gfsfile, gridFSDownloadStream);


        if (gfsfile == null) {
            return;
        }

        //处理中文文件名乱码
        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
                request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
                || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            //非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        // 通知浏览器进行文件下载
        response.setContentType(gfsfile.getContentType());
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

        IOUtils.copy(gridFsResource.getInputStream(), response.getOutputStream());
    }




}
