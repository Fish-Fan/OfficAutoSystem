package com.fanyank.serviceImpl;

import com.fanyank.dto.FileTreeNodeDto;
import com.fanyank.mapper.FileMapper;
import com.fanyank.mapper.FolderMapper;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.service.FileSystemService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public void addFolder(Folder folder) {
        folderMapper.insert(folder);
    }

    @Override
    public void addFile(File file) {
        fileMapper.insert(file);
    }

    @Override
    public void deleteFolder(Folder folder) {
        folderMapper.deleteByPrimaryKey(folder.getId());
    }

    @Override
    public void deleteFile(File file) {
        fileMapper.deleteByPrimaryKey(file.getId());
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
            tempNode.setId(file.getId()+10);
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
            list.add(tempNode);
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @Override
    public void deleteFile(Integer fileId) {

    }

    @Override
    public void deleteFolder(Integer folderId) {

    }

    @Override
    public void renameFile(Integer fileId) {

    }

    @Override
    public void renameFolder(Integer folderId) {

    }

    @Override
    public void createFile(File file) {
        fileMapper.insert(file);
    }

    @Override
    public void createFolder(Folder folder) {

    }



}
