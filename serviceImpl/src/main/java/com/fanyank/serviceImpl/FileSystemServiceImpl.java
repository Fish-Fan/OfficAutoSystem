package com.fanyank.serviceImpl;

import com.fanyank.dto.FileTreeNodeDto;
import com.fanyank.mapper.FileMapper;
import com.fanyank.mapper.FolderMapper;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.pojo.Result;
import com.fanyank.service.FileSystemService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FileSystemServiceImpl implements FileSystemService {
    @Autowired
    private FolderMapper folderMapper;
    @Autowired
    private FileMapper fileMapper;

    @Override
    public Folder getRootFolder() {
        return folderMapper.getRootFolder();
    }

    @Override
    public Folder getUserRootFolder(Integer userId) {
        return folderMapper.getUserRootFolder(userId);
    }

    @Override
    public Folder getFolderById(Integer folderId) {
        return folderMapper.selectByPrimaryKey(folderId);
    }

    @Override
    public Folder addFolder(Folder folder) {
        folderMapper.insert(folder);
        return folder;
    }

    @Override
    public File addFile(File file) {
        fileMapper.insert(file);
        return file;
    }


    @Override
    public String getFolderData(Integer folderId) {
        Folder folder = folderMapper.selectByPrimaryKey(folderId);
        List<File> fileList = folder.getFiles();
        List<Folder> folderList = folder.getFolders();

        List<FileTreeNodeDto> list = new ArrayList<>();
        for(File file : fileList) {
            FileTreeNodeDto tempNode = new FileTreeNodeDto();
            tempNode.setChildren(false);
            tempNode.setId(file.getId());
            tempNode.setText(file.getName());
            tempNode.setType(file.getType());
            tempNode.setForeignChain(file.getForeignChain());
            list.add(tempNode);
        }
        for(Folder folder1 : folderList) {
            FileTreeNodeDto tempNode = new FileTreeNodeDto();
            tempNode.setChildren(true);
            tempNode.setId(folder1.getId());
            tempNode.setText(folder1.getName());
            tempNode.setType("folder");
            list.add(tempNode);
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @Override
    public Result deleteFile(Integer fileId) {
        File existFile = fileMapper.selectByPrimaryKey(fileId);
        if(existFile != null) {
            fileMapper.deleteByPrimaryKey(fileId);
            return new Result(true);
        } else {
            return new Result(false,"找不到该文件");
        }
    }

    @Override
    public Result deleteFolder(Integer folderId) {
        Folder existFolder = folderMapper.selectByPrimaryKey(folderId);
        if(existFolder != null) {
            folderMapper.deleteByPrimaryKey(folderId);
            return new Result(true);
        } else {
            return new Result(false,"找不到该文件夹");
        }
    }

    @Override
    public void renameFile(Integer fileId,String name) {
        File file = fileMapper.selectByPrimaryKey(fileId);
        file.setName(name);
        file.setUpdateTime(new Date().getTime());
        fileMapper.updateByPrimaryKey(file);
    }

    @Override
    public void renameFolder(Integer folderId,String name) {
        Folder folder = folderMapper.selectByPrimaryKey(folderId);
        folder.setName(name);
        folder.setUpdateTime(new Date().getTime());
        folderMapper.updateByPrimaryKey(folder);
    }


    @Override
    public File getFileById(Integer fileId) {
        return fileMapper.selectByPrimaryKey(fileId);
    }


}
