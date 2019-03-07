package test.com.fanyank.service;

import com.fanyank.mapper.TopicMapper;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.pojo.Topic;
import com.fanyank.serviceImpl.FileSystemServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/** 
* FileSystemServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 7, 2019</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:application.xml"})
public class FileSystemServiceImplTest {
    @Autowired
    private FileSystemServiceImpl fileSystemService;
    @Autowired
    private TopicMapper topicMapper;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getRootFolder() 
* 
*/ 
@Test
public void testGetRootFolder() throws Exception { 
//TODO: Test goes here...
    Folder root = fileSystemService.getRootFolder();
    Assert.assertNotNull(root);
} 

/** 
* 
* Method: getUserRootFolder(Integer userId) 
* 
*/ 
@Test
public void testGetUserRootFolder() throws Exception { 
//TODO: Test goes here...
    Folder userRootFolder = fileSystemService.getUserRootFolder(1);
    Assert.assertNotNull(userRootFolder);
} 

/** 
* 
* Method: getFolderById(Integer folderId) 
* 
*/ 
@Test
public void testGetFolderById() throws Exception { 
//TODO: Test goes here...
    Folder folder = fileSystemService.getFolderById(2);
    Assert.assertNotNull(folder);
} 

/** 
* 
* Method: addFolder(Folder folder) 
* 
*/ 
@Test
public void testAddFolder() throws Exception { 
//TODO: Test goes here...
    Folder folder = new Folder();
    folder.setName("img");
    folder.setCreateTime(new Date().getTime());
    folder.setPreFolderId(2);
    folder.setUserId(1);
    fileSystemService.addFolder(folder);
} 

/** 
* 
* Method: addFile(File file) 
* 
*/ 
@Test
public void testAddFile() throws Exception { 
//TODO: Test goes here...
    File file = new File();
    file.setCreateTime(new Date().getTime());
    file.setFolderId(4);
    file.setName("DOM树.png");
    file.setSize(383.53);
    file.setType("png");
    file.setUserId(1);
    file.setForeignChain("http://cdn.fanyank.com/DOM%E6%A0%91.png");
    fileSystemService.addFile(file);

    File file1 = new File();
    file1.setCreateTime(new Date().getTime());
    file1.setFolderId(3);
    file1.setName("ECharge.md");
    file1.setSize(143.43);
    file1.setType("md");
    file1.setUserId(2);
    file1.setForeignChain("http://cdn.fanyank.com/ECharge.md~");
    fileSystemService.addFile(file1);
} 

/** 
* 
* Method: deleteFolder(Folder folder) 
* 
*/ 
@Test
public void testDeleteFolder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteFile(File file) 
* 
*/ 
@Test
public void testDeleteFile() throws Exception { 
//TODO: Test goes here... 
} 


} 
