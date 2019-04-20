package com.fanyank.controller;

import com.fanyank.dto.FileTreeNodeDto;
import com.fanyank.dto.ResultDto;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.pojo.Result;
import com.fanyank.pojo.User;
import com.fanyank.service.FileSystemService;
import com.fanyank.util.QiniuUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FileSystemController {
    @Autowired
    private FileSystemService fileSystemService;


    /**
     * 我的网盘
     * @param model
     * @return
     */
    @GetMapping("/file/my")
    public String forwardMyPage(Model model,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        model.addAttribute("token",QiniuUtil.getToken());
        model.addAttribute("userRootFolderId",fileSystemService.getUserRootFolder(user.getId()).getId());
        return "file/my";
    }

    /**
     * 公共网盘
     * @param model
     * @return
     */
    @GetMapping("/file/public")
    public String forwardPublicPage(Model model) {
        model.addAttribute("token", QiniuUtil.getToken());
        return "file/public";
    }

    /**
     * 公共区获取文件数据
     * @param folderId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/file/getData",produces = "application/json;charset=utf-8")
    public String getFolderData(Integer folderId) {
        return fileSystemService.getFolderData(folderId,false);
    }

    /**
     * 私有区获取文件资源
     * @param folderId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/file/getMyData",produces = "application/json;charset=utf-8")
    public String getMyFolderData(Integer folderId) {
        return fileSystemService.getFolderData(folderId,true);
    }

    /**
     * 删除文件
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "file/deletefile",produces = "application/json;charset=utf-8")
    public String deleteFile(Integer id) {
        Gson gson = new Gson();
        Result result = fileSystemService.deleteFile(id);
        if(result.getSuccess()) {
            return gson.toJson(new ResultDto(true));
        } else {
            return gson.toJson(new ResultDto(false,result.getMessage()));
        }
    }

    /**
     * 删除文件夹
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "file/deletefolder",produces = "application/json;charset=utf-8")
    public String deleteFolder(Integer id) {
        Gson gson = new Gson();
        Result result = fileSystemService.deleteFolder(id);
        if(result.getSuccess()) {
            return gson.toJson(new ResultDto(true));
        } else {
            return gson.toJson(new ResultDto(false,result.getMessage()));
        }
    }


    /**
     * 公共区添加文件夹
     * @param folder
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping(value = "file/addFolder",produces = "application/json;charset=utf-8")
    public String addFolder(Folder folder,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        folder.setCreateTime(new Date().getTime());
        folder.setIsPublic(1);
        folder.setUserId(user.getId());
        folder = fileSystemService.addFolder(folder);
        Gson gson = new Gson();
        return gson.toJson(folder);
    }

    /**
     * 私有区添加文件夹
     * @param folder
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping(value = "file/addPrivateFolder",produces = "application/json;charset=utf-8")
    public String addPrivateFolder(Folder folder,HttpSession session) {
        User user = (User) session.getAttribute("current_user");
        folder.setCreateTime(new Date().getTime());
        folder.setIsPublic(0);
        folder.setUserId(user.getId());
        folder = fileSystemService.addFolder(folder);
        Gson gson = new Gson();
        return gson.toJson(folder);
    }


    /**
     * 重命名文件
     * @param file
     * @return
     */
    @ResponseBody
    @GetMapping(value = "file/renamefile",produces = "application/json;charset=utf-8")
    public String renameFile(File file) {
        Gson gson = new Gson();
        File existFile = fileSystemService.getFileById(file.getId());
        if(existFile != null) {
            String fileName = file.getName().trim().split(".")[0];
            fileSystemService.renameFile(file.getId(),fileName);
            ResultDto result = new ResultDto(true);
            return gson.toJson(result);
        } else {
            ResultDto result = new ResultDto(false,"文件不存在，请刷新页面重试");
            return gson.toJson(result);
        }
    }

    /**
     * 重命名文件夹
     * @param folder
     * @return
     */
    @ResponseBody
    @GetMapping(value = "file/renamefolder",produces = "application/json;charset=utf-8")
    public String renameFolder(Folder folder) {
        Gson gson = new Gson();
        Folder existFolder = fileSystemService.getFolderById(folder.getId());
        if(existFolder != null) {
            fileSystemService.renameFolder(folder.getId(),folder.getName());
            ResultDto result = new ResultDto(true);
            return gson.toJson(result);
        } else {
            ResultDto result = new ResultDto(false,"文件夹不存在，请刷新页面重试");
            return gson.toJson(result);
        }
    }

    @ResponseBody
    @GetMapping(value = "file/copy",produces = "application/json;charset=utf-8")
    public String copyTreeNode() {
        return null;
    }

    /**
     * 上传文件
     * @param file
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping(value = "file/createfile",produces = "application/json;charset=utf-8")
    public String createFile(File file, HttpSession session) {
        Gson gson = new Gson();
        User user = (User) session.getAttribute("current_user");
        file.setUserId(user.getId());
        file = fileSystemService.addFile(file);

        FileTreeNodeDto dto = new FileTreeNodeDto(file.getId());
        dto.setType(file.getType());
        dto.setForeignChain(file.getForeignChain());
        dto.setText(file.getName());
        dto.setChildren(false);
        return gson.toJson(dto);
    }

    @ResponseBody
    @GetMapping(value = "file/move",produces = "application/json;charset=utf-8")
    public String moveTreeNode() {
        return null;
    }

}
